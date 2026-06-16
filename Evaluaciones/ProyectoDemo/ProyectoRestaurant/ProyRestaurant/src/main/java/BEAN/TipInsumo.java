package BEAN;

public class TipInsumo {
    
    int IdInsumo;
    String descripcion;

    public TipInsumo() {
    }

    public TipInsumo(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public TipInsumo(int IdInsumo, String descripcion) {
        this.IdInsumo = IdInsumo;
        this.descripcion = descripcion;
    }

    public int getIdInsumo() {
        return IdInsumo;
    }

    public void setIdInsumo(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}