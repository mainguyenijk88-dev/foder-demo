use b2ss6;

create view view2_categories
 as select id,name
from categories;
select *from view2_categories;

ALTER VIEW view2_categories AS
SELECT name from categories;

drop view view_customers;

create view view_orders
as select id,customer_id, order_date
   from b2ss6.orders;

select *from view_orders ;

alter view view_orders
    as select id,customer_id
       from orders;

create index idx_product_id_price
on order_details(product_id,price);

select * from order_details where product_id and price

