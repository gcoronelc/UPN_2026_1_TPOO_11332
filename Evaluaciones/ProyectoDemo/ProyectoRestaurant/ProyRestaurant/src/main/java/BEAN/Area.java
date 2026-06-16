
package BEAN;

public class Area {
    
    int areaID;
    String descripArea;

    public Area() {
    }
    
    public Area(int areaID, String descripArea) {
        this.areaID = areaID;
        this.descripArea = descripArea;
    }

    public Area(int areaID) {
        this.areaID = areaID;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getDescripArea() {
        return descripArea;
    }

    public void setDescripArea(String descripArea) {
        this.descripArea = descripArea;
    }
    
}

