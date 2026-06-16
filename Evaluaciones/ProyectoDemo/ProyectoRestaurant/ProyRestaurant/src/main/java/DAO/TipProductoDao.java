
package DAO;

import BEAN.TipProducto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class TipProductoDao {
    public Vector<TipProducto> listaTip(){
        DbBean con = new DbBean();
        Vector<TipProducto> lista = new Vector<TipProducto>();
        String sql = "Select * from TipProducto";
        try{
           ResultSet resultado = con.resultadoSQL(sql);
           while(resultado.next()){
           TipProducto tp = new TipProducto();
            tp.setIdTipProducto(resultado.getInt(1));
            tp.setDescripcion(resultado.getString(2));
            lista.addElement(tp);
           }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public int devuelveIdTipo(String descripcion ){
        String sql;
        int idTipProducto = 0;
        DbBean con = new DbBean();
        sql = "SELECT idTipProducto FROM TipProducto where descripcion = '"+ descripcion +"'";
        try{
          ResultSet resultado = con.resultadoSQL(sql); 
          if(resultado.next()){
            idTipProducto= resultado.getInt(1);
          }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return idTipProducto; 
        
    }
}
