SELECT
    c.id,
    c.name,
    c.email
FROM customers c
WHERE EXISTS (
    SELECT 1
    FROM orders o
    WHERE o.customer_id = c.id
);

-- Tìm những khách hàng chưa từng đặt đơn hàng nào
SELECT
    c.id,
    c.name,
    c.email
FROM customers c
         LEFT JOIN orders o ON c.id = o.customer_id
WHERE o.id IS NULL;

-- Tính toán tổng doanh thu mà mỗi khách hàng đã mang lại
SELECT
    c.id AS customerId,
    c.name AS customerName,
    COALESCE(SUM(od.quantity * od.price), 0) AS total_revenue
FROM customers c
         LEFT JOIN orders o ON c.id = o.customer_id
         LEFT JOIN order_details od ON o.id = od.order_id
GROUP BY c.id, c.name
ORDER BY total_revenue DESC;

-- Xác định khách hàng đã mua sản phẩm có giá cao nhất
SELECT DISTINCT
    c.id AS customerId,
    c.name AS customerName
FROM customers c
         JOIN orders o ON c.id = o.customer_id
         JOIN order_details od ON o.id = od.order_id
         JOIN products p ON od.product_id = p.id
WHERE p.price = (
    SELECT MAX(price)
    FROM products
);

select * from products