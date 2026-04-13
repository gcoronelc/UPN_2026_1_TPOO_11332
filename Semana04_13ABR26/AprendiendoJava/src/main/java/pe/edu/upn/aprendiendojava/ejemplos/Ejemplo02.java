package pe.edu.upn.aprendiendojava.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo02 {
    
    public static void main(String[] args) {
        
        
        List<String> lista = new ArrayList();
        
        lista.add("Rojo");
        lista.add("Amarillo");
        lista.add("Verde");
        lista.add("Azul");
        lista.add("Naranja");
        
        System.out.println("Tamanio de la lista: " + lista.size());
        for (String color : lista) {
            System.out.println(color);
        }
        
        
    }
    
    
}
