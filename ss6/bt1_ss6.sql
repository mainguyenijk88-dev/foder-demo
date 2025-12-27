create schema b1ss6_products;
use b1ss6_products;

create table categories (
                            id int primary key,
                            name varchar(255)
);
INSERT INTO categories (id, name) VALUES
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
                                                        (3, 'Tivi LG', 8000000, 1);

-- thêm 3 sp mới vào bảng sp
insert into products (id, name, price, category_id) values
                                                        (101, 'Tai nghe Bluetooth', 700000, 1),
                                                        (102, 'Nồi cơm điện', 2500000, 2),
                                                        (103, 'Áo khoác nam', 900000, 3);

-- Cập nhật giá của một sản phẩm đã có

UPDATE products
SET price = 13000000
WHERE id = 2;

select*from products

-- xóa 1 sp
DELETE FROM products
WHERE id = 3;

-- Hiển thị tất cả sản phẩm, sắp xếp theo giá thấp -cao
SELECT *
FROM products
ORDER BY price ASC;


-- Hiển thị tất cả sản phẩm, sắp xếp theo giá -cao->thấp
SELECT *
FROM products
ORDER BY price DESC;

-- Thống kê số lượng sản phẩm cho từng danh mục
SELECT
    c.id AS categoryId,
    c.name AS categoryName,
    COUNT(p.id) AS product_count
FROM categories c
         LEFT JOIN products p ON c.id = p.category_id
GROUP BY c.id, c.name
ORDER BY product_count DESC;

