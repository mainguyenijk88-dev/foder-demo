CREATE SCHEMA TRIGER;
USE TRIGER;
alter table inventorychanges
modify column CHANGEID int auto_increment;

DROP TABLE INVENTORYCHANGES;



DELIMITER //
create trigger AfterProductUpdate
after Update on products FOR EACH ROW
      begin
insert into inventorychanges(I_PRODUCTID, OLD_QUANTITY, NEW_QUANTITY,CHANGEDATE)

    values (
NEW.PRODUCTID,OLD.QUANTITY,NEW.QUANTITY,NOW()
           );
      end //

      DELIMITER ;

      DROP TRIGGER AfterProductUpdate;

      UPDATE products
      SET QUANTITY = 100
      WHERE PRODUCTID = 3;