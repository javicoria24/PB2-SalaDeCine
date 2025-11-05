package ar.edu.src.candyBar;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {

	private String nombre;
	private Double precio;
	private Integer stock;

	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	// @Todo sobre escirbo el compare to y lo ordeno de forma natural ascendente
	/*
	 * si empieza con el objetot de parametro ya parace que seria descendente
	 */
	@Override
	public int compareTo(Producto producto) {

		int comparacionStock = this.stock.compareTo(producto.getStock());
		
		if (comparacionStock > 0) {
			return 1;
		} else if (comparacionStock < 0) {
			return -1;
		}
		return this.nombre.compareTo(producto.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, precio, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);// && stock == other.stock;
	}

	public abstract double calcularPrecioFinal();

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public Integer getStock() {
		return stock;
	}

}
