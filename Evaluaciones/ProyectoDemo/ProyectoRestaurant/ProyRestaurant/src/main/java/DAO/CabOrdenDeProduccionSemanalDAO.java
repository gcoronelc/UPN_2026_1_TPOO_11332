
package DAO;

import BEAN.CabOrdenDeProduccionSemanal;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CabOrdenDeProduccionSemanalDAO {
    public Vector<CabOrdenDeProduccionSemanal> ListaCodps(boolean sw, String str){
        Vector<CabOrdenDeProduccionSemanal> lista = new Vector<CabOrdenDeProduccionSemanal>();
        DbBean con = new DbBean();
        String sql = "Select * from CabOrdenDeProduccionSemanal";
        if(sw == true){
            sql = sql + " where (empleadoID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                CabOrdenDeProduccionSemanal cabOrPro = new CabOrdenDeProduccionSemanal();
                cabOrPro.setOrdenProduccionID(resultado.getInt(1));
                cabOrPro.setEmpleadoID(resultado.getInt(2));
                cabOrPro.setDescripArea(resultado.getString(3));
                cabOrPro.setFechaxsem(resultado.getString(4));
                lista.addElement(cabOrPro);
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
    public int procesaItem(CabOrdenDeProduccionSemanal cv, String proc){
       int resultado=0;
       String sql= "";
       DbBean con = new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO CabOrdenDeProduccionSemanal VALUES ("+ cv.getOrdenProduccionID() +", "+ cv.getEmpleadoID() +", "+ cv.getDescripArea() +", "+ cv.getFechaxsem() +")";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE CabOrdenDeProduccionSemanal set fechaxsem  = '"+ cv.getFechaxsem() +"', empleadoID = '"+ cv.getEmpleadoID() +"', descripArea = '"+ cv.getDescripArea() +"' where id_venta = '"+ cv.getOrdenProduccionID() +"'";
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
