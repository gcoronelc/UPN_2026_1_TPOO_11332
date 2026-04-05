package pe.edu.upn.work.prueba;

import pe.edu.upn.work.dto.VentaDto;

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
		
		VentaDto bean = new VentaDto();
		
		System.out.println("Precio: " + bean.getPrecio());
		System.out.println("Cantidad: " + bean.getCantidad());
		System.out.println("Total: " + bean.getTotal());
		
	}

}
