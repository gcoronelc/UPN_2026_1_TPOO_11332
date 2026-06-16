
package DAO;

import BEAN.Area;
import UTIL.DbBean;
import UTIL.Util;
import java.sql.ResultSet;
import java.util.Vector;

public class AreaDao {
     public void eliminarArea(Area area){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Area";
        sql = sql+ " where areaID = "+area.getAreaID()+" ";
        
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizarArea(Area area){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Area set ";
        sql = sql+ " descripArea = '"+area.getDescripArea()+"' ";
        sql = sql+ " where areaID = "+area.getAreaID()+" ";
        
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    public void insertaArea(Area area){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Area values ( ";
        sql = sql +area.getAreaID()+", '"+area.getDescripArea()+"')" ;

        try{
            System.out.println(sql);
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    public String devArea(int idArea){
    
        Util util = new Util();
        
        String idarea = Integer.toString(idArea);
        String Area = util.cadExp("Area", "areaID", "descripArea", idarea);
        
        return Area;
    
    }
    
   public int devIDArea(String area){
    
        Util util = new Util();
        
        int idArea = util.idExp("Area", "areaID", "descripArea", area);
    
        return idArea;
    }
    
    public Vector<Area> llenaArea(){
    
        String sql;
        Vector<Area> listaArea = new Vector<Area>();
        DbBean con = new DbBean();
    
        sql = "select * from area ";
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Area area = new Area();
                
                area.setAreaID(resul.getInt(1));
                area.setDescripArea(resul.getString(2));

                listaArea.addElement(area);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaArea;
    }
    
    
    public Vector<Area> listaArea(boolean valida, String cadena){
    
        String sql;
        Vector<Area> listaArea = new Vector<Area>();
        DbBean con = new DbBean();
    
        sql = "select * from area ";
   
        if (valida == true){
           sql = sql + " where areaID like '"+ cadena +"%'"+ " or "+ " descripArea like '"+cadena+"%' ";
        }
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Area area = new Area();
                
                area.setAreaID(resul.getInt(1));
                area.setDescripArea(resul.getString(2));

                listaArea.addElement(area);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaArea;
    }
}
