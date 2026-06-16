    
package DAO;

import BEAN.CabOrdenDeVenta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CabOrdenDeVentaDao {
        public Vector<CabOrdenDeVenta> ListaCodv(boolean sw, String str){
        Vector<CabOrdenDeVenta> lista = new Vector<CabOrdenDeVenta>();
        DbBean con = new DbBean();
        int id = Integer.parseInt(str);
        String sql = "Select * from CabOrdenDeVenta";
        if(sw == true){
            sql = sql + " where (clienteID = "+ str +")";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                CabOrdenDeVenta cabOrVen = new CabOrdenDeVenta();
                cabOrVen.setOrdenDeVentaID(resultado.getInt(1));
                cabOrVen.setEmpleadoID(resultado.getInt(2));
                cabOrVen.setClienteID(resultado.getInt(3));
                cabOrVen.setMesaID(resultado.getInt(4));
                cabOrVen.setFechaVenta(resultado.getString(5));
                cabOrVen.setMetodoPago(resultado.getInt(6));
                cabOrVen.setTipEntrega(resultado.getString(7));
                lista.addElement(cabOrVen);
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
    public Vector<CabOrdenDeVenta> ListaItem(boolean sw, String str){
        Vector<CabOrdenDeVenta> item = new Vector<CabOrdenDeVenta>();
        DbBean con = new DbBean();
        String sql = "Select * from CabOrdenDeVenta";
        if(sw == true){
            sql = sql + " WHERE (empleadoID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                CabOrdenDeVenta cabOrdenDeVenta = new CabOrdenDeVenta();
                cabOrdenDeVenta.setOrdenDeVentaID(resultado.getInt(1));
                cabOrdenDeVenta.setEmpleadoID(resultado.getInt(2));
                    cabOrdenDeVenta.setClienteID(resultado.getInt(3));
                    cabOrdenDeVenta.setMesaID(resultado.getInt(4));
                    cabOrdenDeVenta.setFechaVenta(resultado.getString(5));
                item.addElement(cabOrdenDeVenta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(CabOrdenDeVenta codv, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO CabOrdenDeVenta VALUES ("+ codv.getOrdenDeVentaID()+", "+ codv.getEmpleadoID()+", "+ codv.getClienteID()+", "+ codv.getMesaID()+", '"+ codv.getFechaVenta()+"')";
            System.out.println("xxxxxx " + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE CabOrdenDeVenta set OrdenDeVentaID  = "+ codv.getOrdenDeVentaID() +", empleadoID = "+ codv.getEmpleadoID()+", clienteID = "+ codv.getClienteID()+", mesaID = "+ codv.getMesaID()+", fechaDeVenta = '"+ codv.getFechaVenta()+"'";
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
