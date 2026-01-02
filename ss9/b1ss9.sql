
CREATE DATABASE session_09;
USE session_09;
-- tao view EmployeeBranch
create view  EmployeeBranch
as select e.EmployeeID, e.FullName, e.Position, e.Salary,
           e.HireDate, b.BranchName, b.Location
    from employees e join branch b on e.BranchID = b.BranchID;
-- tao view  HighSalaryEmployees
create view HighSalaryEmployees
as select  e.FullName, e.Salary
from employees e
where e.Salary >= 15000000;

-- hien thi view
select * from EmployeeBranch;
 select *from  HighSalaryEmployees;

-- cap nhat view employees
alter view EmployeeBranch
    as select e.EmployeeID, e.FullName, e.Position, e.Salary,
              e.HireDate, b.BranchName, b.Location, b.phoneNumber
       from employees e join branch b on e.BranchID = b.BranchID;

-- xoa nhan vien cua chi nhanh hn
DELETE FROM  EmployeeBranch
where BranchName = 'Chi nhánh Hà Nội';

DELETE FROM employees
where BranchID = (select BranchID from branch where BranchName = 'Chi nhánh Hà Nội');


select * from employees;