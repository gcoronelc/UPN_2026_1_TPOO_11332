
package DAO;

import BEAN.DetOrdenDeVenta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetOrdVentaDao {
    public Vector<DetOrdenDeVenta> ListaItem(boolean sw, String str){
        Vector<DetOrdenDeVenta> item = new Vector<DetOrdenDeVenta>();
        DbBean con = new DbBean();
        String sql = "Select * from DetOrdenDeVenta";
        if(sw == true){
            sql = sql + " WHERE (ordenDeVentaID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                DetOrdenDeVenta detOrdVenta = new DetOrdenDeVenta();
                detOrdVenta.setOrdenDeVentaID(resultado.getInt(1));
                detOrdVenta.setProductoID(resultado.getInt(2));
                detOrdVenta.setCantidad(resultado.getInt(3));
                item.addElement(detOrdVenta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(DetOrdenDeVenta cp, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO DetOrdenDeVenta VALUES ('"+ cp.getOrdenDeVentaID()+"', '"+ cp.getProductoID()+"', '"+ cp.getCantidad()+"')";
            System.out.println("oooooo" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE DetOrdenDeVenta set productoID  = '"+ cp.getProductoID()+"', cantidad = '"+ cp.getCantidad()+"' where id_venta = '"+ cp.getOrdenDeVentaID()+"'";
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

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
