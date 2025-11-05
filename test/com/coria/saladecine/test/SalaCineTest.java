package com.coria.saladecine.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.coria.saladecine.*;

public class SalaCineTest {

	Pelicula peliculas[] = new Pelicula[10];

	@Before
	public void iniciar() {

		peliculas[0] = new PeliculaAccion("Piratas del caribe 1", 160, 14);
		peliculas[1] = new PeliculaAccion("Mision imposible", 150, 13);
		peliculas[2] = new PeliculaAccion("Jhon wick 4", 169, 16);
		peliculas[3] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
		peliculas[4] = new PeliculaComedia("La Máscara", 120, 7);
		peliculas[5] = new PeliculaComedia("Shrek", 90, 0);
		peliculas[6] = new PeliculaDrama("Forrest Gump", 142, 13);
		peliculas[7] = new PeliculaDrama("El Padrino", 175, 16);
		peliculas[8] = new PeliculaTerror("Scream", 111, 18);
		peliculas[9] = new PeliculaInfantil("Frozen", 102, 0);
	}

	@Test
	public void crearSalaOk() {
		SalaCine sala1 = new SalaCine();
		Pelicula peli = new PeliculaAccion("Piratas del caribe 1", 160, 14);
		sala1.cambiarPelicula(peliculas[0]);

		assertEquals(peli, sala1.getPeliculaActual());

	}

	@Test
	public void venderBoletoExitoso() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		assertTrue(venta);

	}

	@Test
	public void venderBoletoNoExitosoPorqueSeQuiereVenderUnoVendido() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);

		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("juan coria", 0, 16);
		assertTrue(venta);
		assertFalse(venta2);
	}

	@Test
	public void venderBoletoNoExitosoPorqueSeEdadMiniNoCumple() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("jose coria", 1, 16);
		boolean venta3 = sala1.venderBoleta("uriel coria", 2, 5);

		assertTrue(venta);
		assertTrue(venta2);
		assertFalse(venta3);

	}

	@Test
	public void obtenerTotalAscientos() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("jose coria", 1, 16);
		boolean venta3 = sala1.venderBoleta("uriel coria", 2, 16);
		assertEquals(3, sala1.getTotalAsientos());

	}

	@Test
	public void ContarAsientosOcupados() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("jose coria", 1, 16);
		boolean venta3 = sala1.venderBoleta("uriel coria", 2, 16);
		boolean venta4 = sala1.venderBoleta("jo coria", 5, 16);

		assertEquals(4, sala1.contarAsientosOcupados());

	}

	@Test
	public void queSePuedaLiberarLaSala() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("jose coria", 1, 16);
		boolean venta3 = sala1.venderBoleta("uriel coria", 2, 16);
		boolean venta4 = sala1.venderBoleta("jo coria", 5, 16);

		sala1.liberarAsiento(0, "javier coria");
		sala1.liberarAsiento(1, "jose coria");

		assertEquals(2, sala1.contarAsientosOcupados());
	}

	@Test
	public void liberarAsientoVendidoFueraDeRangoTest() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta("javier coria", 0, 16);
		boolean venta2 = sala1.venderBoleta("jose coria", 1, 16);
		boolean venta3 = sala1.venderBoleta("uriel coria", 2, 16);
		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(9, " jiime "));
		assertEquals(3, sala1.contarAsientosOcupados());

	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeAccionYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[0]);
		sala1.getPeliculaActual();
		PeliculaAccion pelicula = new PeliculaAccion("Piratas del caribe 1", 160, 14);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeComediaYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[4]);
		sala1.getPeliculaActual();
		PeliculaComedia pelicula = new PeliculaComedia("La Máscara", 120, 7);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeDramaYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[7]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaDrama("El Padrino", 175, 16);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeTerrorYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[8]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaTerror("Scream", 111, 18);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaInfatilYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[9]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaInfantil("Frozen", 102, 0);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}

	@Test
	public void queSeEntregueElNombreCorrectoDeLaPeliculaActual() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[9]);

		assertEquals("Frozen", sala1.getPeliculaActual().getTitulo());

	}

	@Test
	public void queSePuedaReiniciarLaSalaDeCineCorrectamente() {
		SalaCine sala1 = new SalaCine();
		sala1.cambiarPelicula(peliculas[9]);
		sala1.venderBoleta("javier coria", 0, 16);
		sala1.venderBoleta("jose coria", 1, 16);
		sala1.reiniciarSala();
		assertEquals(0, sala1.contarAsientosOcupados());
	}

}
