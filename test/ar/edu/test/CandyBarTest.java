package ar.edu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.src.candyBar.*;

public class CandyBarTest {

	private CandyBar candyBar;
	private Snack palomitas;
	private Bebida refresco;
	private Bebida gaseosa;
	private Bebida jugo;
	private Bebida agua;

	// Se ejecuta antes de cada test para inicializar el objeto CandyBar
	@Before
	public void setUp() {
		candyBar = new CandyBar(); // Capacidad para x productos
		palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
		refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
		gaseosa = new Bebida("coca-cola", 5.2, Contenedor.BOTELLA, 25);
		jugo = new Bebida("cepita", 3.5, Contenedor.VASO, 13);
		agua = new Bebida("aguita", 1.5, Contenedor.VASO, 22);

	}

	@Test
	public void testAgregarProductoMasDeUnProductoEnFormaDinamica() {

		assertTrue(candyBar.agregarProducto(palomitas));
		assertEquals(1, contarProductosEnInventario());

		assertTrue(candyBar.agregarProducto(refresco));
		assertEquals(2, contarProductosEnInventario());

		assertTrue(candyBar.agregarProducto(gaseosa));
		assertEquals(3, contarProductosEnInventario());

		assertTrue(candyBar.agregarProducto(jugo));
		assertEquals(4, contarProductosEnInventario());

	}

	@Test
	public void queSePuedaOrdenarNaturalAscendenteLosProductosAgregadosPorStock() {

		candyBar.agregarProducto(gaseosa);

		candyBar.agregarProducto(jugo);

		candyBar.agregarProducto(refresco);
		candyBar.agregarProducto(refresco);

		candyBar.agregarProducto(palomitas);
		candyBar.agregarProducto(palomitas);

		List<Producto> productosAgregados = new ArrayList<>();

		productosAgregados.addAll(candyBar.obtenerInventario());

		assertEquals(palomitas, productosAgregados.get(0));
		assertEquals(jugo, productosAgregados.get(1));
		assertEquals(refresco, productosAgregados.get(2));
		assertEquals(gaseosa, productosAgregados.get(3));
	}

	@Test
	public void queSePuedaDevolverUnaListaDeBebidaOrdenadaAscendentePorPrecio() {
		candyBar.agregarProducto(gaseosa);

		candyBar.agregarProducto(jugo);

		candyBar.agregarProducto(refresco);
		candyBar.agregarProducto(agua);

		List<Producto> bebidas = new ArrayList<>();
		bebidas.addAll(candyBar.obtenerBebidasOrdenadas());

		assertEquals(agua, bebidas.get(0));
		assertEquals(refresco, bebidas.get(1));
		assertEquals(jugo, bebidas.get(2));
		assertEquals(gaseosa, bebidas.get(3));

	}

	@Test
	public void queSePuedaDevolverUnaListaDeSnackOrdenadaPorNombre() {

		Snack gomitas = new Snack("gomitas", 2.5, Tamano.MEDIANO, 10);
		Snack chocolate = new Snack("chocolates", 6.5, Tamano.PEQUENIO, 11);
		Snack caramelo = new Snack("caramelos", 1.5, Tamano.GRANDE, 20);
		Snack alfajor = new Snack("alfajor", 0.5, Tamano.MEDIANO, 110);
		candyBar.agregarProducto(gomitas);

		candyBar.agregarProducto(chocolate);

		candyBar.agregarProducto(alfajor);
		candyBar.agregarProducto(caramelo);

		List<Producto> snacks = new ArrayList<>();
		snacks.addAll(candyBar.obtenerSnackOrdenado());

		assertEquals(alfajor, snacks.get(0));
		assertEquals(caramelo, snacks.get(1));
		assertEquals(chocolate, snacks.get(2));
		assertEquals(gomitas, snacks.get(3));
	}

	@Test
	public void testEliminarProductoExistente() {
		candyBar.agregarProducto(palomitas);
		candyBar.agregarProducto(refresco);

		boolean eliminado = candyBar.eliminarProducto(palomitas);
		assertTrue(eliminado);
		assertEquals(1, contarProductosEnInventario());
		boolean eliminado2 = candyBar.eliminarProducto(palomitas);
		assertFalse(eliminado2);
		assertEquals(0, contarProductosEnInventario());
	}

	@Test
	public void testEliminarProductoNoExistente() {
		candyBar.agregarProducto(palomitas);

		boolean eliminado = candyBar.eliminarProducto(refresco);
		assertFalse(eliminado);
		assertEquals(1, contarProductosEnInventario());
	}

	@Test
	public void testInventarioLleno() {
		// Llenar el inventario hasta su capacidad
		for (int i = 0; i < 5; i++) {
			candyBar.agregarProducto(new Snack("Snack " + i, 1.0, Tamano.MEDIANO, 5));
		}

		// Intentar agregar un sexto producto
		boolean agregado = candyBar.agregarProducto(new Snack("Snack Extra", 1.0, Tamano.MEDIANO, 3));
		assertFalse(agregado);
		assertEquals(5, contarProductosEnInventario());
	}

	private int contarProductosEnInventario() {

		int count = 0;
		for (Producto p : candyBar.obtenerInventario()) {
			if (p != null) {
				count++;
			}
		}
		return count;
	}

}
