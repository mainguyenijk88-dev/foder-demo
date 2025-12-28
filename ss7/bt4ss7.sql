use pdmn;

insert into products( productID, productName, category, price, quantity) values
                                                                             (1, 'samsung', 'techology', 15000000, 10),
                                                                             (2, 'iphone14', 'smart phone',  10000000, 15),
                                                                             (3, 'vio','tablet', 11000000, 12),
                                                                             (4, 'thinkpad','computer', 25000000, 10),
                                                                             (5, 'mp3', 'techology', 5000000, 10),
                                                                             (6, 'dell','laptop', 15000000, 5),
                                                                             (7, 'iphone12', 'smart phone',  15000000, 100),
                                                                             (8, 'soni', 'mp3', 15000000, 10),
                                                                             (9, 'iphone13', 'smart phone',  10000000, 15),
                                                                             (10, 'vio','tablet', 11000000, 12),
                                                                             (11, 'macbook','computer', 25000000, 10),
                                                                             (12, 'mp3', 'techology', 5000000, 10),
                                                                             (13, 'dell','laptop', 15000000, 5),
                                                                             (14, 'iphone12', 'smart phone',  15000000, 100);
create index idx_productName_price
on products (productName,price)