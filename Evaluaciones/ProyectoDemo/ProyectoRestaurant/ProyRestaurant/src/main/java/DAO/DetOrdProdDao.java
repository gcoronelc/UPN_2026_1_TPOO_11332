
package DAO;

import BEAN.DetOrdenDeProduccionSemanal;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetOrdProdDao {
    public Vector<DetOrdenDeProduccionSemanal> ListaItem(boolean sw, String str){
        Vector<DetOrdenDeProduccionSemanal> item = new Vector<DetOrdenDeProduccionSemanal>();
        DbBean con = new DbBean();
        String sql = "Select * from DetOrdenDeProduccionSemanal";
        if(sw == true){
            sql = sql + " WHERE (platoID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                DetOrdenDeProduccionSemanal detOrdProd = new DetOrdenDeProduccionSemanal();
                detOrdProd.setOrdenProduccionID(resultado.getInt(1));
                detOrdProd.setProductoID(resultado.getInt(2));
                detOrdProd.setCantidad(resultado.getInt(3));
                item.addElement(detOrdProd);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(DetOrdenDeProduccionSemanal cp, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO DetOrdenProdSem VALUES ('"+ cp.getOrdenProduccionID()+"', '"+ cp.getProductoID()+"', '"+ cp.getCantidad()+"')";
            System.out.println("oooooo" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE DetOrdenProdSem set platoID  = '"+ cp.getProductoID()+"', cantidad = '"+ cp.getCantidad()+"' where id_venta = '"+ cp.getOrdenProduccionID()+"'";
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
