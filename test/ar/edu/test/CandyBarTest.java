package ar.edu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.src.candyBar.*;
import ar.edu.src.excepciones.ProductoDuplicadoException;
import ar.edu.src.excepciones.ProductoNoEcontradoException;

public class CandyBarTest {

	private CandyBar candyBar;
	private Snack palomitas;
	private Bebida refresco;
	private Bebida gaseosa;
	private Bebida jugo;
	private Bebida agua;
	private Snack gomitas;

	// Se ejecuta antes de cada test para inicializar el objeto CandyBar
	@Before
	public void setUp() {
		candyBar = new CandyBar(); // Capacidad para x productos
		palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
		refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
		gaseosa = new Bebida("coca-cola", 5.2, Contenedor.BOTELLA, 25);
		jugo = new Bebida("cepita", 3.5, Contenedor.VASO, 13);
		agua = new Bebida("aguita", 1.5, Contenedor.VASO, 22);
		gomitas = new Snack("gomitas", 2.5, Tamano.MEDIANO, 10);

	}

	@Test
	public void testAgregarProductoMasDeUnProductoEnFormaDinamica() throws ProductoDuplicadoException {

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
	public void queSePuedaOrdenarNaturalAscendenteLosProductosAgregadosPorStock() throws ProductoDuplicadoException {

		candyBar.agregarProducto(gaseosa);

		candyBar.agregarProducto(jugo);

		candyBar.agregarProducto(refresco);
		//candyBar.agregarProducto(refresco);

	
		candyBar.agregarProducto(palomitas);

		List<Producto> productosAgregados = new ArrayList<>();

		productosAgregados.addAll(candyBar.obtenerInventario());

		assertEquals(palomitas, productosAgregados.get(0));
		assertEquals(jugo, productosAgregados.get(1));
		assertEquals(refresco, productosAgregados.get(2));
		assertEquals(gaseosa, productosAgregados.get(3));
	}

	@Test
	public void queSePuedaDevolverUnaListaDeBebidaOrdenadaAscendentePorPrecio() throws ProductoDuplicadoException {
		candyBar.agregarProducto(palomitas);
		candyBar.agregarProducto(gaseosa);

		candyBar.agregarProducto(jugo);
		candyBar.agregarProducto(gomitas);

		candyBar.agregarProducto(refresco);
		candyBar.agregarProducto(agua);

		List<Producto> bebida = new ArrayList<>();
		bebida.addAll(candyBar.obtenerBebidasOrdenadas());

		assertEquals(agua, bebida.get(0));
		assertEquals(refresco, bebida.get(1));
		assertEquals(jugo, bebida.get(2));
		assertEquals(gaseosa, bebida.get(3));

	}

	@Test
	public void queSePuedaDevolverUnaListaDeSnackOrdenadaPorNombre() throws ProductoDuplicadoException {

		Snack gomitas = new Snack("gomitas", 2.5, Tamano.MEDIANO, 10);
		Snack chocolate = new Snack("chocolates", 6.5, Tamano.PEQUENIO, 11);
		Snack caramelo = new Snack("caramelos", 1.5, Tamano.GRANDE, 20);
		Snack alfajor = new Snack("alfajor", 0.5, Tamano.MEDIANO, 110);
		candyBar.agregarProducto(gomitas);

		candyBar.agregarProducto(chocolate);
		candyBar.agregarProducto(refresco);
		candyBar.agregarProducto(agua);

		candyBar.agregarProducto(alfajor);
		candyBar.agregarProducto(caramelo);
		candyBar.agregarProducto(jugo);
		

		List<Producto> snacks = new ArrayList<>();
		snacks.addAll(candyBar.obtenerSnackOrdenado());

		assertEquals(alfajor, snacks.get(0));
		assertEquals(caramelo, snacks.get(1));
		assertEquals(chocolate, snacks.get(2));
		assertEquals(gomitas, snacks.get(3));
	}

	@Test
	public void testEliminarProductoExistente() throws ProductoDuplicadoException, ProductoNoEcontradoException {
		candyBar.agregarProducto(palomitas);
		candyBar.agregarProducto(refresco);

		boolean eliminado = candyBar.eliminarProducto(palomitas);
		assertTrue(eliminado);
		assertEquals(1, contarProductosEnInventario());
		boolean eliminado2 = candyBar.eliminarProducto(refresco);
		assertTrue(eliminado2);
		assertEquals(0, contarProductosEnInventario());
	}

	
	@Test(expected = ProductoNoEcontradoException.class)
	public void testEliminarProductoNoExistente() throws ProductoDuplicadoException, ProductoNoEcontradoException {
	    candyBar.agregarProducto(palomitas);
	    
	   assertFalse( candyBar.eliminarProducto(refresco));
	    assertEquals(1, contarProductosEnInventario());
	}
	

	@Test
	public void testInventarioLleno() throws ProductoDuplicadoException {
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
