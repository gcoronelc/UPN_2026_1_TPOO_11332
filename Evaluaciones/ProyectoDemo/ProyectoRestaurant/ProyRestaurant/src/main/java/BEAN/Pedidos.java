package BEAN;

public class Pedidos {
    private int idPedidos;
    private int empleadoID;
    private String ubic;
    private int estado;

    public Pedidos() {
    }
    
    public Pedidos(int idPedidos, int empleadoID, String ubic, int estado) {
        this.idPedidos = idPedidos;
        this.empleadoID = empleadoID;
        this.ubic = ubic;
        this.estado = estado;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public String getUbic() {
        return ubic;
    }


    public int getEstado() {
        return estado;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public void setUbic(String ubic) {
        this.ubic = ubic;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}