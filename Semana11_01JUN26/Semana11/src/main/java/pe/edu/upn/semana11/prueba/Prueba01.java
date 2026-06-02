package pe.edu.upn.semana11.prueba;

import pe.edu.upn.semana11.impl.MateImpl;
import pe.edu.upn.semana11.spec.MateSpec;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        MateSpec bean = new MateImpl();
        System.out.println("Factorial de 7 es: " + bean.factorial(7));
        
        
    }
    
}
