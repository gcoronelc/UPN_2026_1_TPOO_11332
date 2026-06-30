select 
	cur_id ID, cur_nombre nombre, cur_vacantes vacantes,
	cur_matriculados matriculados,
	cast(cur_matriculados * 100.0 / cur_vacantes as numeric(10,2))  porcentaje
from curso;
go

