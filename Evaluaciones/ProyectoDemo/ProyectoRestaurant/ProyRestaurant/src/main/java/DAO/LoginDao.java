
package DAO;

import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public LoginDao() {
    }
    public boolean consultaLogin(String user, String pass){
        DbBean bd = new DbBean();
        boolean comprueba = false;
        try{
            String sql = " SELECT COUNT(*) FROM usuario WHERE usuario = '"+user+"' AND contraseña = '"+pass+"'; ";
            ResultSet resultado = bd.resultadoSQL(sql);
            if(resultado.next()){
               if(resultado.getInt(1)==1){
                   comprueba=true;
               }else{
                   comprueba=false;
               }
            }
        }catch(Exception e){
            e.printStackTrace();
            comprueba=false;
        }
        try{
            bd.desconecta();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return comprueba;
    }
}
