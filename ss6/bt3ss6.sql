-- Tìm các sản phẩm có giá nằm trong một khoảng cụ thể


use b1ss6_products;

SELECT *
FROM products
WHERE price BETWEEN 1000000 AND 10000000;

select *
from products

select *
from categories

-- Tìm các sản phẩm có tên chứa một chuỗi ký tự nhất định
SELECT *
FROM products
WHERE name LIKE '%Laptop%';


-- Tính giá trung bình của sản phẩm cho mỗi danh mục
SELECT
    c.id AS categoryId,
    c.name AS categoryName,
    AVG(p.price) AS average_price
FROM categories c
         LEFT JOIN products p ON c.id = p.category_id
GROUP BY c.id, c.name
ORDER BY average_price DESC;

-- Tìm những sản phẩm có giá cao hơn mức giá trung bình của toàn bộ sản phẩm
SELECT *
FROM products
WHERE price > (
    SELECT AVG(price)
    FROM products
);

-- Tìm sản phẩm có giá thấp nhất cho từng danh mục
SELECT
    c.id AS categoryId,
    c.name AS categoryName,
    p.id AS productId,
    p.name AS productName,
    p.price
FROM products p
         JOIN categories c ON p.category_id = c.id
         JOIN (
    -- Subquery: tìm giá thấp nhất theo từng danh mục
    SELECT category_id, MIN(price) AS min_price
    FROM products
    GROUP BY category_id
) AS sub ON p.category_id = sub.category_id AND p.price = sub.min_price
ORDER BY c.id;

