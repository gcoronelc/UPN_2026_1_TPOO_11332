package BEAN;

public class Rol {
    
    int rolID;
    String descripRol;

    public Rol() {
    }

    public Rol(int rolID) {
        this.rolID = rolID;
    }

    public Rol(int rolID, String descripRol) {
        this.rolID = rolID;
        this.descripRol = descripRol;
    }

    public int getRolID() {
        return rolID;
    }

    public void setRolID(int rolID) {
        this.rolID = rolID;
    }

    public String getDescripRol() {
        return descripRol;
    }

    public void setDescripRol(String descripRol) {
        this.descripRol = descripRol;
    }
}
