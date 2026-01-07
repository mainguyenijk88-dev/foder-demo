use transactions;

DELIMITER $$

CREATE PROCEDURE transfer_money()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    -- Trừ tiền tk A
    UPDATE accounts
    SET balance = balance - 300000
    WHERE accountID = 1
      AND balance >= 300000;

    IF ROW_COUNT() = 0 THEN
        ROLLBACK;
    END IF;

    -- Cộng tiền tk B
    UPDATE accounts
    SET balance = balance + 300000
    WHERE accountID = 2;

    IF ROW_COUNT() = 0 THEN
        ROLLBACK;
    END IF;

    -- Lưu lịch sử
    INSERT INTO transactions (fromAccountID, toAccountID, amount, transactionDate)
    VALUES (1, 2, 300000, NOW());

    COMMIT;
END$$

DELIMITER ;

CALL transfer_money();

select *from accounts;


select * from transactions;