package BEAN;

public class Reserva {
    
    int reservaID;
    int empleadoID;
    int clienteID;
    String fecha;
    int estado;

    public Reserva() {
    }

    public Reserva(int reservaID) {
        this.reservaID = reservaID;
    }

    public Reserva(int reservaID, int clienteID) {
        this.reservaID = reservaID;
        this.clienteID = clienteID;
    }

    public Reserva(int reservaID, int empleadoID, int clienteID, String fecha, int estado) {
        this.reservaID = reservaID;
        this.empleadoID = empleadoID;
        this.clienteID = clienteID;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getReservaID() {
        return reservaID;
    }

    public void setReservaID(int reservaID) {
        this.reservaID = reservaID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
