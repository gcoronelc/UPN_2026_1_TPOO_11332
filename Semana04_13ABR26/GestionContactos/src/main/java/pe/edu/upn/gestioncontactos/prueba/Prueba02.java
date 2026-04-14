package pe.edu.upn.gestioncontactos.prueba;

import java.util.List;
import pe.edu.upn.gestioncontactos.dto.ContactoDto;
import pe.edu.upn.gestioncontactos.service.ContactoService;

public class Prueba02 {

    public static void main(String[] args) {
        
        // Obtener lista de contactos
        ContactoService service = new ContactoService();
        List<ContactoDto> lista = service.getContactos();
        
        // Mostrar la lista
        for (ContactoDto dto : lista) {
            System.out.println(dto);
        }
        
        // Nuevo contacto
        service.addContacto(new ContactoDto("Luiz", "Li", "945238658", "lli@gmail.com"));
        
        // Mostrar la lista
        System.out.println("=================");
        for (ContactoDto dto : lista) {
            System.out.println(dto);
        }
    }

}
