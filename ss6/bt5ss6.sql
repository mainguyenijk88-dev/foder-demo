create database bt2ss6;
use bt2ss6;

create table customers (
                           id int primary key,
                           name varchar(255),
                           email varchar(255)
);
insert into customers (id, name, email) values
                                            (1, 'Nguyen Van A', 'a.nguyen@gmail.com'),
                                            (2, 'Tran Thi B', 'b.tran@gmail.com'),
                                            (3, 'Le Van C', 'c.le@gmail.com'),
                                            (4, 'Pham Thi D', 'd.pham@gmail.com'),
                                            (5, 'Hoang Van E', 'e.hoang@gmail.com'),
                                            (6, 'Do Thi F', 'f.do@gmail.com'),
                                            (7, 'Vu Van G', 'g.vu@gmail.com'),
                                            (8, 'Bui Van H', 'h.bui@gmail.com');


create table categories (
                            id int primary key,
                            name varchar(255)
);
insert into categories (id, name) values
                                      (1, 'Điện tử'),
                                      (2, 'Gia dụng'),
                                      (3, 'Thời trang');

create table products (
                          id int primary key,
                          name varchar(255),
                          price double,
                          category_id int,
                          foreign key (category_id) references categories(id)
);

insert into products (id, name, price, category_id) values
                                                        (1, 'Laptop Dell', 18000000, 1),
                                                        (2, 'Điện thoại Samsung', 12000000, 1),
                                                        (3, 'Tivi LG', 8000000, 1),
                                                        (4, 'Máy xay sinh tố', 1500000, 2),
                                                        (5, 'Bàn ủi', 1000000, 2),
                                                        (6, 'Áo sơ mi nam', 500000, 3),
                                                        (7, 'Quần jean nữ', 600000, 3);


create table orders (
                        id int primary key,
                        customer_id int,
                        order_date date,
                        foreign key (customer_id) references customers(id)
);
insert into orders (id, customer_id, order_date) values
                                                     (201, 1, '2025-12-01'),
                                                     (202, 2, '2025-12-02'),
                                                     (203, 3, '2025-12-03'),
                                                     (204, 4, '2025-12-04'),
                                                     (205, 5, '2025-12-05'),
                                                     (206, 6, '2025-12-06');


create table order_details (
                               order_id int,
                               product_id int,
                               quantity int,
                               price double,
                               primary key (order_id, product_id),
                               foreign key (order_id) references orders(id),
                               foreign key (product_id) references products(id)
);
insert into order_details (order_id, product_id, quantity, price) values
                                                                      (201, 1, 1, 18000000),
                                                                      (201, 6, 2, 500000),
                                                                      (202, 2, 1, 12000000),
                                                                      (203, 3, 1, 8000000),
                                                                      (203, 7, 1, 600000),
                                                                      (204, 4, 1, 1500000),
                                                                      (205, 5, 2, 1000000),
                                                                      (206, 7, 3, 600000);
-- Liệt kê sản phẩm cùng với tên danh mục tương ứng.
SELECT
    p.id AS productId,
    p.name AS productName,
    c.name AS categoryName
FROM products p
         JOIN categories c ON p.category_id = c.id;

-- Đếm số đơn hàng của từng khách hàng.
SELECT
    c.id AS customerId,
    c.name AS customerName,
    COUNT(o.id) AS 'số đơn hàng'
FROM customers c
         LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;
-- xác định 5 khách hành có chi tiêu cao nhất
SELECT
    c.id AS customerId,
    c.name AS customerName,
    SUM(od.quantity * od.price) AS 'khách có chi tiêu cao nhất'
FROM customers c
         JOIN orders o ON c.id = o.customer_id
         JOIN order_details od ON o.id = od.order_id
GROUP BY c.id, c.name
ORDER BY 'khách có chi tiêu cao nhất' DESC
LIMIT 5;

-- Tìm các sản phẩm chưa từng xuất hiện trong bất kỳ đơn hàng nào.
SELECT
    p.id,
    p.name,
    p.price
FROM products p
         LEFT JOIN order_details od ON p.id = od.product_id
WHERE od.product_id IS NULL;

-- Tìm những khách hàng đã mua sản phẩm thuộc danh mục có số lượng sản phẩm lớn nhất.
SELECT DISTINCT
    c.id AS customerId,
    c.name AS customerName
FROM customers c
         JOIN orders o ON c.id = o.customer_id
         JOIN order_details od ON o.id = od.order_id
         JOIN products p ON od.product_id = p.id
WHERE p.category_id = (
    SELECT category_id
    FROM products
    GROUP BY category_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);


