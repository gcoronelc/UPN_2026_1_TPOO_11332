
package BEAN;

public class Contrato {
    
    int contratoID;
    int empleadoID;
    int rolID;
    int areaID;
    String fechaIni;
    String fechaFin;
    int estado;
    double sueldo;

    public Contrato() {
    }

    public Contrato(int contratoID) {
        this.contratoID = contratoID;
    }

    public Contrato(int contratoID, String fechaIni, String fechaFin, int estado, double sueldo) {
        this.contratoID = contratoID;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.sueldo = sueldo;
    }

    public Contrato(int contratoID, int empleadoID, int rolID, int areaID, String fechaIni, String fechaFin, int estado, double sueldo) {
        this.contratoID = contratoID;
        this.empleadoID = empleadoID;
        this.rolID = rolID;
        this.areaID = areaID;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.sueldo = sueldo;
    }

    public int getContratoID() {
        return contratoID;
    }

    public void setContratoID(int contratoID) {
        this.contratoID = contratoID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public int getRolID() {
        return rolID;
    }

    public void setRolID(int rolID) {
        this.rolID = rolID;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }  
}
