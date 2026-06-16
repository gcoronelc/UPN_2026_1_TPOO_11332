
package BEAN;

public class DetReceta {
    
    int recetaID;
    int insumoID;
    int cantidad;

    public DetReceta() {
    }

    public DetReceta(int recetaID) {
        this.recetaID = recetaID;
    }

    public DetReceta(int recetaID, int insumoID) {
        this.recetaID = recetaID;
        this.insumoID = insumoID;
    }

    public DetReceta(int recetaID, int insumoID, int cantidad) {
        this.recetaID = recetaID;
        this.insumoID = insumoID;
        this.cantidad = cantidad;
    }
    
    public int getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(int recetaID) {
        this.recetaID = recetaID;
    }

    public int getInsumoID() {
        return insumoID;
    }

    public void setInsumoID(int insumoID) {
        this.insumoID = insumoID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
