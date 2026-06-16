package BEAN;

public class Plato {
    
   private int idPlato;
   private String descPlat;

    public Plato() {
    }

    public Plato(int idPlato, String descPlat) {
        this.idPlato = idPlato;
        this.descPlat = descPlat;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getDescPlat() {
        return descPlat;
    }

    public void setDescPlat(String descPlat) {
        this.descPlat = descPlat;
    }
}
