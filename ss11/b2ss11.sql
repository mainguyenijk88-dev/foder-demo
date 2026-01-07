use transactions;

delimiter //
create procedure takeMoney(in in_accountID  int, in amount int)
begin
    START TRANSACTION;
if (select balance from accounts where accountID = in_accountID) < 0 then
    rollback ;
    else
        UPDATE accounts
        SET balance = balance - amount
        WHERE accountID = in_accountID;

        COMMIT;

end if ;

end //
delimiter ;

drop procedure takeMoney;

call takeMoney(2,100000);

select accountID,balance from accounts
where accountID =2;

-- neu so du <0 rollback

