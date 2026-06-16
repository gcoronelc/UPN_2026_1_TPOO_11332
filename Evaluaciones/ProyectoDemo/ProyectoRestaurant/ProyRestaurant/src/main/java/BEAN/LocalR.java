package BEAN;

public class LocalR {
    
    int idLocalR;
    int usuarioID;
    String ubicacion;
    int capcidadMax;
    int pisos;
    String horaApertura;
    String horaCerrado;

    public LocalR() {
    }

    public LocalR(int idLocalR) {
        this.idLocalR = idLocalR;
    }

    public LocalR(int idLocalR, int usuarioID) {
        this.idLocalR = idLocalR;
        this.usuarioID = usuarioID;
    }

    public LocalR(int idLocalR, int usuarioID, String ubicacion, int capcidadMax, int pisos, String horaApertura, String horaCerrado) {
        this.idLocalR = idLocalR;
        this.usuarioID = usuarioID;
        this.ubicacion = ubicacion;
        this.capcidadMax = capcidadMax;
        this.pisos = pisos;
        this.horaApertura = horaApertura;
        this.horaCerrado = horaCerrado;
    }

    public int getIdLocalR() {
        return idLocalR;
    }

    public void setIdLocalR(int idLocalR) {
        this.idLocalR = idLocalR;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapcidadMax() {
        return capcidadMax;
    }

    public void setCapcidadMax(int capcidadMax) {
        this.capcidadMax = capcidadMax;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCerrado() {
        return horaCerrado;
    }

    public void setHoraCerrado(String horaCerrado) {
        this.horaCerrado = horaCerrado;
    }
}
