package pe.edu.upn.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upn.educaapp.db.AccesoDB;
import pe.edu.upn.educaapp.dto.ComboDto;

public class ComboService {

    public List<ComboDto> cursosDisponibles(){
        List<ComboDto> lista = new ArrayList<>();
        PreparedStatement pstm;
        ResultSet rs;
        String sql = """
                select cur_id id, cur_nombre nombre
                from curso
                where cur_vacantes > 0
                and cur_vacantes > cur_matriculados
                order by nombre
             """;
        try (Connection cn = AccesoDB.getConnection()) {
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                ComboDto bean = new ComboDto();
                bean.setId(rs.getInt("id"));
                bean.setNombre(rs.getString("nombre"));
                lista.add(bean);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lista;
    }
    
    public List<ComboDto> alumnosDisponibles(int idCurso){
        List<ComboDto> lista = new ArrayList<>();
        PreparedStatement pstm;
        ResultSet rs;
        String sql = """
                select alu_id id, alu_nombre nombre 
                from ALUMNO
                where alu_id not in 
                (select alu_id from MATRICULA where cur_id=?)
                order by 2
             """;
        try (Connection cn = AccesoDB.getConnection()) {
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            rs = pstm.executeQuery();
            while(rs.next()){
                ComboDto bean = new ComboDto();
                bean.setId(rs.getInt("id"));
                bean.setNombre(rs.getString("nombre"));
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
