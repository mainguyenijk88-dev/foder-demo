use demo;

create view v_order_info
as select o.orderId, o.orderDate, c.customerName
       from orders o
           join customers c on o.customerId = c.customerId
;
select * from v_order_info;