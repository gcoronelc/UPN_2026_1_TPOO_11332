
package DAO;

import BEAN.LocalR;
import BEAN.Usuario;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

public class UsuarioDao {
    Usuario user = new Usuario();
    LocalR local = new LocalR();
    boolean val = false;
    
    public UsuarioDao() {
    }
    
    public String consultaContra(int usuarioID, int idLocalR, String usuario, int tipoUsuario, int empleadoID){
        DbBean con = new DbBean();
        String pass="";
        String sql = " select contraseña\n" +
                     " from Usuario\n" +
                     " where usuarioID="+usuarioID+" and idLocalR="+idLocalR+" and usuario = '"+usuario+"' and tipoUsuario= "+tipoUsuario+" and empleadoID="+empleadoID+"; ";
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                user.setContrasena(resultado.getString(1));
            }
            pass = user.getContrasena();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pass;
    }
    
    public int consulta(String usuario, String contraseña){
        
        DbBean con = new DbBean();
        int id=0;
        String sql = "";
        
        try{
            
            sql = sql + "select empleadoID  \n";
            sql = sql + " from usuario \n";
            sql = sql +" where usuario = '"+usuario+"' and contraseña = '"+contraseña+"' ";
            
            
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                user.setIdEmpleado(resultado.getInt(1));
            }
            id = user.getIdEmpleado();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        
        return id;
    }
    
    
    // consulta si los datos existen en la BD
    
    public boolean consultaLogin(String usuario, String contraseña, String localID){
        
        DbBean con = new DbBean();
        
        String sql = "";
        
        try{
            
            sql = sql+"select COUNT(*) \n";
            sql = sql + " from usuario \n";
            sql = sql +" where usuario = '"+usuario+"' and contraseña = '"+contraseña+"' and idLocalR = '"+localID+"' ";
            
            
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                int respuesta=resultado.getInt(1);
                if(respuesta==1){
                    return true;
                }else if(respuesta==0){
                    JOptionPane.showMessageDialog(null, "ID LOCAL/USUARIO/CONTRASEÑA --> INCORRECTOS");
                    return false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        JOptionPane.showMessageDialog(null,"Problemas en la BD");
        return false;
    }
    
    //consulta si es un tipo de usuario 1 --> que puede ver todo
    // sino no podra ver algunos menus.
    
    public int confirmaUsuario (String usuario, String contraseña,String localID){
        
        DbBean con = new DbBean();
        int resp=0;
        String sql = "";
        String tipUsuario;
        
        try{
            
            sql = "select tipoUsuario\n";
            sql = sql + " from usuario ";
            sql = sql +" where usuario = '"+usuario+"' and contraseña = '"+contraseña+"' and idLocalR = '"+localID+"' ";
            
            
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                user.setTipoUsuario(resultado.getInt(1));
                
                tipUsuario = Integer.toString(user.getTipoUsuario());
                
                if(tipUsuario.equals("1")){
                    resp = 1;
                    return resp;
                }else if(tipUsuario.equals("2")) {
                    resp = 2;
                    return resp;
                } else if(tipUsuario.equals("3")){
                    resp = 3;
                    return resp;
                }else{
                    resp = 4;
                    return resp;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){
        }
        return resp;    
    }
    
    
    public Vector<Usuario> listaUsuario(boolean valida, String cadena){
    
        String sql;
        Vector<Usuario> listaUsuario = new Vector<Usuario>();
        DbBean con = new DbBean();
    
        sql = "select * from Usuario ";
   
        if (valida == true){
           sql = sql + " where usuarioID like '"+ cadena +"%'"+ " or "+ " usuario like '"+cadena+"%' ";
        }
            
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Usuario usu = new Usuario();
                usu.setUsuarioID(resul.getInt(1));
                usu.setIdLocalR(resul.getInt(2));
                usu.setUsuario(resul.getString(3));
                usu.setContrasena(resul.getString(4));
                usu.setTipoUsuario(resul.getInt(5));
                usu.setIdEmpleado(resul.getInt(6));

                listaUsuario.addElement(usu);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaUsuario;
    }
    public void eliminarUsuario(Usuario user){
    
        String sql;
        DbBean con = new DbBean();
        
        sql = "delete from Usuario";
        sql = sql+ " where usuarioID = "+user.getUsuarioID()+" ";
        
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
    public void insertaUsuario(Usuario user){
        
        String sql;
        DbBean con = new DbBean();
        
        sql = "insert into Usuario values ( ";
        sql = sql +user.getUsuarioID()+", "+user.getIdLocalR()+", '"+user.getUsuario()+"', '";
        sql = sql +user.getContrasena()+"', "+user.getTipoUsuario()+", "+user.getIdEmpleado()+") ";

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
    
    public void actualizarUsuario(Usuario user){

        String sql;
        DbBean con = new DbBean();
        
        sql = "update Usuario set ";
        sql = sql+ " idLocalR = "+user.getIdLocalR()+", ";
        sql = sql+ " usuario = '"+user.getUsuario()+"', ";
        sql = sql+ " contraseña = '"+user.getContrasena()+"', ";
        sql = sql+ " tipoUsuario = "+user.getTipoUsuario()+", ";
        sql = sql+ " empleadoID = "+user.getIdEmpleado()+" ";
        
        sql = sql+ " where usuarioID = "+user.getUsuarioID()+" ";
        
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
