package BEAN;

public class Producto {
   private int productoID;
   private int idplato;
   private int idtipo;
   private String descripProducto;
   private int cantidad;
   private double precioUnit;

    public Producto() {
    }

    public Producto(int productoID) {
        this.productoID = productoID;
    }

    public Producto(int productoID, int idplato, int idtipo) {
        this.productoID = productoID;
        this.idplato = idplato;
        this.idtipo = idtipo;
    }

    public Producto(int productoID, int idplato, int idtipo, String descripProducto, int cantidad, double precioUnit) {
        this.productoID = productoID;
        this.idplato = idplato;
        this.idtipo = idtipo;
        this.descripProducto = descripProducto;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public int getIdplato() {
        return idplato;
    }

    public void setIdplato(int idplato) {
        this.idplato = idplato;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getDescripProducto() {
        return descripProducto;
    }

    public void setDescripProducto(String descripProducto) {
        this.descripProducto = descripProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    
}