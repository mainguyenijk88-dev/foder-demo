use qlnv;
SELECT * FROM qlnv.employees;
alter table employees
add cmnd int;

create view v_employee_public
    as select emp_id, full_name, department
from employees