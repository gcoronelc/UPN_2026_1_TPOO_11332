
package DAO;

import BEAN.CabOrdenDeProduccionSemanal;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CabOrdProdDao {
        public Vector<CabOrdenDeProduccionSemanal> ListaItem(boolean sw, String str){
        Vector<CabOrdenDeProduccionSemanal> item = new Vector<CabOrdenDeProduccionSemanal>();
        DbBean con = new DbBean();
        String sql = "Select * from CabOrdenDeProduccionSemanal";
        if(sw == true){
            sql = sql + " WHERE (empleadoID = '"+ str +"')";
        }
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                CabOrdenDeProduccionSemanal cabOrdProd = new CabOrdenDeProduccionSemanal();
                cabOrdProd.setOrdenProduccionID(resultado.getInt(1));
                cabOrdProd.setEmpleadoID(resultado.getInt(2));
                cabOrdProd.setFechaxsem(resultado.getString(3));
                item.addElement(cabOrdProd);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(CabOrdenDeProduccionSemanal cp, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO CabOrdenProdSem VALUES ('"+ cp.getOrdenProduccionID()+"', '"+ cp.getEmpleadoID()+"', '"+ cp.getFechaxsem()+"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE CabOrdenProdSem set empleadoID  = '"+ cp.getEmpleadoID() +"', fechaxSem = '"+ cp.getFechaxsem()+"' where id_venta = '"+ cp.getOrdenProduccionID()+"'";
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
