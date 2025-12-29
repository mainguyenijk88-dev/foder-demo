use qlnv;
create table employees (
                           emp_id int primary key,            -- Khóa chính: ID nhân viên
                           full_name varchar(100),            -- Họ và tên nhân viên
                           department varchar(50),            -- Phòng ban
                           salary decimal(10, 2)              -- Lương (2 chữ số thập phân)
);
delimiter //
create  Procedure sp_get_avg_salary()
    begin
        declare avg_salary double;
set avg_salary = (SELECT AVG(salary) AS luong_trung_binh
FROM employees);
        select avg_salary;
end //
delimiter ;
call sp_get_avg_salary();
-- tính lương trung bình của employees



select*from employees;