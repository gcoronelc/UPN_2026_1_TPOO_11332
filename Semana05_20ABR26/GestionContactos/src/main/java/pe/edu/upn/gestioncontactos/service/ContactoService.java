package pe.edu.upn.gestioncontactos.service;

import java.util.List;
import pe.edu.upn.gestioncontactos.dto.ContactoDto;

public class ContactoService {

    /**
     * Retorna la lista completa de contactos.
     * @return List<ContactoDto>
     */
    public List<ContactoDto> getContactos(){
        return BD.contactos;
    }

    /**
     * Agrega un nuevo contacto a la BD.
     * @param bean Objeto con datos del nuevo contacto.
     */
    public void addContacto(ContactoDto bean){
        BD.contactos.add(bean);
    }
    
    
    public ContactoDto buscarPorCelular(String celular){
        ContactoDto bean = null;
        for(ContactoDto dto: BD.contactos){
            if(dto.getCelular().equals(celular)){
                bean = dto;
                break;
            }
        }
        return bean;
    }

    public void grabar(ContactoDto bean) {
        BD.contactos.add(bean);
    }
    
}
