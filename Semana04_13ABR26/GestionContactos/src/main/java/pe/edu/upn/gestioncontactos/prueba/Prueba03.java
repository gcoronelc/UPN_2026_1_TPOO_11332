package pe.edu.upn.gestioncontactos.prueba;

import java.util.List;
import pe.edu.upn.gestioncontactos.dto.ContactoDto;
import pe.edu.upn.gestioncontactos.service.ContactoService;

public class Prueba03 {

    public static void main(String[] args) {
        
        // Dato
        String celular = "974523658";
        
        // Buscar contacto
        ContactoService service = new ContactoService();
        ContactoDto bean = service.buscarPorCelular(celular);
        
        // Reporte
        if(bean == null){
            System.out.println("No existe.");
        } else{
            System.out.println(bean);
        }
            
    }

}
