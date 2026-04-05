package pe.edu.upn.promedioapp.service;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class NotaService {

	public double calcPromedio(double nota1, double nota2, double nota3) throws Exception {
		// Validar
		validar(nota1);
		validar(nota2);
		validar(nota3);
		// Proceso
		double promedio = (nota1 + nota2 + nota3) / 3;
		promedio = Math.round(promedio * 100) / 100.0;
		return promedio;
	}

	public String obtenerCondicion(double promedio) throws Exception {
		// Validar
		validar(promedio);
		// Proceso
		String condicion = "None";
		if (promedio >= 11) {
			condicion = "Aprobado";
		} else if (promedio >= 7) {
			condicion = "Proceso";
		} else {
			condicion = "Desaprobado";
		}
		return condicion;
	}


	private void validar(double nota) throws Exception {
		if (nota < 0.0 || nota > 20.0) {
			throw new Exception("Nota " + nota + " fuera de rango.");
		}
	}


}
