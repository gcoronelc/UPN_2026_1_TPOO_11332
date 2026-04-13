package pe.edu.upn.aprendiendojava.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejemplo01 {
    
    public static void main(String[] args) {
        
        
        List lista = new ArrayList();
        
        lista.add(123);
        lista.add(123.123);
        lista.add("Gustavo");
        lista.add(new Random());
        
        for (Object object : lista) {
            System.out.println(object);
        }
        
        
    }
    
    
}
