
package DAO;

import BEAN.Contrato;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ContratoDao {
        public Vector<Contrato> ListaItem(boolean sw, String str){
        Vector<Contrato> item = new Vector<Contrato>();
        DbBean con = new DbBean();
        String sql = " Select * from Contrato ";
        if(sw == true){
            sql = sql + " WHERE (contratoID LIKE '"+ str +"%') OR (fechaIni LIKE '" + str + "%') OR (fechaFin LIKE '" + str + "%') OR (sueldo LIKE '" + str + "%')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Contrato contrato = new Contrato();
                
                contrato.setContratoID(resultado.getInt(1));
                contrato.setEmpleadoID(resultado.getInt(2));
                contrato.setRolID(resultado.getInt(3));
                contrato.setAreaID(resultado.getInt(4));
                contrato.setFechaIni(resultado.getString(5));
                contrato.setFechaFin(resultado.getString(6));
                contrato.setEstado(resultado.getInt(7));
                contrato.setSueldo(resultado.getDouble(8));

                item.addElement(contrato);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}

        return item;
    }
        
    public void insertaContrato(Contrato c){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Contrato values ( ";
        sql = sql +c.getContratoID()+", "+c.getEmpleadoID()+", "+c.getRolID()+", "+c.getAreaID()+", '" ;
        sql = sql +c.getFechaIni()+"', '"+c.getFechaFin()+"', "+c.getEstado()+", "+c.getSueldo()+")";

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
    
    public void actualizarContrato(Contrato c){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Contrato set ";
        sql = sql+ " empleadoID = "+c.getEmpleadoID()+", ";
        sql = sql+ " rolID = "+c.getRolID()+", ";
        sql = sql+ " areaID = "+c.getAreaID()+", ";
        sql = sql+ " fechaIni = '"+c.getFechaIni()+"', ";
        sql = sql+ " fechaFin = '"+c.getFechaFin()+ "', ";
        sql = sql+ " estado = "+c.getEstado()+", ";
        sql = sql+ " sueldo = "+c.getSueldo()+ " ";
        sql = sql+ " where contratoID = "+c.getContratoID()+" ";
        
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
    
    public void eliminarContrato(Contrato contrato){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Contrato";
        sql = sql+ " where contratoID = "+contrato.getContratoID()+" ";
        
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
}
