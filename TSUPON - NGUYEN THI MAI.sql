create schema test_module3;
use test_module3;
create table customer(
                         customer_id varchar(5) primary key not null ,
                         customer_fullname varchar(100)not null ,
                         customer_email varchar(100)not null unique ,
                         customer_phone varchar(15)not null ,
                         customer_address varchar(255)not null
);
insert into customer(customer_id, customer_fullname, customer_email, customer_phone, customer_address)
values (1,'Nguyen Anh Tu','tu.nguyen@example.com', '0912345678','Hanoi, Vietnam'),
       (2,'Tran Thi Mai','mai.tran@example.com', '0923456789','Ho Chi Minh, Vietnam'),
       (3,'Le Minh Hoang','hoang.le@example.com', '0934567890','da nang,Vietnam'),
       (4,'Pham Hoang Nam','nam.pham@example.com', '0945678901','Hue, Vietnam'),
       (5,'Vu Minh Thu','thu.vu@example.com', '0956789012','Hai Phong, Vietnam'),
       (6,'Nguyen Thi Lan','lan.nguyen@example.com', '0967890123','Quang Ninh, Vietnam'),
       (7,'Bui Minh Tuan','tuan.bui@example.com', '0978901234','Bac Giang, Vietnam'),
       (8,'Pham Quang Hieu','hieu.pham@example.com', '0989012345','Quang Nam, Vietnam'),
       (9,'Le Thi Lan','lan.le@example.com', '0990123456','Da Lat, Vietnam'),
       (10,'Nguyen Thi Mai','mai.nguyen@example.com', '0901234567','Can Tho, Vietnam');

create table room(
                     room_id varchar(5)primary key not null ,
                     room_type varchar(50)not null ,
                     room_price decimal(10,2)not null ,
                     room_status varchar(20)not null ,
                     room_area int not null
);
insert into room(room_id, room_type, room_price, room_status, room_area)
values (1,'single',100, 'Available', 25),
       (2,'double',150, 'Booked', 40),
       (3,'Suite',250, 'Available', 60),
       (4,'single',120, 'Booked', 30),
       (5,'double',160, 'Available', 35);
create table booking (
                         booking_id int primary key not null auto_increment,
                         customer_id varchar(5)not null ,
                         room_id varchar(5)not null ,
                         check_in_date date not null ,
                         check_out_date date not null ,
                         total_amount decimal(10,2),
                         constraint foreign key (customer_id)
                             references customer(customer_id),
                         foreign key (room_id)
                             references room(room_id)
);
insert into booking( booking_id, customer_id, room_id, check_in_date, check_out_date, total_amount)
values (1,2,1,'2025-03-01','2025-03-05',400.0),
       (2,2,2,'2025-03-02','2025-03-06',600.0),
       (3,3,3,'2025-03-03','2025-03-07',1000.0),
       (4,4,4,'2025-03-04','2025-03-08',480.0),
       (5,5,5,'2025-03-05','2025-03-09',800.0),
       (6,6,1,'2025-03-06','2025-03-10',400.0),
       (7,7,2,'2025-03-07','2025-03-11',600.0),
       (8,8,3,'2025-03-08','2025-03-12',1000.0),
       (9,9,4,'2025-03-09','2025-03-13',480.0),
       (10,10,5,'2025-03-10','2025-03-14',800.0);
update booking b
join room r on b.room_id= r.room_id
set b.total_amount = r.room_price * datediff(b.check_out_date, b.check_in_date)
where r.room_status = 'Booked'
  and b.check_in_date < CURDATE();
create table payment(
                        payment_id int auto_increment primary key not null ,
                        booking_id int not null,
                        payment_method varchar(50) not null ,
                        payment_date date,
                        payment_amount decimal(10,2)not null,
                        constraint foreign key (booking_id)
                            references booking(booking_id)

);
insert into payment(payment_id, booking_id, payment_method, payment_date, payment_amount)
values(1,2,'cash','2025-03-05',400.0),
      (2,1,'cash','2025-03-06',600.0),
      (3,3,'credit card','2025-03-07',1000.0),
      (4,4,'bank transfer','2025-03-08',480.0),
      (5,5,'cash','2025-03-09',800.0),
      (6,6,'credit card','2025-03-10',400.0),
      (7,7,'bank transfer','2025-03-11',600.0),
      (8,8,'cash','2025-03-12',1000.0),
      (9,9,'credit card','2025-03-13',480.0),
      (10,10,'bank transfer','2025-03-14',800.0);
delete from payment
where payment_method = 'cash'
and payment.payment_amount <500;

-- Truy vấn dữ liệu
select * from customer
order by customer_fullname asc ;
 select * from room
 order by room_price desc ;
-- tao view
    create view vw_customer_room_over30
as
    select
        c.customer_id as makhachhang,
        c.customer_fullname as hotenkhachhang,
        r.room_id as maphong,
        r.room_area as dientichphong
        from booking b
join customer c on b.customer_id = c.customer_id
join room r on b.room_id= r.room_id
where r.room_area > 30;
-- Tạo Trigger
delimiter //
create trigger check_insert_booking
    before insert on booking
    for each row
    begin
        if check_out_date < check_in_date
            then
                signal sqlstate '45000'
            set message_text ='ngay dat phong ko the sau ngay tra phong duoc!';
            end if ;
    end //
    delimiter ;
-- triger update room
    delimiter //
    create trigger update_room_status_on_booking
        after insert on booking
        for each row
        begin
            update room
                set room_status='Booked'
            where room_id=new.room_id;
        end //
    delimiter ;

-- procedure
delimiter //
create procedure add_customer(in in_customerName varchar(100),
in in_phone varchar(20),
in in_email varchar(100),
in in_address varchar(200))
begin
    insert into
        customer(customerName, phone,email,address)
            values (in_customerName,in_phone, in_email,in_address);
end //
delimiter ;
call add_customer('Nguyen Thi Man','0901234565','man.nguyen@example.com','hoian, Vietnam');