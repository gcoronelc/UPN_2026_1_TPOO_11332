
package BEAN;

public class Insumo {
    
    int insumoID;
    int idTipInsumo;
    String unidadMedida;
    String descripInsumo;
    double precioUnit;
    int cantidad;

    public Insumo() {
    }

    public Insumo(int insumoID) {
        this.insumoID = insumoID;
    }

    public Insumo(int insumoID, int idTipInsumo) {
        this.insumoID = insumoID;
        this.idTipInsumo = idTipInsumo;
    }

    public Insumo(int insumoID, int idTipInsumo, String unidadMedida, String descripInsumo, double precioUnit, int cantidad) {
        this.insumoID = insumoID;
        this.idTipInsumo = idTipInsumo;
        this.unidadMedida = unidadMedida;
        this.descripInsumo = descripInsumo;
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
    }

    public int getInsumoID() {
        return insumoID;
    }

    public void setInsumoID(int insumoID) {
        this.insumoID = insumoID;
    }

    public int getIdTipInsumo() {
        return idTipInsumo;
    }

    public void setIdTipInsumo(int idTipInsumo) {
        this.idTipInsumo = idTipInsumo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripInsumo() {
        return descripInsumo;
    }

    public void setDescripInsumo(String descripInsumo) {
        this.descripInsumo = descripInsumo;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
