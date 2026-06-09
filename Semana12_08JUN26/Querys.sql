

select cur_id id, cur_nombre nombre
from curso
where cur_vacantes > 0
and cur_vacantes > cur_matriculados
order by nombre;
go

select alu_id id, alu_nombre nombre 
from ALUMNO
where alu_id not in 
(select alu_id from MATRICULA where cur_id=3)
order by 2;
go




