
package DAO;

import BEAN.Producto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProductoDao {
    public void insertaProducto(Producto p){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Producto values ( ";
        sql = sql +p.getProductoID()+", "+p.getIdplato()+", "+p.getIdtipo()+", '"+p.getDescripProducto()+"', ";
        sql = sql +p.getCantidad()+", "+p.getPrecioUnit()+")";

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
    
    public void actualizarProducto(Producto p){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Producto set ";
        sql = sql+ " idPlato = "+p.getIdplato()+" ";
        sql = sql+ " idTipProducto = "+p.getIdtipo()+" ";
        sql = sql+ " descripProducto = '"+p.getDescripProducto()+"' ";
        sql = sql+ " cantidad = "+p.getCantidad()+" ";
        sql = sql+ " precioUnit = "+p.getPrecioUnit()+" ";
        sql = sql+ " where productoID = "+p.getProductoID()+" ";
        
        try{
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
     public void eliminarProducto(Producto p){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Producto";
        sql = sql+ " where areaID = "+p.getProductoID()+" ";
        
        try{
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
    
    public Vector<Producto> ListaProducto(boolean sw, String str){
        Vector<Producto> lista = new Vector<Producto>();
        DbBean con = new DbBean();
        String sql = "Select * from Producto";
        if(sw == true){
            sql = sql + " WHERE (descripProducto LIKE '"+ str +"%')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Producto pro = new Producto();
                pro.setProductoID(resultado.getInt(1));
                pro.setIdplato(resultado.getInt(2));
                pro.setIdtipo(resultado.getInt(3));
                pro.setDescripProducto(resultado.getString(4));
                pro.setCantidad(resultado.getInt(5));
                pro.setPrecioUnit(resultado.getDouble(6));
                lista.addElement(pro);
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
    public Vector<Producto> ListaProducto2(boolean sw, String str){
        Vector<Producto> lista = new Vector<Producto>();
        DbBean con = new DbBean();
        int id = Integer.parseInt(str);
        String sql = "select p.productoId, p.descripProducto, p.idTipProducto, p.precioUnit\n" +
                     "from Producto as p inner join DetOrdenDeVenta as do on p.productoID = do.productoID";
        if(sw == true){
            sql = sql + " WHERE (do.OrdenDeVentaID = "+ str +" )";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Producto pro = new Producto();
                pro.setProductoID(resultado.getInt(1));
                pro.setDescripProducto(resultado.getString(2));
                pro.setIdtipo(resultado.getInt(3));
                pro.setPrecioUnit(resultado.getDouble(4));
                lista.addElement(pro);
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
    public int procesaItem(Producto cv, String proc){
       int resultado = 0;
       String sql = "";
       DbBean con = new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO Producto VALUES ('"+ cv.getProductoID() +"', '"+ cv.getIdplato() +"', '"+ cv.getIdtipo()+"', '"+ cv.getDescripProducto() +"', '"+ cv.getCantidad() +"', '"+ cv.getPrecioUnit() +"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE Producto set idPlato  = '"+ cv.getIdplato() +"', idTipProducto = '"+ cv.getIdtipo()+"', descripProducto = '"+ cv.getDescripProducto() +"', cantidad = '"+ cv.getCantidad() +"', precioUnit = '"+ cv.getPrecioUnit() +"' where productoID = '"+ cv.getProductoID() +"'";
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
