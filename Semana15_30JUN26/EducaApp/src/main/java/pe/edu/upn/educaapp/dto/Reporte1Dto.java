package pe.edu.upn.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte1Dto {

    private int id;
    private String nombre;
    private int vacantes;
    private int matriculados;
    private double porcentaje;

    

}
