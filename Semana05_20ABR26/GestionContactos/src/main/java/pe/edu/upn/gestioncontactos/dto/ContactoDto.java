package pe.edu.upn.gestioncontactos.dto;

public class ContactoDto {

    // Datos
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;

    // Constructor por defecto
    public ContactoDto() {
    }

    // Constructor adicional
    public ContactoDto(String nombre, String apellido, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        String rpta = "( Apellido:" + this.apellido;
        rpta += "; Nombre:" + this.nombre;
        rpta += "; Celular:" + this.celular;
        rpta += "; Correo: " + this.correo + " )";
        return rpta;
    }
    
    

}
