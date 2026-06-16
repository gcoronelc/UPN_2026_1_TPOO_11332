
package DAO;

import BEAN.Mesa;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MesaDao {
        public Vector<Mesa> ListaMesa(){
        Vector<Mesa> lista = new Vector<Mesa>();
        DbBean con = new DbBean();
        String sql = "Select * from Mesa";
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Mesa me = new Mesa();
                me.setMesaID(resultado.getInt(1));
                me.setUbic(resultado.getString(2));
                me.setNumSillas(resultado.getInt(3));
                me.setEstado(resultado.getInt(4));
                lista.addElement(me);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
        public int devuelveIdMesa(String Ubic){
        String sql;
        int idMesa = 0;
        DbBean con = new DbBean();
        sql = "Select mesaID from Mesa where ubic = '"+Ubic+"'";
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            if(resultado.next()){
                idMesa = resultado.getInt(1);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return idMesa;
    }
    
    public Vector<Mesa> ListaItem(boolean sw, String str){
        Vector<Mesa> item = new Vector<Mesa>();
        DbBean con = new DbBean();
        String sql = "Select * from mesa";
        if(sw == true){
            sql = sql + " WHERE (mesaID = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Mesa mesa = new Mesa();
                mesa.setMesaID(resultado.getInt(1));
                mesa.setUbic(resultado.getString(2));
                mesa.setNumSillas(resultado.getInt(3));
                item.addElement(mesa);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}
        return item;
    }
    
    public int procesaItem(Mesa mes, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO CabOrdenProdSem VALUES ("+ mes.getMesaID()+", '"+ mes.getUbic()+"', "+ mes.getNumSillas()+")";
       }
       if(proc.equals("update")){
            sql="UPDATE mesa set empleadoID  = '"+ mes.getMesaID() +"', fechaxSem = '"+ mes.getUbic()+"' where id_venta = '"+ mes.getNumSillas()+"'";
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
