CREATE SCHEMA qlsv;
use qlsv;

create table students
(
    student_id   int,
    student_name varchar(50),
    birthYears   date,
    class        varchar(10),
    address varchar(150)
);

INSERT INTO students (student_id, student_name, birthYears, class, address)
VALUES
    (1, 'Nguyễn Văn An', '2003-05-12', 'CTK43', 'Hà Nội'),
    (2, 'Trần Thị Bình', '2002-09-20', 'CTK43', 'Hải Phòng'),
    (3, 'Lê Văn Cường', '2003-01-15', 'CTK44', 'Nam Định'),
    (4, 'Phạm Thị Dung', '2002-12-02', 'CTK44', 'Thái Bình'),
    (5, 'Hoàng Văn Em', '2003-07-08', 'CTK45', 'Thanh Hóa'),
    (6, 'Đỗ Thị Hoa', '2002-03-25', 'CTK45', 'Nghệ An'),
    (7, 'Vũ Văn Khánh', '2003-11-18', 'CTK46', 'Hà Nam'),
    (8, 'Bùi Thị Lan', '2002-06-30', 'CTK46', 'Quảng Ninh');

create view v_student_basic
as select student_id,student_name, class
   from students;
select *from v_student_basic