use transactions;

insert into accounts( accountID, balance) values (3, 500000
);

delimiter //
create procedure checkBalance(IN in_accountID INT, IN IN_AMOUNT INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            -- Có lỗi thì rollback
            ROLLBACK;
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Có lỗi xảy ra, giao dịch đã bị hủy';
        END;

    START TRANSACTION;
    UPDATE accounts
        SET balance = balance+IN_AMOUNT
    WHERE accountID = in_accountID;

    INSERT INTO transactions (TOACCOUNTID, AMOUNT, TRANSACTIONDATE)
        VALUES (in_accountID, IN_AMOUNT, NOW() );
COMMIT ;
end //

DELIMITER ;


DROP PROCEDURE checkBalance;
CALL checkBalance(3, 900000);