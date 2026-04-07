package pe.edu.upn.semana03_11332.prueba;

import pe.edu.upn.semana03_11332.exception.NotaFueraRangoV1;
import pe.edu.upn.semana03_11332.service.Promedio;

public class Prueba03 {
    
    public static void main(String[] args) {
        
        try {
            
            // Datos
            int nota1 = 18;
            int nota2 = 10;
            int nota3 = 27;
            
            // Proceso
            Promedio promedio = new Promedio();
            int prom = promedio.promediarV1(nota1, nota2, nota3);
            
            // Reporte
            System.out.println("Promedio: " + prom);
            
        } catch (NotaFueraRangoV1 ex) {
            
            System.err.println(ex.getMessage());
            
        }
        
    }
    
}
