USE transactions;

DELIMITER //

CREATE PROCEDURE transferMoney2_3()
BEGIN
    DECLARE v_balance DECIMAL(10,2);

    -- nếu có lỗi SQL thì rollback
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    -- kiểm tra số dư tài khoản nguồn (accountID = 2)
    SELECT balance
    INTO v_balance
    FROM accounts
    WHERE accountID = 2
        FOR UPDATE;

    -- nếu số dư >= 1.000.000
    IF v_balance >= 1000000 THEN

        -- trừ tiền tài khoản 2
        UPDATE accounts
        SET balance = balance - 1000000
        WHERE accountID = 2;

        -- cộng tiền tài khoản 3
        UPDATE accounts
        SET balance = balance + 1000000
        WHERE accountID = 3;

        COMMIT;

    ELSE
        ROLLBACK;
    END IF;

END//

DELIMITER ;


call transferMoney2_3();

select *from transactions;
select *from accounts;