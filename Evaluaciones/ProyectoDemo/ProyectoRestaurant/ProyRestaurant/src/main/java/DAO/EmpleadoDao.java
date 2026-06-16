
package DAO;

import BEAN.Empleado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EmpleadoDao {
    public int devuelveIdEmpleado(String nombre){
        String sql;
        int idEmpleado = 0;
        DbBean con = new DbBean();
        sql = "Select empleadoID from Empleado where nombres = '"+nombre+"'";
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            if(resultado.next()){
                idEmpleado = resultado.getInt(1);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return idEmpleado;
    }
      public Vector<Empleado> sinContrato(boolean sw, String str){
        
        Vector<Empleado> item = new Vector<Empleado>();
        DbBean con = new DbBean();
        String sql = " select e.empleadoID, e.nombres, e.apellidos, e.fechaNacimiento, e.genero, e.dni, e.estadoCivil ";
               sql = sql + " from empleado as e left join contrato as c on  ";
               sql = sql + " e.empleadoID = c.empleadoID ";
               sql = sql + " where c.empleadoID is Null ";
            
               if(sw == true){
                    sql = sql + " and ( e.empleadoID like '"+ str +"%' "+ " or "+ " e.nombres like '"+str+"%' or "+ " e.apellidos like '"+str+"%' )";
               }

        try{
            ResultSet resul = con.resultadoSQL(sql);

            while(resul.next()){
                
                Empleado emp = new Empleado();
                
                emp.setEmpleadoID(resul.getInt(1));
                emp.setNombres(resul.getString(2));
                emp.setApellidos(resul.getString(3));
                emp.setFechaNacimiento(resul.getString(4));
                emp.setGenero(resul.getInt(5));
                emp.setDni(resul.getString(6));
                emp.setEstadoCivil(resul.getString(7));

                item.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}

        return item;
    }
        
   public Vector<Empleado> listaEmpleado (boolean valida, String cadena){
    
        String sql;
        Vector<Empleado> listaEmp = new Vector<Empleado>();
        DbBean con = new DbBean();
        
        sql = "select empleadoID, nombres, apellidos, fechaNacimiento, genero, dni, estadoCivil from Empleado ";
   
            if (valida == true){
                sql = sql + " where nombres like '"+ cadena +"%'"+ " or " + "apellidos like '"+cadena+"%'"+ " or " + " empleadoID like '"+cadena+"%' ";
            }
        
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Empleado emp = new Empleado();
                
                emp.setEmpleadoID(resul.getInt(1));
                emp.setNombres(resul.getString(2));
                emp.setApellidos(resul.getString(3));
                emp.setFechaNacimiento(resul.getString(4));
                emp.setGenero(resul.getInt(5));
                emp.setDni(resul.getString(6));
                emp.setEstadoCivil(resul.getString(7));

                listaEmp.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmp;
    }  
    
    
    
   public Vector<Empleado> listado (int id){
    
        String sql;
        Vector<Empleado> listaEmp = new Vector<Empleado>();
        DbBean con = new DbBean();
        
        sql = "select nombres,apellidos\n" +
                "from Empleado\n" +
                "where empleadoID = " +id+" ";
   
        
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Empleado emp = new Empleado();
         
                emp.setNombres(resul.getString(1));
                emp.setApellidos(resul.getString(2));

                listaEmp.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmp;
    }
    public Vector<Empleado> listaEmpleadoNoUsers (boolean valida, String cadena){
    
        String sql;
        Vector<Empleado> listaEmp = new Vector<Empleado>();
        DbBean con = new DbBean();
        
        sql = " SELECT e.empleadoID,e.nombres,e.apellidos,e.dni ";
        sql = sql + " FROM empleado as e LEFT JOIN usuario as u ON e.empleadoID = u.empleadoID ";
        sql = sql +" WHERE u.empleadoID IS NULL ";
            if (valida == true){
                sql = sql + " and ( nombres like '"+ cadena +"%'"+ " or " + "apellidos like '"+cadena+"%'"+ " or " + " empleadoID like '"+cadena+"%' )";
            }
        
        try {
                ResultSet resul = con.resultadoSQL(sql);
            
            while(resul.next()){
                Empleado emp = new Empleado();
                
                emp.setEmpleadoID(resul.getInt(1));
                emp.setNombres(resul.getString(2));
                emp.setApellidos(resul.getString(3));
                emp.setDni(resul.getString(4));

                listaEmp.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmp;
    }
    public Vector<Empleado> ListaItem(int sw, String str){
        Vector<Empleado> item = new Vector<Empleado>();
        DbBean con = new DbBean();
        String sql = "Select * from empleado";
        if(sw == 1){
            sql = sql + " WHERE (apellidos LIKE '"+ str +"%') OR (nombres LIKE '" + str + "%')";
        }else if(sw == 2){
            sql = sql + " WHERE empleadoID = "+ str;
        }
        
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                Empleado empleado = new Empleado();
                empleado.setEmpleadoID(resultado.getInt(1));
                empleado.setUsuarioModifID(resultado.getInt(2));
                empleado.setUsuarioCreaID(resultado.getInt(3));
                empleado.setNombres(resultado.getString(4));
                empleado.setApellidos(resultado.getString(5));
                empleado.setFechaNacimiento(resultado.getString(6));
                empleado.setFechCrea(resultado.getString(7));
                empleado.setGenero(resultado.getInt(8));
                empleado.setFechModif(resultado.getString(9));
                empleado.setDni(resultado.getString(10));
                item.addElement(empleado);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(SQLException e){}

        return item;
    }
    public int procesaItem(Empleado em, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO Empleado VALUES ('"+ em.getEmpleadoID()+"', '"+ em.getUsuarioModifID()+"', '"+ em.getUsuarioCreaID()+"', '"+ em.getNombres()+"', '"+ em.getApellidos() +"', '"+ em.getFechaNacimiento()+"', '"+ em.getFechCrea()+"', '"+ em.getGenero()+"', '"+ em.getFechModif()+"', '"+ em.getDni()+"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
                sql="UPDATE Empleado set usuarioModifID = '"+ em.getUsuarioModifID() +"', usuarioCreaID = '"+ em.getUsuarioCreaID() +"', nombres = '"+ em.getNombres() +"', Apellidos = '"+ em.getApellidos() +"', fechaNacimiento = '"+ em.getFechaNacimiento() +"', fechCrea = '"+ em.getFechCrea() +"', genero = '"+ em.getGenero() +"', fechModif = '"+ em.getFechModif() +"', dni = '"+ em.getDni() +"' where empleadoID = '"+ em.getEmpleadoID() +"'";
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(SQLException e){
        }
          return resultado;
      }
}
