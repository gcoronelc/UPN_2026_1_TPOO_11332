package pe.edu.upn.educaapp.prueba;

import java.util.List;
import pe.edu.upn.educaapp.dto.AlumnoMatDto;
import pe.edu.upn.educaapp.dto.Reporte1Dto;
import pe.edu.upn.educaapp.service.ConsultaService;

public class Prueba07AvanceMatricula {
    
    public static void main(String[] args) {
        try {
            // Proceso
            ConsultaService service = new ConsultaService();
            List<Reporte1Dto> lista = service.avanceDeCursos();
            // Reporte
            for (Reporte1Dto bean : lista) {
                System.out.println(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
