package BEAN;

public class Usuario {
    
    int usuarioID;
    int idLocalR;
    String usuario;
    String contrasena;
    int tipoUsuario;
    int idEmpleado;

    public Usuario() {
    }

    public Usuario(int usuarioID, int idLocalR, int idEmpleado) {
        this.usuarioID = usuarioID;
        this.idLocalR = idLocalR;
        this.idEmpleado = idEmpleado;
    }

    public Usuario(int usuarioID, int idLocalR, String usuario, String contrasena, int tipoUsuario, int idEmpleado) {
        this.usuarioID = usuarioID;
        this.idLocalR = idLocalR;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.idEmpleado = idEmpleado;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getIdLocalR() {
        return idLocalR;
    }

    public void setIdLocalR(int idLocalR) {
        this.idLocalR = idLocalR;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    

    
}