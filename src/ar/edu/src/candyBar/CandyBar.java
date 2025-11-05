package ar.edu.src.candyBar;

import ar.edu.src.excepciones.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.src.excepciones.ProductoDuplicadoException;
import ar.edu.src.excepciones.ProductoNoEcontradoException;

public class CandyBar {

	private Set<Producto> productos;

	public CandyBar() {

		this.productos = new TreeSet<>();
	}

	/*
	 * public boolean agregarProducto(Producto producto) throws
	 * ProductoDuplicadoException {
	 *  boolean seAgrego = true;
	 *   if
	 * (!this.productos.add(producto)) { seAgrego = false; throw new
	 * ProductoDuplicadoException(); }
	 * 
	 * return seAgrego;
	 */

	public boolean agregarProducto(Producto producto) throws ProductoDuplicadoException {
		boolean seAgrego = true;
		if (!this.productos.add(producto)) {
			seAgrego = false;

		}
		if (!seAgrego) {
			throw new ProductoDuplicadoException();
		}

		return seAgrego;
	}

	public Set<Producto> obtenerInventario() {

		return this.productos;
	}

	public boolean eliminarProducto(Producto producto) throws ProductoNoEcontradoException {
		boolean seBorro = false;
		for (int i = 0; i < this.productos.size(); i++) {
			if (this.productos.contains(producto)) {
				this.productos.remove(producto);
				seBorro = true;
				break; // Salimos del ciclo ya que encontramos el producto
			}
		}
		if (!seBorro) {
			throw new ProductoNoEcontradoException();
		}
		return seBorro;
	}

	public Set<Producto> obtenerBebidasOrdenadas() {
		Set<Producto> bebidas = new TreeSet<>(new OrdenAscendenteDeBebidaPorPrecioBase());
		for (Producto p : this.productos) {
			if (p instanceof Bebida) {
				bebidas.add(p);
			}
		}

		return bebidas;
	}

	public Set<Producto> obtenerSnackOrdenado() {
		Set<Producto> snacks = new TreeSet<>(new OrdenarSnackPorNombre());
		for (Producto p : this.productos) {
			if (p instanceof Snack) {
				snacks.add(p);
			}
		}
		return snacks;
	}

}
