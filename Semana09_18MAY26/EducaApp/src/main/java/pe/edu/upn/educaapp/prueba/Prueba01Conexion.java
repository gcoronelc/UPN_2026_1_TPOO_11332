package pe.edu.upn.educaapp.prueba;

import java.sql.Connection;
import pe.edu.upn.educaapp.db.AccesoDB;

public class Prueba01Conexion {
    
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion Ok!!!");
            cn.close();
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }
    
}
