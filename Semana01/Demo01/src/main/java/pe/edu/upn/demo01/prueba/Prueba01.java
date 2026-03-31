package pe.edu.upn.demo01.prueba;

import pe.edu.upn.demo01.service.MateService;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        // Datos
        int num1 = 40;
        int num2 = 20;
        
        // Proceso
        MateService mateService = new MateService();
        int suma = mateService.sumar(num1, num2);
        int resta = mateService.restar(num1, num2);
        
        // Reporte
        System.out.println("Suma: " + suma);        
        System.out.println("Resta: " + resta);        
        
    }
    
}
