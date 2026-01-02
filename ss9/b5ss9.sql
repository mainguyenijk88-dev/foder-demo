use chinook;
CREATE OR REPLACE VIEW View_High_Value_Customers AS
SELECT
    c.CustomerId,
    c.FirstName,
    c.LastName,
    c.Email,
    c.Country,
    SUM(i.Total) AS Total
FROM customer c
         JOIN invoice i
              ON c.CustomerId = i.CustomerId
GROUP BY
    c.CustomerId, c.FirstName, c.LastName, c.Email, c.Country;

DROP VIEW View_High_Value_Customers;

CREATE VIEW View_Popular_Tracks AS
SELECT
    TR.TrackId,
    TR.Name,
    INl.InvoiceId,
    INl.UnitPrice,
    INl.Quantity
FROM track TR
         JOIN invoiceline INL
              ON TR.TrackId = INL.TrackId;

create index idx_Customer_Country
on customer(country);

create index idx_Track_Name_FT
on track (Name);


SELECT CustomerId, FirstName, LastName, Country
FROM customer
WHERE Country = 'USA';

EXPLAIN analyze
SELECT CustomerId, FirstName, LastName, Country
FROM customer
WHERE Country = 'USA';
-- -> Index lookup on customer using idx_Customer_Country (Country='USA')  (cost=2.05 rows=13) (actual time=0.0647..0.0909 rows=13 loops=1)

SELECT TrackId, Name
FROM track
WHERE Name = 'Believe';

EXPLAIN analyze
SELECT TrackId, Name
FROM track
WHERE Name = 'Believe';
-- -> Covering index lookup on track using idx_Track_Name_FT (Name='Believe')  (cost=1.3 rows=3) (actual time=0.0232..0.0281 rows=3 loops=1)

-- tao thu tuc
DELIMITER //

CREATE PROCEDURE GetHighValueCustomersByCountry (
    IN p_Country VARCHAR(40)
)
BEGIN
    SELECT
        CustomerId,
        FirstName,
        LastName,
        Email,
        Total
    FROM View_High_Value_Customers
    WHERE Country = p_Country
    ORDER BY Total DESC;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE UpdateCustomerSpending (
    IN p_CustomerId INT,
    IN p_Amount DECIMAL(10,2)
)
BEGIN
    -- Cập nhật tất cả hóa đơn của khách hàng
    UPDATE invoice
    SET Total = Total + p_Amount
    WHERE CustomerId = p_CustomerId;
END //

DELIMITER ;


-- xoa cac view
drop view if exists View_High_Value_Customers;
drop view if exists View_Popular_Tracks;

-- xoa cac indx
drop index idx_Customer_Country on customer;

drop index idx_Track_Name_FT on track;

-- xoa procedure

drop procedure if exists GetHighValueCustomersByCountry;
drop procedure if exists UpdateCustomerSpending;