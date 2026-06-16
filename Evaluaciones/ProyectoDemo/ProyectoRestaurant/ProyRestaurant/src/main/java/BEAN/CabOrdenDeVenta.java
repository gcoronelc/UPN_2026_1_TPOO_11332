
package BEAN;

public class CabOrdenDeVenta {
    
    int ordenDeVentaID;
    int empleadoID;
    int clienteID;
    int mesaID;
    String fechaVenta;
    int metodoPago;
    String tipEntrega;
            
    public CabOrdenDeVenta() {
    }

    public CabOrdenDeVenta(int ordenDeVentaID) {
        this.ordenDeVentaID = ordenDeVentaID;
    }

    public CabOrdenDeVenta(int ordenDeVentaID, int empleadoID, int clienteID, int mesaID) {
        this.ordenDeVentaID = ordenDeVentaID;
        this.empleadoID = empleadoID;
        this.clienteID = clienteID;
        this.mesaID = mesaID;
    }

    public CabOrdenDeVenta(int ordenDeVentaID, int empleadoID, int clienteID, int mesaID, String fechaVenta, int metodoPago, String tipEntrega) {
        this.ordenDeVentaID = ordenDeVentaID;
        this.empleadoID = empleadoID;
        this.clienteID = clienteID;
        this.mesaID = mesaID;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.tipEntrega = tipEntrega;
    }

    public int getOrdenDeVentaID() {
        return ordenDeVentaID;
    }

    public void setOrdenDeVentaID(int ordenDeVentaID) {
        this.ordenDeVentaID = ordenDeVentaID;
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

    public int getMesaID() {
        return mesaID;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTipEntrega() {
        return tipEntrega;
    }

    public void setTipEntrega(String tipEntrega) {
        this.tipEntrega = tipEntrega;
    }
    
    
    
}
