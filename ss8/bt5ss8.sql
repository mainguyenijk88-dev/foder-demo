use qlnv;
select * from employees;

DELIMITER //

CREATE PROCEDURE sp_check_employee_income(IN p_empId INT)
BEGIN
    DECLARE v_salary DOUBLE;
    DECLARE ranked VARCHAR(50);

    SELECT salary
    INTO v_salary
    FROM employees
    WHERE emp_id = p_empId;

    IF v_salary < 10000000 THEN
        SET ranked = 'thu nhap thap';
    ELSEIF v_salary <= 15000000 THEN
        SET ranked = 'thu nhap trung binh';
    ELSE
        SET ranked = 'thu nhap cao';
    END IF;

    SELECT ranked AS ket_qua;
END //

DELIMITER ;

call sp_check_employee_income(15)
