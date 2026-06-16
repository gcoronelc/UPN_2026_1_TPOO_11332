
package DAO;

import BEAN.Plato;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class PlatoDao {
    public Vector<Plato> ListaPlatos(boolean sw, String str){
        Vector<Plato> lista = new Vector<Plato>();
        DbBean con = new DbBean();
        String sql = "Select * from Plato";
        if(sw == true){
            sql = sql + " where (descPlato = '"+ str +"')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Plato pla = new Plato();
                pla.setIdPlato(resultado.getInt(1));
                pla.setDescPlat(resultado.getString(2));
                lista.addElement(pla);
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
    
    
    
    public Vector <Plato> listaPlato(){
    DbBean con = new DbBean();
    Vector<Plato> lista = new Vector<Plato>();
    String sql = "Select * from Plato";
    try{
        ResultSet resultado = con.resultadoSQL(sql);
        while(resultado.next()){
            Plato pt = new Plato();
            pt.setIdPlato(resultado.getInt(1));
            pt.setDescPlat(resultado.getString(2));
            lista.addElement(pt);
        }
    }catch(java.sql.SQLException e){
         e.printStackTrace();
    }
    return lista;
    }
    
    public int devuelveIdPlato(String descPlat){
    String sql;
    int idPlato = 0;
    DbBean con = new DbBean();
    sql = "SELECT IdPlato FROM Plato where descPlat= '"+ descPlat +"'";
    try{
        ResultSet resultado = con.resultadoSQL(sql);
        if(resultado.next()){
                idPlato = resultado.getInt(1);
            } 
    }catch(java.sql.SQLException e){
         e.printStackTrace();
    }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return idPlato;
    }
}
