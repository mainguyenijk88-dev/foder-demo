use b2ss6;
-- Thêm một đơn hàng mới vào bảng orders và chi tiết của đơn hàng đó vào bảng order_details.
-- Thêm đơn hàng
INSERT INTO orders (id, customer_id, order_date)
VALUES (207, 8, '2025-12-27');

-- Thêm chi tiết đơn hàng
INSERT INTO order_details (order_id, product_id, quantity, price)
VALUES
    (207, 1, 1, 18000000),   -- Laptop Dell
    (207, 4, 2, 1500000),    -- Máy xay sinh tố
    (207, 6, 3, 500000);     -- Áo sơ mi nam

-- Tính tổng doanh thu của toàn bộ cửa hàng.
SELECT SUM(quantity * price) AS total_revenue
FROM order_details;

-- Tính doanh thu trung bình của mỗi đơn hàng.
SELECT AVG(order_total) AS average_order_revenue
FROM (
         SELECT order_id, SUM(quantity * price) AS order_total
         FROM order_details
         GROUP BY order_id
     ) AS sub;

-- Tìm và hiển thị thông tin của đơn hàng có doanh thu cao nhất.
SELECT o.id AS orderId,
       o.customer_id AS customerId,
       o.order_date AS orderDate,
       SUM(od.quantity * od.price) AS orderTotal
FROM orders o
         JOIN order_details od ON o.id = od.order_id
GROUP BY o.id
ORDER BY orderTotal DESC
LIMIT 1;

-- Tìm và hiển thị danh sách 3 sản phẩm bán chạy nhất dựa trên tổng số lượng đã bán.
SELECT p.id AS productId,
       p.name AS productName,
       SUM(od.quantity) AS totalQuantitySold
FROM products p
         JOIN order_details od ON p.id = od.product_id
GROUP BY p.id
ORDER BY totalQuantitySold DESC
LIMIT 3;


