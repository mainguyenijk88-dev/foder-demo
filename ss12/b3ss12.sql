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

delimiter //
create procedure sp_update_order_status_with_payment
    (in in_order_id INT, in new_status VARCHAR(50),
     in payment_amount decimal(10,2), in in_payment_method varchar(50))
begin
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
ROLLBACK;
  END;
start transaction ;
if (select status from orders where order_id= in_order_id) = new_status then
    rollback;
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT ='trang thai moi da giong voi trang thai cu';
elseif
 new_status = 'Completed' then
    insert into payments(order_id,payment_date,amount, payment_method, status)
        values (in_order_id,now(), payment_amount,
                in_payment_method, new_status);
    update orders
    set status = new_status
    where order_id = in_order_id;
    commit ;
    else
    rollback ;
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'trang thai don hang ko fai Completed';
        end if ;
end //
delimiter ;

call sp_update_order_status_with_payment(1, 'Pending',
                                         2000000.00, 'Credit Card');

drop Trigger before_insert_check_payment;
drop Trigger after_update_order_status;
drop procedure sp_update_order_status_with_payment;