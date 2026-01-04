use triger;

create table ProductSummary(
                               SummaryID INT Primary Key,
                               TotalQuantity INT
);


insert into productSummary (
    SummaryID ,
    TotalQuantity
)values(1,(select sum(quantity)from products));


delimiter //
create trigger AfterProductUpdateSummary
    after updat e on products for each row

    begin
        update productSummary

set totalquantity = (select sum(quantity)from products)
        where summaryid = 1;

    end //
    delimiter ;

    update products
    set quantity =50
    where productid =5;


