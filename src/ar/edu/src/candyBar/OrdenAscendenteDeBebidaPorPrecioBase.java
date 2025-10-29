package ar.edu.src.candyBar;

import java.util.Comparator;

public class OrdenAscendenteDeBebidaPorPrecioBase implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {

		return o1.getPrecio().compareTo(o2.getPrecio());
	}

}
