package pe.edu.upn.educaapp.prueba;

import pe.edu.upn.educaapp.dto.MatriculaDto;
import pe.edu.upn.educaapp.service.ProcesoService;

public class Prueba04Matricular {
    
    public static void main(String[] args) {
        
        try {
            // Datos
            MatriculaDto bean = new MatriculaDto();
            bean.setIdCurso(1);
            bean.setIdAlumno(7);
            bean.setIdEmpleado(1);
            bean.setTipo("REGULOR");
            bean.setCuotas(2);
            // Proceso
            ProcesoService service = new ProcesoService();
            service.matricular(bean);
            // Reporte
            System.out.println("MatriculA EXITOSA!!");
        } catch (Exception e) {
            System.err.println("[ERROR]" + e.getMessage());
        }
        
        
    }
    
    
    
}
