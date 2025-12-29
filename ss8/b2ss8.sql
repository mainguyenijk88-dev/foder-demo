use bt2ss6;

delimiter //
create procedure sp_get_products_by_category(in categoryId int)
begin
select *from products
where category_id = categoryId ;
end //
delimiter ;
drop procedure sp_get_products_by_category;
call sp_get_products_by_category(3);

select *from products;
