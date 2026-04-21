package pe.edu.upn.gestioncontactos.controller;

import java.util.List;
import pe.edu.upn.gestioncontactos.dto.ContactoDto;
import pe.edu.upn.gestioncontactos.service.ContactoService;

public class ContactoController {
    
    private ContactoService contactoService;

    public ContactoController() {
        contactoService = new ContactoService();
    }
    
    public List<ContactoDto> getContactos(){
        return contactoService.getContactos();
    }

    public void grabar(ContactoDto bean) {
        contactoService.grabar(bean);
    }
}
