package pe.edu.upn.semana03_11332.exception;

public class NotaFueraRangoV1 extends Exception{

    public NotaFueraRangoV1() {
        super("[ERROR] La nota esta fuera de rango.");
    }
    
    public NotaFueraRangoV1(int nota) {
        super("[ERROR] La nota " + nota + " esta fuera de rango.");
    }
    
    public NotaFueraRangoV1(String mensaje) {
        super("[ERROR] " + mensaje);
    }
    
    
}
