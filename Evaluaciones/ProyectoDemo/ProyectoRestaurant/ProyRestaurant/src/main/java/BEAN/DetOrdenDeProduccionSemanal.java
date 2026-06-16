    
package BEAN;
public class DetOrdenDeProduccionSemanal {
    private int ordenProduccionID;
    private int productoID;
    private int cantidad;
    private int estado;

    public DetOrdenDeProduccionSemanal() {
    }

    public DetOrdenDeProduccionSemanal(int ordenProduccionID, int productoID, int cantidad, int estado) {
        this.ordenProduccionID = ordenProduccionID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getOrdenProduccionID() {
        return ordenProduccionID;
    }

    public int getProductoID() {
        return productoID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setOrdenProduccionID(int ordenProduccionID) {
        this.ordenProduccionID = ordenProduccionID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
