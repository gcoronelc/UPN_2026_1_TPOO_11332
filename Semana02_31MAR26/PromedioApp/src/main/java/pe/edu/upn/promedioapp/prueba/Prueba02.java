package pe.edu.upn.promedioapp.prueba;

import pe.edu.upn.promedioapp.service.NotaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class Prueba02 {

	public static void main(String[] args) {
		try {

			// Datos
			double nota1 = 25.50;
			double nota2 = 40.70;
			double nota3 = 36.40;

			// Proceso
			NotaService notaService = new NotaService();
			double promedio = notaService.calcPromedio(nota1, nota2, nota3);
			String condicion = notaService.obtenerCondicion(promedio);

			// Reporte
			System.out.println("Promedio: " + promedio);
			System.out.println("Condicion: " + condicion);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}

	}
}
