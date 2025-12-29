use qlhs;
select *from students;

DELIMITER //

CREATE PROCEDURE sp_classify_student(
    IN p_studentID INT,
    OUT p_ranked VARCHAR(50)
)
BEGIN
    DECLARE v_score DOUBLE;

    SELECT score
    INTO v_score
    FROM students
    WHERE studentID = p_studentID;

    CASE
        WHEN v_score < 5.0 THEN
            SET p_ranked = 'hoc luc yeu';
        WHEN v_score <= 6.5 THEN
            SET p_ranked = 'hoc luc trung binh';
        WHEN v_score <= 8.0 THEN
            SET p_ranked = 'hoc luc kha';
        ELSE
            SET p_ranked = 'hoc luc gioi';
        END CASE;
END //

DELIMITER ;
drop PROCEDURE sp_classify_student;
SET @ranked = 'hoc luc gioi';

call sp_classify_student(11, @ranked);
SELECT @ranked;
