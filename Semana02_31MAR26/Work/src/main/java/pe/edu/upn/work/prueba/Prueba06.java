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
public class Prueba06 {

	public static void main(String[] args) {
		try {

			// Datos
			int a = 10;
			int b = 0;

			// Proceso
			double c = a / b;

			// Reporte
			System.out.println("c=" + c);

		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}

	}

}
