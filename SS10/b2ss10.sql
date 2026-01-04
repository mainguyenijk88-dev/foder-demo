USE TRIGER;
-- Tạo Trigger BeforeProductDelete để kiểm tra số lượng sản phẩm trước khi xóa
DELIMITER //
create trigger BeforeProductDelete
    before delete on products FOR EACH ROW
begin
    if OLD.QUANTITY>10 THEN signal sqlstate '45000' set message_text = ' KO thể xóa sp có số lượng lớn hơn 10';
    end if;
    end //

DELIMITER ;

drop trigger BeforeProductDelete;
delete from products
where PRODUCTID = 4;

insert into products(productid, name, quantity)
values (4,'casio canculator', 5);
