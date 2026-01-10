CREATE DATABASE employee_management;
USE employee_management;
-- tao Trigger BEFORE INSERT
DELIMITER //

CREATE TRIGGER trg_before_insert_employee_email
    BEFORE INSERT ON employees
    FOR EACH ROW
BEGIN
    IF NEW.email NOT LIKE '%@company.com' THEN
        SET NEW.email = CONCAT(NEW.email, '@company.com');
    END IF;
END //

DELIMITER ;

drop trigger trg_before_insert_employee_email;
-- Trigger AFTER INSERT
DELIMITER //

CREATE TRIGGER trg_after_insert_employee_salary
    AFTER INSERT ON employees
    FOR EACH ROW
BEGIN
    INSERT INTO salaries (employee_id, base_salary, bonus)
    VALUES (NEW.employee_id, 10000.00, 0);
END;
//

DELIMITER ;

INSERT INTO departments (department_name)
VALUES ('IT');

INSERT INTO employees (name, email, hire_date, department_id)
VALUES ('Nguyen Van A', 'nguyenvana', '2025-01-01', 1);

-- before_update
DELIMITER //

CREATE TRIGGER trg_before_update_attendance_hours
    BEFORE UPDATE ON attendance
    FOR EACH ROW
BEGIN
    IF NEW.check_out_time IS NOT NULL THEN
        SET NEW.total_hours =
                TIMESTAMPDIFF(MINUTE, NEW.check_in_time, NEW.check_out_time) / 60;
    END IF;
END;
//

DELIMITER ;

INSERT INTO attendance (employee_id, check_in_time)
VALUES
    (1, '2025-01-10 08:30:00');


UPDATE attendance
SET check_out_time = '2025-01-10 17:30:00'
WHERE attendance_id = 1;











