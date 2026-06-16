
package BEAN;
public class CabOrdenDeProduccionSemanal {
    private int ordenProduccionID;
    private int empleadoID;
    private String descripArea;
    private String fechaxsem;

    public CabOrdenDeProduccionSemanal() {
    }

    public CabOrdenDeProduccionSemanal(int ordenProduccionID, int empleadoID, String descripArea, String fechaxsem) {
        this.ordenProduccionID = ordenProduccionID;
        this.empleadoID = empleadoID;
        this.descripArea = descripArea;
        this.fechaxsem = fechaxsem;
    }

    public CabOrdenDeProduccionSemanal(int ordenProduccionID, int empleadoID) {
        this.ordenProduccionID = ordenProduccionID;
        this.empleadoID = empleadoID;
    }
    
    public int getOrdenProduccionID() {
        return ordenProduccionID;
    }
  
    public int getEmpleadoID() {
        return empleadoID;
    }

    public String getDescripArea() {
        return descripArea;
    }

    public String getFechaxsem() {
        return fechaxsem;
    }

    public void setOrdenProduccionID(int ordenProduccionID) {
        this.ordenProduccionID = ordenProduccionID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public void setDescripArea(String descripArea) {
        this.descripArea = descripArea;
    }

    public void setFechaxsem(String fechaxsem) {
        this.fechaxsem = fechaxsem;
    }
    
    
}
