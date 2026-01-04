USE TRIGER;
insert into products(productid, name, quantity)
values (4,'casio canculator', 9),
       (5,'tablet', 20);


DELIMITER //
create trigger AfterProductUpdateSetDate
    after update on products for each row
    begin
        insert into inventorychanges(I_PRODUCTID, OLD_QUANTITY, NEW_QUANTITY,CHANGEDATE)

        values (
                   NEW.PRODUCTID,OLD.QUANTITY,NEW.QUANTITY,NOW()
               );

    end ;

DELIMITER ;

update products
set quantity =30
where PRODUCTID =4;