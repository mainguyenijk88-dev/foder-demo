create schema od;
use od;
create table orders(
                       order_id int,
                       order_date date,
                       order_status int,
                       totalAmount double
);
INSERT INTO orders (order_id, order_date, order_status, totalAmount)
VALUES
    (1, '2025-12-01', 1, 250.50),
    (2, '2025-12-02', 2, 150.00),
    (3, '2025-12-03', 3, 500.75),
    (4, '2025-12-04', 1, 320.40),
    (5, '2025-12-05', 2, 450.90);

CREATE INDEX idxorder_date_order_status
on orders(order_date,order_status)