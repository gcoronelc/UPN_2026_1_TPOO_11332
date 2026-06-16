
package DAO;

import BEAN.CabOrdenDeVenta;
import BEAN.DetOrdenDeVenta;
import UTIL.DbBean;

public class VentaDao {
    public void insertaCabVenta(CabOrdenDeVenta cv){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = " INSERT INTO CabOrdenDeVenta(ordenDeVentaID, empleadoID, clienteID, mesaID, fechaVenta, metodoPago, tipEntrega)\n " +
                " VALUES ("+cv.getOrdenDeVentaID()+", "+cv.getEmpleadoID()+", "+cv.getClienteID()+", "+cv.getMesaID()+", '"+cv.getFechaVenta()+" 00:00:00', "+cv.getMetodoPago()+", '"+cv.getTipEntrega()+"');\n" +
                "\n";
        
        try{
            System.out.println(sql);
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    public void insertaDetVenta(DetOrdenDeVenta dv){
        
        String sql;
        DbBean con = new DbBean();
        
        sql =   " INSERT INTO DetOrdenDeVenta(ordenDeVentaID, productoID, idPedidos, cantidad)\n" +
                " VALUES ("+dv.getOrdenDeVentaID()+", "+dv.getProductoID()+", "+dv.getIdPedidos()+", "+dv.getCantidad()+");\n";
        
        try{
            System.out.println(sql);
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
}
