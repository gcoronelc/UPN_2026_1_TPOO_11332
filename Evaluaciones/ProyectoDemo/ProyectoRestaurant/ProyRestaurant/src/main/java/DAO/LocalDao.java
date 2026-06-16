
package DAO;

import BEAN.LocalR;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class LocalDao {
    public Vector<LocalR> listaLocal(){
    
        String sql;
        Vector<LocalR> listaLocal = new Vector<LocalR>();
        DbBean con = new DbBean();
    
        sql = "select * from LocalR ";
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                LocalR l = new LocalR();
                l.setIdLocalR(resul.getInt(1));
                
                listaLocal.addElement(l);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaLocal;
    }      
}
