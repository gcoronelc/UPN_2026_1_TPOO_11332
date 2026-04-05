package pe.edu.upn.promedioapp.controller;

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
public class NotaController {
	
	private NotaService notaService;

	public NotaController() {
		notaService = new NotaService();
	}
	
	public double calcPromedio(double nota1, double nota2, double nota3) throws Exception {
		return notaService.calcPromedio(nota1, nota2, nota3);
	}
	
	public String obtenerCondicion(double promedio) throws Exception {
		return notaService.obtenerCondicion(promedio);
	}

}
