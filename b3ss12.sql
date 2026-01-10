use ecommerce;
CREATE TABLE order_logs
(

    log_id     INT PRIMARY KEY AUTO_INCREMENT,

    order_id   INT NOT NULL,

    old_status ENUM ('Pending', 'Completed', 'Cancelled'),

    new_status ENUM ('Pending', 'Completed', 'Cancelled'),

    log_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (order_id) REFERENCES orders (order_id)

);

delimiter //
create Trigger before_insert_check_payment
    before insert
    on payments
    for each row
begin
    if (select amount from payments where payment_id = new.payment_id) <>
       (select total_amount from orders where order_id = NEW.order_id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'so tien thanh toan ko khop voi tong tien don hang';
    end if;
end//
delimiter ;

delimiter //
create trigger after_update_order_status
    after update
    on orders
    for each row
begin
    if (select old.status from orders where order_id = new.order_id) <>
       (select new.status from orders where order_id = old.order_id) then
        insert into order_logs(order_id, old_status, new_status, log_date)
        values (new.order_id, old.status, new.status, now());
    end if;
end //
delimiter ;
drop trigger after_update_order_status;
update orders
set status ='Completed'
where order_id = 1;

delimiter $$
create procedure sp_update_order_status_with_payment(
    in order_id_in int,
    in new_status_in varchar(50),
    in payment_amount_in int,
    in payment_method_in varchar(50))
begin
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            -- Có lỗi thì rollback
            ROLLBACK;
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Có lỗi xảy ra, giao dịch đã bị hủy';
        END;
    BEGIN
        IF (select status
            from orders where order_id = order_id_in) = new_status_in
        then
            rollback;
            signal sqlstate '45000' set message_text = 'Trạng thái đơn hàng không thay đổi';
        elseif (new_status_in) = 'Completed'
        then
            insert into payments (order_id, payment_date, amount, payment_method, status)
            VALUES (
                       order_id_in,
                       now(),
                       payment_amount_in,
                       payment_method_in,
                       new_status_in
                   );
            update orders
            set status = new_status_in
            where order_id = order_id_in;
            commit;
        else
            rollback;
            signal sqlstate '45000' set message_text = 'Trạng thái đơn hàng không phải Completed';
        end if;
    end;
end $$
delimiter ;
call sp_update_order_status_with_payment(3, 'Completed',
                                         1000000.00, 'Credit Card');
insert into orders
values (3,2,'2026-01-01',1000000,'Pending');

drop Trigger before_insert_check_payment;
drop Trigger after_update_order_status;
drop procedure sp_update_order_status_with_payment;