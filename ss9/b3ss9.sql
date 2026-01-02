USE session_09;
-- Viết Stored Procedure GetCustomerByPhone:
DELIMITER //
create procedure GetCustomerByPhone(IN Phone int)
begin
    select * from customers
        where PhoneNumber = Phone;
end //
DELIMITER ;

 -- Viết Stored Procedure GetTotalBalance
DELIMITER //
create procedure GetTotalBalance(IN customerID_in int, out totalBalance double )
begin
    select sum(Balance) into totalBalance
    from accounts
        where CustomerID = customerID_in;
end //
DELIMITER ;
drop procedure GetTotalBalance;
-- Viết Stored Procedure IncreaseEmployeeSalary:
DELIMITER //
create procedure IncreaseEmployeeSalary(INOUT cr_salary int, in EmployeeID_in int)
begin
    set cr_salary = cr_salary*1.1;
    update employees
        set salary = cr_salary
    where EmployeeID_in;

end //
DELIMITER ;


-- thuc thi cac thu tuc
call GetCustomerByPhone('0901234567');
call GetTotalBalance(1,@totalBalance );
select @totalBalance ;
call  IncreaseEmployeeSalary(@session, 3);

select Salary into @session
from employees
where EmployeeID =3;

select @session;

DROP PROCEDURE IF EXISTS  GetCustomerByPhone;
DROP PROCEDURE IF EXISTS IncreaseEmployeeSalary;
DROP PROCEDURE IF EXISTS  GetTotalBalance;