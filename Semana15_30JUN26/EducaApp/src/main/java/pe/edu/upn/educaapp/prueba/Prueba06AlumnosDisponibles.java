package pe.edu.upn.educaapp.prueba;

import java.util.List;
import pe.edu.upn.educaapp.dto.ComboDto;
import pe.edu.upn.educaapp.service.ComboService;

public class Prueba06AlumnosDisponibles {
    
    public static void main(String[] args) {
        try {
            int idCurso = 1;
            ComboService service = new ComboService();
            List<ComboDto> lista = service.alumnosDisponibles(idCurso);
            for (ComboDto bean : lista) {
                System.out.println(bean);
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }
}
