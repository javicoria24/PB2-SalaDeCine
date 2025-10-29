package ar.edu.src.candyBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CandyBar {

	private Set<Producto> productos;

	// private Producto[] productos;

	public CandyBar() {
		// this.productos = new Producto[cantidadDeProductos];
		this.productos = new TreeSet<>();
	}

	/*
	 * public boolean agregarProducto(Producto producto) { for (int i = 0; i <
	 * this.productos.length; i++) { if (this.productos[i] == null) {
	 * this.productos[i] = producto; return true; } } return false; }
	 */

	public boolean agregarProducto(Producto producto) {

		return this.productos.add(producto);
	}

	public Set<Producto> obtenerInventario() {

		return this.productos;
	}

	/*
	 * public boolean eliminarProducto(String string) { for (int i = 0; i <
	 * this.productos.length; i++) { if (this.productos[i] != null &&
	 * this.productos[i].getNombre().equalsIgnoreCase(string)) { this.productos[i] =
	 * null; return true; } }
	 * 
	 * return false; }
	 */

	public boolean eliminarProducto(Producto producto) {
		for (int i = 0; i < this.productos.size(); i++) {
			if (this.productos.contains(producto)) {
				this.productos.remove(producto);
				return true;
			}
		}

		return false;
	}

	public Set<Producto> obtenerBebidasOrdenadas() {
		Set<Producto> bebidas = new TreeSet<>(new OrdenAscendenteDeBebidaPorPrecioBase());
		bebidas.addAll(this.productos);
		return bebidas;
	}

	public Set<Producto> obtenerSnackOrdenado() {
		Set<Producto> snacks = new TreeSet<>(new OrdenarSnackPorNombre());
		snacks.addAll(this.productos);
		return snacks;
	}

}
