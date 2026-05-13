package pe.edu.upn.educaapp.controller;

import pe.edu.upn.educaapp.dto.EmpleadoDto;
import pe.edu.upn.educaapp.service.LogonService;

public class LogonController {
    
    public void validarUsuario(String usuario, String clave) {
        LogonService service = new LogonService();
        EmpleadoDto bean = service.validarUsuario(usuario, clave);
    }
    
}
