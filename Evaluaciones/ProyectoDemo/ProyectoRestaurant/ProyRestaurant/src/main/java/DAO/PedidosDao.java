
package DAO;

import BEAN.Pedidos;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class PedidosDao {
        public Vector<Pedidos> ListaPedidos(boolean sw, String str){
        Vector<Pedidos> lista = new Vector<Pedidos>();
        DbBean con = new DbBean();
        String sql = "Select * from Pedidos";
        if(sw == true){
            sql = sql + " where (idPedidos = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Pedidos ped = new Pedidos();
                ped.setIdPedidos(resultado.getInt(1));
                ped.setEmpleadoID(resultado.getInt(2));
                ped.setUbic(resultado.getString(3));
                ped.setEstado(4);
                lista.addElement(ped);
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
    public int procesaItem(Pedidos cv, String proc){
       int resultado = 0;
       String sql = "";
       DbBean con = new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO Pedidos VALUES ("+ cv.getIdPedidos() +", "+ cv.getEmpleadoID() +", '"+ cv.getUbic() +"', "+ cv.getEstado() +")";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE Pedidos set empleadoID  = '"+ cv.getEmpleadoID() +"', ubic = '"+ cv.getUbic() +"', estado = '"+ cv.getEstado() +"' where idPedidos = '"+ cv.getIdPedidos() +"'";
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
