
package DAO;

import BEAN.DetOrdenDeProduccionSemanal;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class DetOrdenDeProduccionSemanalDAO {
    public Vector<DetOrdenDeProduccionSemanal> ListaDodps(boolean sw, String str){
        Vector<DetOrdenDeProduccionSemanal> lista = new Vector<DetOrdenDeProduccionSemanal>();
        DbBean con = new DbBean();
        String sql = "Select * from DetOrdenDeProduccionSemanal";
        if(sw == true){
            sql = sql + " where (productoID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                DetOrdenDeProduccionSemanal dops = new DetOrdenDeProduccionSemanal();
                dops.setOrdenProduccionID(resultado.getInt(1));
                dops.setProductoID(resultado.getInt(2));
                dops.setCantidad(resultado.getInt(3));
                dops.setEstado(resultado.getInt(4));
                lista.addElement(dops);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public int procesaItem(DetOrdenDeProduccionSemanal cv, String proc){
       int resultado = 0;
       String sql = "";
       DbBean con = new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO DetOrdenDeProduccionSemanal VALUES ("+ cv.getOrdenProduccionID() +", "+ cv.getProductoID() +", "+ cv.getCantidad() +", "+ cv.getEstado() +")";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE DetOrdenDeProduccionSemanal set productoID  = '"+ cv.getProductoID() +"', cantidad = '"+ cv.getCantidad() +"', estado = '"+ cv.getEstado() +"' where ordenProduccionID = '"+ cv.getOrdenProduccionID() +"'";
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado = con.ejecutaSQL(sql);
       }catch(java.sql.SQLException e){
            e.printStackTrace();
       }
       try{
            con.desconecta();
       }catch(java.sql.SQLException e){
            e.printStackTrace();
       }
          return resultado;
    }
}
