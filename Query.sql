create schema test_modul3;
use test_modul3;
create table customer(
    customer_id varchar(5) primary key not null ,
    customer_fullname varchar(100)not null ,
    customer_email varchar(100)not null unique ,
    customer_phone varchar(15)not null ,
    customer_address varchar(255)not null
);
insert into customer(customer_id, customer_fullname, customer_email, customer_phone, customer_address)
values (1,"Nguyen Anh Tu","tu.nguyen@example.com", "0912345678","Hanoi, Vietnam"),
        (2,"Tran Thi Mai","mai.tran@example.com", "0923456789","Ho Chi Minh, Vietnam"),
       (3,"Le Minh Hoang ","hoang.le@example.com", "0934567890"," da nang,Vietnam"),
       (4,"Pham Hoang Nam","nam.pham@example.com", "0945678901","Hue, Vietnam"),
(5,"Vu Minh Thu","thu.vu@example.com", "0956789012","Hai Phong, Vietnam "),
(6,"Nguyen Thi Lan","lan.nguyen@example.com", "0967890123","Quang Ninh, Vietnam"),
(7,"Bui Minh Tuan","tuan.bui@example.com", "0978901234","Bac Giang, Vietnam"),
(8,"Pham Quang Hieu","hieu.pham@example.com", "0989012345","Quang Nam, Vietnam"),
(9,"Le Thi Lan","lan.le@example.com", "0990123456","Da Lat, Vietnam"),
(10,"Nguyen Thi Mai","mai.nguyen@example.com", "0901234567","Can Tho, Vietnam");
DROP TABLE customer;

create table room(
                     room_id varchar(5)primary key not null ,
                     room_type varchar(50)not null ,
                         room_price decimal(10,2)not null ,
                         room_status varchar(20)not null ,
                         room_area int not null
);
insert into room(room_id, room_type, room_price, room_status, room_area)
values (1,"single",1000, "ocupied", 1),
       (2,"double",1200, "ocupied", 2),
       (3,"twin",1200, "vacant", 3),
       (4,"triple",1500, "vacant", 3);
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
values (1,2,1,"2026-1-20","2026-1-23",3000),
       (2,1,2,"2026-1-09","2026-1-12",3600),
       (3,3,3,"2026-1-10","2026-1-13",3600),
       (4,4,4,"2026-1-08","2026-1-10",3000);
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
values(1,2,"visa card","2026-1-12",3600),
      (2,1,"cash","2026-1-23",3000),
      (3,3,"visa card","2026-1-13",3600),
      (4,4,"visa card","2026-1-10",3000);