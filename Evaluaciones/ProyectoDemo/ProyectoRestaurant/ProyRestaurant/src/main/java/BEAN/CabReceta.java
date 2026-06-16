
package BEAN;

public class CabReceta {
    
    int recetaID;
    int empleadoID;
    int productoID;
    String fechaElab;
    String preparacion;

    public CabReceta() {
    }

    public CabReceta(int recetaID) {
        this.recetaID = recetaID;
    }

    public CabReceta(int recetaID, String fechaElab, String preparacion) {
        this.recetaID = recetaID;
        this.fechaElab = fechaElab;
        this.preparacion = preparacion;
    }

    public CabReceta(int recetaID, int empleadoID, int productoID) {
        this.recetaID = recetaID;
        this.empleadoID = empleadoID;
        this.productoID = productoID;
    }

    public CabReceta(int recetaID, int empleadoID, int productoID, String fechaElab, String preparacion) {
        this.recetaID = recetaID;
        this.empleadoID = empleadoID;
        this.productoID = productoID;
        this.fechaElab = fechaElab;
        this.preparacion = preparacion;
    }

    public int getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(int recetaID) {
        this.recetaID = recetaID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public String getFechaElab() {
        return fechaElab;
    }

    public void setFechaElab(String fechaElab) {
        this.fechaElab = fechaElab;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}
