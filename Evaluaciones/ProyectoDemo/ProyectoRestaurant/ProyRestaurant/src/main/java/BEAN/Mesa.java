package BEAN;

public class Mesa {
    
    int mesaID;
    String ubic;
    int numSillas;
    int estado;

    public Mesa() {
    }

    public Mesa(int mesaID) {
        this.mesaID = mesaID;
    }

    public Mesa(int mesaID, String ubic, int numSillas, int estado) {
        this.mesaID = mesaID;
        this.ubic = ubic;
        this.numSillas = numSillas;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMesaID() {
        return mesaID;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    public String getUbic() {
        return ubic;
    }

    public void setUbic(String ubic) {
        this.ubic = ubic;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    } 
}