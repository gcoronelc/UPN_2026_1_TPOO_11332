package pe.edu.upn.semana03_11332.service;

import pe.edu.upn.semana03_11332.exception.NotaFueraRangoV1;

public class Promedio {
    
    public int promediarV1(int n1, int n2, int n3) throws NotaFueraRangoV1{
        // Validar
        validarNotaV1(n1);
        validarNotaV1(n2);
        validarNotaV1(n3);
        // Proceso
        int prom = (n1 + n2 + n3) / 3;
        // Reporte
        return prom;
    }

    private void validarNotaV1(int nota) throws NotaFueraRangoV1 {
        if(nota<0 || nota>20){
            throw new NotaFueraRangoV1(nota);
        }
    }
    
}
