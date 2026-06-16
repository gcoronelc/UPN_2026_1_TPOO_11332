
package BEAN;

public class DetOrdenDeVenta {
    
    int ordenDeVentaID;
    int productoID;
    int cantidad;
    int estado;
    int idPedidos;

    public DetOrdenDeVenta() {
    }

    public DetOrdenDeVenta(int ordenDeVentaID) {
        this.ordenDeVentaID = ordenDeVentaID;
    }

    public DetOrdenDeVenta(int ordenDeVentaID, int productoID) {
        this.ordenDeVentaID = ordenDeVentaID;
        this.productoID = productoID;
    }

    public DetOrdenDeVenta(int ordenDeVentaID, int productoID, int cantidad, int estado, int idPedidos) {
        this.ordenDeVentaID = ordenDeVentaID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.estado = estado;
        this.idPedidos = idPedidos;
    }

    public int getOrdenDeVentaID() {
        return ordenDeVentaID;
    }

    public void setOrdenDeVentaID(int ordenDeVentaID) {
        this.ordenDeVentaID = ordenDeVentaID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }
    
}
