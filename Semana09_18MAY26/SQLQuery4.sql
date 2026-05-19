
select 
	a.alu_id id, a.alu_nombre nombre,
	ISNULL(a.alu_telefono,'None') telefono,
	m.mat_tipo tipo, m.mat_precio
from MATRICULA m 
join ALUMNO a on m.alu_id = a.alu_id
where cur_id = 2;
go


select * from MATRICULA;
go

insert into MATRICULA(cur_id, alu_id,emp_id,
mat_tipo,mat_fecha,mat_precio, mat_cuotas)
values(?,?,?,?,GETDATE(),?,?)
go

select * from CURSO;
go

update CURSO
set cur_matriculados = cur_matriculados + 1
where cur_id = ?
go

select cur_precio precio from curso where cur_id=1;
go




