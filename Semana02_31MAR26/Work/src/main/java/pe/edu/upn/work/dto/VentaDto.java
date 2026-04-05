package pe.edu.upn.work.dto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class VentaDto {

	// Variables privadas
	
	private double precio;
	private int cantidad;
	private double total;
	
	// Constructor por defecto
	
	public VentaDto() {
		this.precio = 456.78;
		this.cantidad = 7;
		this.total = this.precio * this.cantidad;
	}
	
	// Constructor con parametros

	public VentaDto(double precio, int cantidad) {
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = precio * cantidad;
	}
	
	public VentaDto(double precio, int cantidad, double total) {
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	// Metodos Getters and Setters

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
