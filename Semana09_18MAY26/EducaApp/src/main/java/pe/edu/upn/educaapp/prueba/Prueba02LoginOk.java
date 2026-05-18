package pe.edu.upn.educaapp.prueba;

import pe.edu.upn.educaapp.dto.EmpleadoDto;
import pe.edu.upn.educaapp.service.LogonService;

public class Prueba02LoginOk {
    
    public static void main(String[] args) {
        try {
            // Datos
            String usuario = "ksanchez";
            String clave = "suerte";
            // Proceso
            LogonService service = new LogonService();
            EmpleadoDto bean = service.validarUsuario(usuario, clave);
            // Reporte
            System.out.println("Hola " + bean.getNombre());
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }
    
}
