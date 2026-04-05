package pe.edu.upn.work.prueba;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class Prueba05 {
	
	public static void main(String[] args) {

		
		// Datos
		int a = 10;
		int b = 6;
		
		// Principio: Fail Fast
		if(b==0){
			System.err.println("[ERROR] No es posible dividir entre cero.");
			return;
		}
		
		// Proceso
		double c = a / b;
		
		// Reporte
		System.out.println("c=" + c);
		
		
	}

}
