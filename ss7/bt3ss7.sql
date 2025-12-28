use qlnv;
create table employees (
                           emp_id int primary key,            -- Khóa chính: ID nhân viên
                           full_name varchar(100),            -- Họ và tên nhân viên
                           department varchar(50),            -- Phòng ban
                           salary decimal(10, 2)              -- Lương (2 chữ số thập phân)
);
create index idx_department
on  employees (department)

