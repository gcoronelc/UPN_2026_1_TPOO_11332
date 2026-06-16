
package DAO;

import BEAN.DetReceta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetRecetaDao {
        public Vector<DetReceta> ListaItem(boolean sw, String str){
        Vector<DetReceta> item = new Vector<DetReceta>();
        DbBean con = new DbBean();
        String sql = "Select * from DetReceta";
        if(sw == true){
            sql = sql + " WHERE (recetaID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                DetReceta detReceta = new DetReceta();
                detReceta.setRecetaID(resultado.getInt(1));
                detReceta.setInsumoID(resultado.getInt(2));
                detReceta.setCantidad(resultado.getInt(3));
                item.addElement(detReceta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public void borraDeta(String idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete from DetReceta  WHERE (recetaID = "+ idVe +")";
       System.out.println("Del dv "+sql);
       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        
    }
    public int procesaItem(DetReceta dr, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO DetReceta VALUES ("+ dr.getRecetaID()+", "+ dr.getInsumoID()+", "+ dr.getCantidad()+")";
          //  System.out.println("EVallll: "+sql);
       }
       if(proc.equals("update")){
            sql="UPDATE DetReceta set insumoID  = '"+ dr.getInsumoID() +"', cantidad = '"+ dr.getCantidad() +"' where recetaID = '"+ dr.getRecetaID() +"'";
       }
       //System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(SQLException e){
        }
          return resultado;
      } 
}
