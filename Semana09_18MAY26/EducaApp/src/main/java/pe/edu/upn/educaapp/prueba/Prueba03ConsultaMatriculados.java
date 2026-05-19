package pe.edu.upn.educaapp.prueba;

import java.util.List;
import pe.edu.upn.educaapp.dto.AlumnoMatDto;
import pe.edu.upn.educaapp.service.ConsultaService;

public class Prueba03ConsultaMatriculados {
    
    public static void main(String[] args) {
        try {
            // Dato
            int idCurso = 2;
            // Proceso
            ConsultaService service = new ConsultaService();
            List<AlumnoMatDto> lista = service.matriculadosPorCurso(idCurso);
            // Reporte
            for (AlumnoMatDto bean : lista) {
                System.out.println(bean.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
