CREATE DATABASE ecommerce;
USE ecommerce;

delimiter //
create trigger BEFORE_INSERT
    before insert
    on order_items
    for each row
begin
    declare v_stock int;
-- lay so luong ton kho cua san pham
    select stock_quantity
    into v_stock
    from inventory
    where product_id = NEW.product_id;
-- neu ton khoi ko du thi bao loi
    if v_stock < NEW.quantity then
        signal sqlstate '45000'
            set message_text = 'ko du so luong ton kho';

    end if;
end //
delimiter ;
-- chen du lieu cho bang customers
INSERT INTO customers (name, email, phone, address)
VALUES ('Nguyen Van A', 'a@gmail.com', '0901111111', 'Ha Noi'),
       ('Tran Thi B', 'b@gmail.com', '0902222222', 'Ho Chi Minh');
-- chen du lieu cho bang products
INSERT INTO products (name, price, description)
VALUES ('Laptop', 15000000, 'Laptop van phong'),
       ('Mouse', 300000, 'Chuot khong day'),
       ('Keyboard', 500000, 'Ban phim co');
-- chen du lieu cho bang inventory
INSERT INTO inventory (product_id, stock_quantity)
VALUES (1, 10), -- Laptop
       (2, 50), -- Mouse
       (3, 30);
-- Keyboard
--  chen du lieu bang orders
INSERT INTO orders (customer_id, status)
VALUES (1, 'Pending'),
       (2, 'Completed');

-- chen order_items
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES (1, 1, 1, 15000000), -- 1 Laptop
       (1, 2, 2, 300000);

-- chen payment
INSERT INTO payments (order_id, amount, payment_method, status)
VALUES (2, 15000000, 'Credit Card', 'Completed');
-- test before insert
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES (1, 1, 100, 15000000); -- số lượng > tồn kho



-- tao Trigger AFTER INSERT

delimiter //
create trigger AFTER_INSERT
    after insert on order_items
    for each row
    begin
        update orders
            set total_amount = sum(quantity*price)
        where order_id= NEW.order_id;

    end //
    delimiter ;
-- test after insert
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES (1, 3, 1, 500000);

-- tao triger before update
delimiter //
create Trigger BEFORE_UPDATE
before update on order_items
    for each row
begin
    declare v_stock int;
-- lay so luong ton kho cua san pham
    select stock_quantity
    into v_stock
    from inventory
    where product_id = NEW.product_id;
-- neu ton khoi ko du thi bao loi
    if v_stock < NEW.quantity then
        signal sqlstate '45000'
            set message_text = 'ko du so luong ton kho';

    end if;
end //
delimiter ;
-- tao Trigger AFTER UPDATE:
delimiter //
create Trigger AFTER_UPDATE
    after update on order_items
    for each row
begin
    update orders
    set total_amount = sum(NEW.quantity*NEW.price)
    where order_id= NEW.order_id;

end //
delimiter ;

-- tao Trigger BEFORE DELETE:
delimiter //
create Trigger BEFORE_DELETE
    before delete on orders for each row
    begin
        IF  (SELECT status FROM orders  WHERE order_id = old.order_id )= 'Completed'
then signal sqlstate '45000'

         set message_text = 'ko the xoa don hang co trang thai completed';
end if;
    end //

delimiter ;
-- tao Trigger AFTER DELETE:
delimiter //
create Trigger AFTER_DELETE
    after delete on order_items
    for each row
    begin
        update  inventory
            set stock_quantity =stock_quantity+old.quantity
        where product_id = old.product_id;
    end //
    delimiter ;

drop trigger AFTER_INSERT;
drop trigger AFTER_DELETE;
drop trigger BEFORE_INSERT;
drop trigger BEFORE_DELETE;
drop trigger BEFORE_UPDATE;
drop trigger AFTER_UPDATE;