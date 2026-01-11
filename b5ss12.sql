use employee_management;

delimiter //
create Procedure IncreaseSalary(in i_employee_id int, in i_new_salary decimal(10,2), in i_reason text)
begin
START TRANSACTION;
if not exists(select * from employees where employee_id = i_employee_id) then
   rollback;

else
update salaries
set base_salary = i_new_salary
where employee_id = i_employee_id;
    insert into
salary_history( employee_id, old_salary, new_salary, reason)
    values (i_employee_id,  null , i_new_salary, i_reason);

commit;

end if ;
   end //
    delimiter ;

delimiter //
create Procedure DeleteEmployee( in  i_employee_id int)

begin
    start transaction ;
    if not exists(select * from employees where employee_id = i_employee_id) then
        rollback;
        else
        delete from employees where employee_id = i_employee_id;
        delete from salaries where employee_id = i_employee_id;
        commit ;
    end if ;
end //
delimiter ;

call IncreaseSalary(1,11000, 'work hard');
call DeleteEmployee(1); -- ko the xoa vi co khoa ngoai