USE Panchito;
GO

SET DATEFORMAT dmy;
GO

create table demo(
	fecha datetime
);
go


insert into demo(fecha) values('20260622 17:40');
go


insert into demo(fecha) values('22/06/2026 18:15:30');
go

select fecha from demo;
go


