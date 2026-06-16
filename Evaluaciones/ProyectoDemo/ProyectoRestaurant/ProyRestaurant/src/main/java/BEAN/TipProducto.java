package BEAN;

public class TipProducto {
    
    private int idTipProducto;
    private String descripcion;

    public TipProducto() {
    }

    public TipProducto(int idTipProducto, String descripcion) {
        this.idTipProducto = idTipProducto;
        this.descripcion = descripcion;
    }

    public int getIdTipProducto() {
        return idTipProducto;
    }

    public void setIdTipProducto(int idTipProducto) {
        this.idTipProducto = idTipProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
