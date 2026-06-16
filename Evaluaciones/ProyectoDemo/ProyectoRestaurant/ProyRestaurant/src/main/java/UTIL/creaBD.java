package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class creaBD {
    
    public  void accesoBDCrea(String sql) {
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "sql";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("La base de datos se creó exitosamente.");

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al crear la base de datos:");
            e.printStackTrace();
        }
    }
    
}