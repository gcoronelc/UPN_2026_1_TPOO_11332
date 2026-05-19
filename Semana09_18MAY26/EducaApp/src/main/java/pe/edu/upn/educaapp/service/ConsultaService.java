package pe.edu.upn.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upn.educaapp.db.AccesoDB;
import pe.edu.upn.educaapp.dto.AlumnoMatDto;

/**
 * En esta clase se deben programar todas las consultas.
 * 
 * @author UPN
 */
public class ConsultaService {


    public List<AlumnoMatDto> matriculadosPorCurso(int idCurso){
        List<AlumnoMatDto> lista = new ArrayList<>();
        PreparedStatement pstm;
        ResultSet rs;
        String sql = """
                select 
                    a.alu_id id, a.alu_nombre nombre,
                    ISNULL(a.alu_telefono,'None') telefono,
                    m.mat_tipo tipo
                from MATRICULA m 
                join ALUMNO a on m.alu_id = a.alu_id
                where cur_id = ?
             """;
        try (Connection cn = AccesoDB.getConnection()) {
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            rs = pstm.executeQuery();
            while(rs.next()){
                AlumnoMatDto bean = new AlumnoMatDto();
                bean.setId(rs.getInt("id"));
                bean.setNombre(rs.getString("nombre"));
                bean.setTelefono(rs.getString("telefono"));
                bean.setTipo(rs.getString("tipo"));
                lista.add(bean);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lista;  
    }

    
}
