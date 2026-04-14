package pe.edu.upn.gestioncontactos.service;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upn.gestioncontactos.dto.ContactoDto;

class BD {

    // No se pueden crear instancias de la clase BD.
    private BD() {
    }

    static List<ContactoDto> contactos;
    
    static {
        contactos = new ArrayList<>();
        contactos.add(new ContactoDto("Gustavo", "Coronel", "959595959", "ecoronel@gmail.com"));
        contactos.add(new ContactoDto("Claudia", "Ramos", "998745872", "cramos@gmail.com"));
        contactos.add(new ContactoDto("Fernando", "Torres", "974523658", "ftorres@gmail.com"));
        contactos.add(new ContactoDto("Susana", "De La Cruz", "926578438", "sdelacruz@gmail.com"));
        contactos.add(new ContactoDto("Miguel", "Carrasco", "987878213", "mcarrasco@gmail.com"));    
    }
    
    
}
