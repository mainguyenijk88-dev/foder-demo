create schema transactions;
use transactions;
CREATE TABLE accounts (
                          accountID INT PRIMARY KEY,
                          balance DECIMAL(10,2) NOT NULL
);

CREATE TABLE transactions (
                              transactionID INT PRIMARY KEY AUTO_INCREMENT,
                              fromAccountID INT  ,
                              toAccountID INT NOT NULL,
                              amount DECIMAL(10,2) NOT NULL,
                              transactionDate DATETIME NOT NULL,

                              CONSTRAINT fk_from_account
                                  FOREIGN KEY (fromAccountID)
                                      REFERENCES accounts(accountID),

                              CONSTRAINT fk_to_account
                                  FOREIGN KEY (toAccountID)
                                      REFERENCES accounts(accountID)
);


insert into  accounts(accountID, balance)
values (1, 1000000), (2, 2000000);

select accountID,balance
from accounts
    where accountID =1;

delimiter //
create procedure sendMoney(in in_accountID  int, in amount int)
begin
START TRANSACTION;

UPDATE accounts
SET balance = balance + amount
WHERE accountID = in_accountID;

COMMIT;
end //
delimiter ;

drop procedure sendMoney;

call sendMoney(1,1000000);

select accountID,balance from accounts
where accountID =1;
