
package DAO;

import BEAN.Insumo;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InsumoDao {
    public Vector<Insumo> ListaItem(boolean sw, String str){
        Vector<Insumo> item = new Vector<Insumo>();
        DbBean con = new DbBean();
        String sql = "Select * from Insumo";
        if(sw == true){
            sql = sql + " WHERE descripInsumo LIKE '"+ str +"%' or insumoID Like '"+str+"%' or unidadMedida like '"+str+"%' ";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Insumo insumo = new Insumo();
                insumo.setInsumoID(resultado.getInt(1));
                insumo.setIdTipInsumo(resultado.getInt(2));
                insumo.setUnidadMedida(resultado.getString(3));
                insumo.setDescripInsumo(resultado.getString(4));
                insumo.setPrecioUnit(resultado.getDouble(5));
                insumo.setCantidad(resultado.getInt(6));
                item.addElement(insumo);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}

        return item;
    }
    
    public void insertaInsumo(Insumo i){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Insumo values ( ";
        sql = sql +i.getInsumoID()+", "+i.getIdTipInsumo()+", '"+i.getUnidadMedida()+"', '"+i.getDescripInsumo()+"', "+i.getPrecioUnit()+", "+i.getCantidad()+") ";

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

    public void actualizarInsumo(Insumo i){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Insumo set ";
        sql = sql+ " idTipInsumo = "+i.getIdTipInsumo()+", ";
        sql = sql+ " unidadMedida = '"+i.getUnidadMedida()+"', ";
        sql = sql+ " descripInsumo = '"+i.getDescripInsumo()+"', ";
        sql = sql+ " precioUnit = "+i.getPrecioUnit()+ ", ";
        sql = sql+ " cantidad = "+i.getCantidad()+" ";
        sql = sql+ " where insumoID = "+i.getInsumoID()+" ";
        
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
    
    public void eliminarInsumo(int ins){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Insumo ";
        sql = sql + " where insumoID = "+ ins+" ";
    try{
        con.ejecutaSQL(sql);
        
    }catch(java.sql.SQLException e){
        e.printStackTrace();
    }try{
        con.desconecta();
    }catch(java.sql.SQLException e){
     e.printStackTrace();
    }
    }
}
