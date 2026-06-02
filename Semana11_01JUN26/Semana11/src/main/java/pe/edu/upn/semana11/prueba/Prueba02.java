package pe.edu.upn.semana11.prueba;

import pe.edu.upn.semana11.spec.MateSpec;

public class Prueba02 {
    
    public static void main(String[] args) {
        
        MateSpec bean = new MateSpec() {
            @Override
            public long factorial(int n) {
                long f = 1;
                for (int i = 2; i <= n; i++) {
                    f *= i;
                }
                return f;
            }
        };
        
        
        System.out.println("Factorial de 7 es: " + bean.factorial(7));
        
        
    }
    
}
