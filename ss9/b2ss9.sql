USE session_09;
-- Tạo một Index trên cột PhoneNumber của bảng Customers
create index idx_PhoneNumber
on customers(PhoneNumber);

explain analyze
(select PhoneNumber from customers);
-- -> Covering index scan on customers using PhoneNumber  (cost=0.75 rows=5) (actual time=0.418..0.428 rows=5 loops=1)

-- Tạo một Composite Index trên hai cột BranchID và Salary của bảng Employees
create index idx_BranchID_salary
    on employees(BranchID,Salary);
-- kiem tra xem index co dc su dung hay ko
explain analyze( select BranchID,Salary from employees);
-- -> Covering index scan on employees using idx_BranchID_salary  (cost=0.55 rows=3) (actual time=0.0618..0.0697 rows=3 loops=1)

-- Tạo một Unique Index trên hai cột AccountID và CustomerID của bảng Accounts
create unique index idx_AccountID_CustomerID
on accounts (AccountID,CustomerID);

-- hien thi va xoa idx
show index from customers;
show index  from accounts;
show index from employees;

-- Xóa index trên bảng customers
DROP INDEX idx_PhoneNumber ON customers;

-- Xóa index trên bảng employees
DROP INDEX idx_BranchID_salary ON employees; -- (do co khoa ngoai ne ko the xoa)

-- Xóa unique index trên bảng accounts
DROP INDEX idx_AccountID_CustomerID ON accounts; -- (do co khoa ngoai ne ko the xoa)
