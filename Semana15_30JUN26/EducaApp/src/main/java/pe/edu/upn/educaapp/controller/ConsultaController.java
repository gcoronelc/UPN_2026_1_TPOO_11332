package pe.edu.upn.educaapp.controller;

import java.util.List;
import pe.edu.upn.educaapp.dto.AlumnoMatDto;
import pe.edu.upn.educaapp.dto.Reporte1Dto;
import pe.edu.upn.educaapp.service.ConsultaService;

public class ConsultaController {
    
    private ConsultaService consultaService;

    public ConsultaController() {
        consultaService = new ConsultaService();
    }
    
    public List<AlumnoMatDto> matriculadosPorCurso(int idCurso){
        return consultaService.matriculadosPorCurso(idCurso);
    }
    
    public List<Reporte1Dto> avanceDeCursos(){
        return consultaService.avanceDeCursos();
    }
}
