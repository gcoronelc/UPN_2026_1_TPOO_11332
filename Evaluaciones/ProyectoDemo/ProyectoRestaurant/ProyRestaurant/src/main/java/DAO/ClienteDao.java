
package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ClienteDao {
    public Vector<Cliente> ListaCliente(boolean sw, String str){
        Vector<Cliente> lista = new Vector<Cliente>();
        DbBean con = new DbBean();
        String sql = "Select * from Cliente";
        if(sw == true){
            sql = sql + " WHERE (apellidos LIKE '"+ str +"%') OR (nombres LIKE '" + str + "%')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Cliente clie = new Cliente();
                clie.setClienteID(resultado.getInt(1));
                clie.setNombres(resultado.getString(2));
                clie.setApellidos(resultado.getString(3));
                clie.setDni(resultado.getString(4));
                clie.setGenero(resultado.getInt(5));
                clie.setEstadoCivil(resultado.getString(6));
                clie.setTelefono(resultado.getInt(7));
                clie.setCorreo(resultado.getString(8));
                clie.setFechNaci(resultado.getString(9));
                clie.setEstado(resultado.getInt(10));
                clie.setDireccion(resultado.getString(11));
                lista.addElement(clie);
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
    public Vector<Cliente> ListaCliente2(boolean sw, String str){
        Vector<Cliente> lista = new Vector<Cliente>();
        DbBean con = new DbBean();
        String sql = "select distinct c.ClienteID, c.nombres, c.apellidos, c.estado ";
                sql += "from Cliente as c inner join CabOrdenDeVenta as cb on c.ClienteID = cb.ClienteID";
        if(sw == true){
            sql = sql + " WHERE (apellidos LIKE '"+ str +"%') OR (nombres LIKE '" + str + "%')";
        }
        System.out.println(sql);
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Cliente clie = new Cliente();
                clie.setClienteID(resultado.getInt(1));
                clie.setNombres(resultado.getString(2));
                clie.setApellidos(resultado.getString(3));
                clie.setEstado(resultado.getInt(4));
                lista.addElement(clie);
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
    public int procesaItem(Cliente c, String proc){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       if(proc.equals("insert")){
            sql="INSERT INTO Cliente VALUES ("+ c.getClienteID() +", '"+ c.getNombres() +"', '"+ c.getApellidos() +"', '"+ c.getDni() +"', "+ c.getGenero() +", '"+ c.getEstadoCivil() +"', "+ c.getTelefono() +", '"+ c.getCorreo() +"', '"+ c.getFechNaci() +"', "+ c.getEstado() +", '"+ c.getDireccion() +"')";
            System.out.println("uuuuuuu" + sql);
       }
       if(proc.equals("update")){
            sql="UPDATE Cliente set nombres = '"+ c.getNombres() +"', apellidos = '"+ c.getApellidos() +"', dni = '"+ c.getDni() +"', genero = '"+ c.getGenero() +"', estadoCivil = '"+ c.getEstadoCivil() +"', telefono = '"+ c.getTelefono() +"', correo = '"+ c.getCorreo() +"', fechaNaci = '"+ c.getFechNaci() +"', estado = '"+ c.getEstado() +"', direccion = '"+ c.getDireccion() +"' where clienteID = '"+ c.getClienteID() +"'";
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(java.sql.SQLException e){
            e.printStackTrace();
        }
          return resultado;
    }
}
