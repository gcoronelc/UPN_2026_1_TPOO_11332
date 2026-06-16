
package DAO;

import BEAN.CabReceta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CabRecetaDao {
    public Vector<CabReceta> ListaItem(boolean sw, String str){
        Vector<CabReceta> item = new Vector<CabReceta>();
        DbBean con = new DbBean();
        String sql = "Select * from CabReceta";
        if(sw == true){
            sql = sql + " WHERE (empleadoID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                CabReceta cabReceta = new CabReceta();
                cabReceta.setRecetaID(resultado.getInt(1));
                cabReceta.setEmpleadoID(resultado.getInt(2));
                cabReceta.setProductoID(resultado.getInt(3));
                cabReceta.setFechaElab(resultado.getString(4));
                cabReceta.setPreparacion(resultado.getString(5));
                item.addElement(cabReceta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(CabReceta cr, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO CabReceta VALUES ('"+ cr.getRecetaID()+"', '"+ cr.getEmpleadoID()+"', '"+ cr.getProductoID()+"', '"+ cr.getFechaElab() +"', '"+ cr.getPreparacion()+"')";
            //System.out.println("uuuuuuu " + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE CabReceta set empleadoID  = '"+ cr.getEmpleadoID() +"', productoID = '"+ cr.getProductoID()+"', fechaElab = '"+ cr.getFechaElab() +"', preparacion = '"+ cr.getPreparacion() +"' where recetaID = '"+ cr.getRecetaID() +"'";
       }
      // System.out.println("Observando el estado de la sentencia sql: "+sql);

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
