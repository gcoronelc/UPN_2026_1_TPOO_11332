package pe.edu.upn.educaapp.dto;

public class AlumnoMatDto {

    // Datos
    private int id;
    private String nombre;
    private String telefono;
    private String tipo;

    // Constructores
    public AlumnoMatDto() {
    }

    public AlumnoMatDto(int id, String nombre, String telefono, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Gettters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
