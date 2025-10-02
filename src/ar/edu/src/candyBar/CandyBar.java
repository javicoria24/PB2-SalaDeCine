package ar.edu.src.candyBar;

import java.util.ArrayList;
import java.util.List;

public class CandyBar {
	// • List <String> alumnos = new LinkedList();
	//private List<Producto> productos = new ArrayList();

	private Producto[] productos;

	public CandyBar(int cantidadDeProductos) {
		 this.productos = new Producto[cantidadDeProductos];
		//this.productos= new ArrayList<>(cantidadDeProductos);
	}

	public boolean agregarProducto(Producto producto) {
		for (int i = 0; i < this.productos.length; i++) {
			if (this.productos[i] == null) {
				this.productos[i] = producto;
				return true;
			}
		}
		return false;
	}

	public Producto[] obtenerInventario() {

		return this.productos;
	}

	public boolean eliminarProducto(String string) {
		for (int i = 0; i < this.productos.length; i++) {
			if (this.productos[i] != null && this.productos[i].getNombre().equalsIgnoreCase(string)) {
				this.productos[i] = null;
				return true;
			}
		}

		return false;
	}

}
