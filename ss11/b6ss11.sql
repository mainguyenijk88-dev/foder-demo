use transactions;

select *from accounts;

DELIMITER //

CREATE PROCEDURE transferMoney3to2( in sender_accountID int, in receiver_accountID int, in in_amount int )
BEGIN
    -- nếu có lỗi thì rollback
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;

    -- Trừ tiền tài khoản gửi
    UPDATE accounts
    SET balance = balance - in_amount
    WHERE accountID = sender_accountID;

    -- Cộng tiền tài khoản nhận
    UPDATE accounts
    SET balance = balance + in_amount
    WHERE accountID = receiver_accountID;

    -- Ghi lịch sử giao dịch
    INSERT INTO transactions(fromAccountID, toAccountID, amount, transactionDate)
    VALUES (sender_accountID, receiver_accountID, in_amount, NOW());

    -- Nếu tất cả thành công
    COMMIT;
END //

DELIMITER ;
drop procedure transferMoney3to2;
call transferMoney3to2( 3,2,1000000);

select * from accounts;
select *from transactions;

