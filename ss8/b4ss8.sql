use demo;
select * from orders;
DELIMITER //

CREATE PROCEDURE sp_check_order_value(in totalAmout double)
BEGIN
    DECLARE highPrice DOUBLE;
    DECLARE ranked VARCHAR(50);

SELECT totalAmount
INTO highPrice
FROM orders
 WHERE orderId = 105;

    IF highPrice > 500000 THEN
        SET ranked = 'don hang gia tri cao';
    ELSE
        SET ranked = 'don hang thuong';
    END IF;

    SELECT ranked AS ket_qua;
END //

DELIMITER ;

CALL sp_check_order_value(800000);

drop PROCEDURE sp_check_order_value;
