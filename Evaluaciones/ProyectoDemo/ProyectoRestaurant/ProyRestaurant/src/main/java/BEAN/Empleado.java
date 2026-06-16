
package BEAN;

public class Empleado {
    
    int empleadoID;
    int usuarioModifID;
    int usuarioCreaID;
    String nombres;
    String apellidos;
    String fechaNacimiento;
    String fechCrea;
    int genero;
    String fechModif;
    String dni;
    String estadoCivil;

    public Empleado() {
    }

    public Empleado(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public Empleado(int empleadoID, int usuarioModifID, int usuarioCreaID) {
        this.empleadoID = empleadoID;
        this.usuarioModifID = usuarioModifID;
        this.usuarioCreaID = usuarioCreaID;
    }

    public Empleado(int empleadoID, int usuarioModifID, int usuarioCreaID, String nombres, String apellidos, String fechaNacimiento, String fechCrea, int genero, String fechModif, String dni, String estadoCivil) {
        this.empleadoID = empleadoID;
        this.usuarioModifID = usuarioModifID;
        this.usuarioCreaID = usuarioCreaID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechCrea = fechCrea;
        this.genero = genero;
        this.fechModif = fechModif;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getUsuarioModifID() {
        return usuarioModifID;
    }

    public void setUsuarioModifID(int usuarioModifID) {
        this.usuarioModifID = usuarioModifID;
    }

    public int getUsuarioCreaID() {
        return usuarioCreaID;
    }

    public void setUsuarioCreaID(int usuarioCreaID) {
        this.usuarioCreaID = usuarioCreaID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechCrea() {
        return fechCrea;
    }

    public void setFechCrea(String fechCrea) {
        this.fechCrea = fechCrea;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getFechModif() {
        return fechModif;
    }

    public void setFechModif(String fechModif) {
        this.fechModif = fechModif;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    
}
