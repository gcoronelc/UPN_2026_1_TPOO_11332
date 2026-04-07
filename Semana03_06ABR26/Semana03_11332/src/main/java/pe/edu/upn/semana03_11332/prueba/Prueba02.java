package pe.edu.upn.semana03_11332.prueba;

import pe.edu.upn.semana03_11332.service.MateV2;


public class Prueba02 {
    
    public static void main(String[] args) {
        
        // Por que sumar tiene alcance de clase.
        int suma1 = MateV2.sumar(3, 5);
        
        System.out.println("Suma 1: " + suma1);
    }
}
