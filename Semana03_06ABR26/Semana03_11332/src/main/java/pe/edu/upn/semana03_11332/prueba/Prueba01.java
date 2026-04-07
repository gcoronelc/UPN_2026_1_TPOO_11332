package pe.edu.upn.semana03_11332.prueba;

import pe.edu.upn.semana03_11332.service.MateV1;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        // Es necesario crear una instancia de MateV1
        // Por que sus metodos tienen alcance de instancia
        MateV1 mateV1 = new MateV1(); 
        
        int suma1 = mateV1.sumar(3, 5);
        
        System.out.println("Suma 1: " + suma1);
        
        
        
    }
    
}
