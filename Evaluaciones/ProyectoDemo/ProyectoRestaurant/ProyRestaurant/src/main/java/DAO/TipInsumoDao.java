
package DAO;

import BEAN.TipInsumo;
import UTIL.DbBean;
import UTIL.Util;
import java.sql.ResultSet;
import java.util.Vector;

public class TipInsumoDao {
    public String devTipInsumo(int idInsu){
    
        Util util = new Util();
        
        String idInsumo = Integer.toString(idInsu);
        String insumo = util.cadExp("TipInsumo", "idTipInsumo", "descripcion", idInsumo);
        
        return insumo;
    
    }
    
   public int devIDTipInsumo(String tipInsu){
    
        Util util = new Util();
        
        int idTipInsu = util.idExp("TipInsumo", "idTipInsumo", "descripcion", tipInsu);
    
        return idTipInsu;
    }
    
     public void eliminarTipInsumo(TipInsumo tipInsumo){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from TipInsumo";
        sql = sql+ " where idTipInsumo = "+tipInsumo.getIdInsumo()+" ";
        
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
    
    public void actualizarTipInsumo(TipInsumo tipInsu){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update TipInsumo set ";
        sql = sql+ " descripcion = '"+tipInsu.getDescripcion()+"' ";
        sql = sql+ " where idTipInsumo = "+tipInsu.getIdInsumo()+" ";
        
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
    
    public void insertaTipInsumo(TipInsumo tipInsu){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into TipInsumo values ( ";
        sql = sql +tipInsu.getIdInsumo()+", '"+tipInsu.getDescripcion()+"')" ;

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

    
    public Vector<TipInsumo> llenaTipInsumo(){
    
        String sql;
        Vector<TipInsumo> listaTipInsumo = new Vector<TipInsumo>();
        DbBean con = new DbBean();
    
        sql = "select * from TipInsumo ";
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                TipInsumo tipInsu = new TipInsumo();
                
                tipInsu.setIdInsumo(resul.getInt(1));
                tipInsu.setDescripcion(resul.getString(2));

                listaTipInsumo.addElement(tipInsu);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaTipInsumo;
    }
    
    
    public Vector<TipInsumo> listaTipInsumo(boolean valida, String cadena){
    
        String sql;
        Vector<TipInsumo> listaTipInsumo = new Vector<TipInsumo>();
        DbBean con = new DbBean();
    
        sql = "select * from TipInsumo ";
   
        if (valida == true){
           sql = sql + " where idTipInsumo like '"+ cadena +"%'"+ " or "+ " descripcion like '"+cadena+"%' ";
        }
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                TipInsumo tipInsu = new TipInsumo();
                
                tipInsu.setIdInsumo(resul.getInt(1));
                tipInsu.setDescripcion(resul.getString(2));

                listaTipInsumo.addElement(tipInsu);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaTipInsumo;
    }
}
