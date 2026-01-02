use chinook;
create view View_Album_Artist
 as select al.AlbumID , al.Title, ar.Name
from album al
join artist ar
on al.ArtistId = ar.ArtistId;

create view View_Customer_Spending
as select c. CustomerId, c.FirstName, c.LastName, c.Email, i.Total
       from customer c
join invoice i
on c.CustomerId = i.CustomerId;

create index idx_Employee_LastName
on employee(LastName);

explain analyze
(select * from employee
          where LastName ='King' );
-- -> Index lookup on employee using idx_Employee_LastName (LastName='King')  (cost=0.35 rows=1) (actual time=0.0943..0.107 rows=1 loops=1)

delimiter //
          create PROCEDURE GetTracksByGenre (IN GenreId int )
          begin
              select tr.TrackId, tr.Name, Al.Title, Ar.Name
                  from track tr
              join album al on tr.AlbumId = al.AlbumId
              join artist ar on al.ArtistId = ar.ArtistId
              where tr.GenreId = GenreId ;

          end //
          delimiter ;

          call  GetTracksByGenre(2);

delimiter //

create procedure GetTrackCountByAlbum( IN p_AlbumId int)
begin
select count(TrackId) from track tr
where AlbumId =p_AlbumId;
end //
delimiter ;

call GetTrackCountByAlbum(5);

drop view if exists View_Album_Artist;
drop view if exists View_Customer_Spending;

DROP INDEX idx_Employee_LastName ON employee;

DROP PROCEDURE IF EXISTS GetTracksByGenre;
DROP PROCEDURE IF EXISTS GetTrackCountByAlbum;
