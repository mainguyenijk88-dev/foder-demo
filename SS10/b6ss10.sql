use triger;
create table InventoryChangeHistory (
    historyid int auto_increment primary key,
    productid int not null,
    oldQuantity int,
    newQuantity int,
    changeType enum('increase', 'Decrease','no change'),
    changeDate datetime
);

delimiter //
create trigger AfterProductUpdateHistory
    after update on products for each row
begin
   if OLD.quantity <> new.QUANTITY then
       insert into InventoryChangeHistory(
                                       historyid,productid , oldQuantity,newQuantity, changeType,  changeDate
) values
      ( historyid, new.productid,old.Quantity,
       new.Quantity, CASE
                         WHEN NEW.quantity > OLD.quantity THEN 'Increase'
                         WHEN NEW.quantity < OLD.quantity THEN 'Decrease'
                         ELSE 'No change'
            END,now());
       end if ;

        end //
        delimiter ;
drop trigger if exists AfterProductUpdateHistory;

        update products
        set quantity =100

        where PRODUCTID =4;