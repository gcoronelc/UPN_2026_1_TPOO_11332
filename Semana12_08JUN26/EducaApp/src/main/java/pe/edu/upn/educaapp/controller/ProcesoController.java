package pe.edu.upn.educaapp.controller;

import java.util.List;
import pe.edu.upn.educaapp.dto.ComboDto;
import pe.edu.upn.educaapp.dto.MatriculaDto;
import pe.edu.upn.educaapp.service.ComboService;
import pe.edu.upn.educaapp.service.ProcesoService;

public class ProcesoController {
    
    private ProcesoService procesoService;
    private ComboService comboService;

    public ProcesoController() {
        procesoService = new ProcesoService();
        comboService = new ComboService();
    }
    
    public void matricular(MatriculaDto bean) {
        procesoService.matricular(bean);
    }
    
    public List<ComboDto> cursosDisponibles(){
        return comboService.cursosDisponibles();
    }
    
    public List<ComboDto> alumnosDisponibles(int idCurso){
        return comboService.alumnosDisponibles(idCurso);
    }
    
}
