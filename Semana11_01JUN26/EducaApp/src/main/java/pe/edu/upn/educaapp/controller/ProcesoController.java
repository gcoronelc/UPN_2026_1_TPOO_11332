package pe.edu.upn.educaapp.controller;

import pe.edu.upn.educaapp.dto.MatriculaDto;
import pe.edu.upn.educaapp.service.ProcesoService;

public class ProcesoController {
    
    private ProcesoService procesoService;

    public ProcesoController() {
        procesoService = new ProcesoService();
    }
    
    public void matricular(MatriculaDto bean) {
        procesoService.matricular(bean);
    }
    
    
}
