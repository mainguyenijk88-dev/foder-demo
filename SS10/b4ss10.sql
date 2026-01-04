USE qlnv;
create table salary_logs(
changid int primary key auto_increment,
    i_employeeid int,
FOREIGN KEY(i_employeeid) references employees(emp_id),
    old_salary double,
    new_salary double,
    changeDate datetime
);

drop table salary_logs;

delimiter //
create trigger trg_after_update_salary
after update on employees for each row

begin
insert into salary_logs( i_employeeid,old_salary,new_salary,changeDate )
values ( i_employeeid,old.salary, new.salary, now() );

end //

DELIMITER ;

update employees
set salary =15000000
where emp_id=1;