package pe.edu.upn.educaapp.dto;

public class MatriculaDto {

    private int idCurso;
    private int idAlumno;
    private int idEmpleado;
    private String tipo;
    private int cuotas;

    public MatriculaDto() {
    }

    public MatriculaDto(int idCurso, int idAlumno, int idEmpleado, String tipo, int cuotas) {
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        this.idEmpleado = idEmpleado;
        this.tipo = tipo;
        this.cuotas = cuotas;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

   

}
