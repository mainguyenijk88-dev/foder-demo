use ecommerce;

DELIMITER //

CREATE PROCEDURE sp_create_order(
    IN p_customer_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_price DECIMAL(10,2)
)
BEGIN
    DECLARE v_stock INT;
    DECLARE v_order_id INT;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    -- Kiểm tra tồn kho
    SELECT stock_quantity
    INTO v_stock
    FROM inventory
    WHERE product_id = p_product_id
        FOR UPDATE;

    IF v_stock < p_quantity THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Khong du hang trong kho';
    END IF;

    -- Tạo order mới
    INSERT INTO orders(customer_id)
    VALUES (p_customer_id);

    SET v_order_id = LAST_INSERT_ID();

    -- Thêm order item
    INSERT INTO order_items(order_id, product_id, quantity, price)
    VALUES (v_order_id, p_product_id, p_quantity, p_price);

    -- Trừ kho
    UPDATE inventory
    SET stock_quantity = stock_quantity - p_quantity
    WHERE product_id = p_product_id;

    COMMIT;
END //

DELIMITER ;

-- tao sp_pay_order:
DELIMITER //

CREATE PROCEDURE sp_pay_order(
    IN p_order_id INT,
    IN p_payment_method ENUM('Credit Card','PayPal','Bank Transfer','Cash')
)
BEGIN
    DECLARE v_status VARCHAR(20);
    DECLARE v_total DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    SELECT status, total_amount
    INTO v_status, v_total
    FROM orders
    WHERE order_id = p_order_id
        FOR UPDATE;

    IF v_status <> 'Pending' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Don hang khong o trang thai Pending';
    END IF;

    INSERT INTO payments(order_id, amount, payment_method, status)
    VALUES (p_order_id, v_total, p_payment_method, 'Completed');

    UPDATE orders
    SET status = 'Completed'
    WHERE order_id = p_order_id;

    COMMIT;
END //

DELIMITER ;

-- tao sp_cancel_order
DELIMITER //

CREATE PROCEDURE sp_cancel_order(
    IN p_order_id INT
)
BEGIN
    DECLARE v_status VARCHAR(20);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    SELECT status
    INTO v_status
    FROM orders
    WHERE order_id = p_order_id
        FOR UPDATE;

    IF v_status <> 'Pending' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Chi duoc huy don hang Pending';
    END IF;

    -- Hoàn kho
    UPDATE inventory i
        JOIN order_items oi ON i.product_id = oi.product_id
    SET i.stock_quantity = i.stock_quantity + oi.quantity
    WHERE oi.order_id = p_order_id;

    -- Xóa order items
    DELETE FROM order_items
    WHERE order_id = p_order_id;

    -- Cập nhật trạng thái
    UPDATE orders
    SET status = 'Cancelled'
    WHERE order_id = p_order_id;

    COMMIT;
END //

DELIMITER ;

-- xoa cac thu tuc
DROP PROCEDURE sp_create_order;
DROP PROCEDURE sp_pay_order;
DROP PROCEDURE sp_cancel_order;