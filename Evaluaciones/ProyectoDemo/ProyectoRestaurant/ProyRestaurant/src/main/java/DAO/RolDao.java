
package DAO;

import BEAN.Rol;
import UTIL.DbBean;
import UTIL.Util;
import java.sql.ResultSet;
import java.util.Vector;

public class RolDao {
     public void eliminarRol(Rol rol){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Rol";
        sql = sql+ " where rolID = "+rol.getRolID()+" ";
        
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
    
    public void actualizarRol(Rol rol){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Rol set ";
        sql = sql+ " descripRol = '"+rol.getDescripRol()+"' ";
        sql = sql+ " where rolID = "+rol.getRolID()+" ";
        
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
    
    public void insertaRol(Rol rol){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Rol values ( ";
        sql = sql +rol.getRolID()+", '"+rol.getDescripRol()+"')" ;

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
    
    public String devRol(int idRol){
    
        Util util = new Util();
        
        String idrol = Integer.toString(idRol);
        String Rol = util.cadExp("Rol", "rolID", "descripRol", idrol);
        
        return Rol;
    
    }
    
    
    public int devIDRol(String rol){
    
        Util util = new Util();
        
        int idRol = util.idExp("Rol", "rolID", "descripRol", rol);
    
        return idRol;
    }
    
    public Vector<Rol> listaRol(boolean valida, String cadena){
    
        String sql;
        Vector<Rol> listaRol = new Vector<Rol>();
        DbBean con = new DbBean();
    
        sql = "select * from Rol ";
   
        if (valida == true){
           sql = sql + " where RolID like '"+ cadena +"%'"+ " or "+ " descripRol like '"+cadena+"%' ";
        }
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Rol rol = new Rol();
                
                rol.setRolID(resul.getInt(1));
                rol.setDescripRol(resul.getString(2));

                listaRol.addElement(rol);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaRol;
    }
    
    public Vector<Rol> llenaRol(){
    
        String sql;
        Vector<Rol> listaRol = new Vector<Rol>();
        DbBean con = new DbBean();
    
        sql = "select * from Rol ";
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Rol rol = new Rol();
                
                rol.setRolID(resul.getInt(1));
                rol.setDescripRol(resul.getString(2));

                listaRol.addElement(rol);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaRol;
    }
}
