package pe.edu.upn.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.upn.educaapp.db.AccesoDB;
import pe.edu.upn.educaapp.dto.MatriculaDto;

/**
 * En esta clase se deben programar todos los procesos.
 *
 * @author UPN
 */
public class ProcesoService {

    public void matricular(MatriculaDto bean) {
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs = null;
        String sql;
        int filas;
        double precio = 7777.77; // De prueba
        try {
            // Iniciar TX
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Validaciones
            // Lo vemos despues

            // Registrar matricula
            sql = """
                  insert into MATRICULA(cur_id, alu_id,emp_id,
                  mat_tipo,mat_fecha,mat_precio, mat_cuotas)
                  values(?,?,?,?,GETDATE(),?,?)
                  """;
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdCurso());
            pstm.setInt(2, bean.getIdAlumno());
            pstm.setInt(3, bean.getIdEmpleado());
            pstm.setString(4, bean.getTipo());
            pstm.setDouble(5, precio);
            pstm.setInt(6, bean.getCuotas());
            pstm.executeUpdate();
            pstm.close();
            // Actualiza la cantidad de matriculados
            sql = """
                  update CURSO
                  set cur_matriculados = cur_matriculados + 1
                  where cur_id = ?
                  """;
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdCurso());
            filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new SQLException("Error en el proceso.");
            }
            // Confirmar TX
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso, intente nuevamente!!!");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

}
