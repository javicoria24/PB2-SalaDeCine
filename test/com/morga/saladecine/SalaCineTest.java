package com.morga.saladecine;
import com.morga.saladecine.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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
		SalaCine sala1 = new SalaCine(2, 2);
		Pelicula peli = new PeliculaAccion("Piratas del caribe 1", 160, 14);
		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(2, sala1.getButacas().length);
		assertEquals(2, sala1.getButacas()[0].length);

		assertEquals(peli, sala1.getPeliculaActual());

	}

	@Test
	public void venderBoletoExitoso() {
		SalaCine sala1 = new SalaCine(2, 2);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta(0, 1, 16, "javier coria");
		assertTrue(venta);
	}

	@Test
	public void venderBoletoNoExitosoPorqueSeQuiereVenderUnoVendido() {
		SalaCine sala1 = new SalaCine(2, 2);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta(0, 1, 16, "javier coria");
		boolean venta2 = sala1.venderBoleta(0, 1, 17, "javier coria");
		assertTrue(venta);
		assertFalse(venta2);
	}

	@Test
	public void venderBoletoNoExitosoPorqueSeEdadMiniNoCumple() {
		SalaCine sala1 = new SalaCine(3, 3);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta(0, 1, 12, "javier coria");
		boolean venta2 = sala1.venderBoleta(1, 1, 15, "javier coria");
		boolean venta3 = sala1.venderBoleta(0, 2, 5, "javier coria");

		assertFalse(venta);
		assertTrue(venta2);
		assertFalse(venta3);

	}

	@Test
	public void obtenerTotalAscientos() {
		SalaCine sala1 = new SalaCine(2, 3);
		assertEquals(6, sala1.getTotalAsientos());

	}

	@Test
	public void ContarAsientosOcupados() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta = sala1.venderBoleta(0, 1, 19, "javier coria");
		boolean venta2 = sala1.venderBoleta(1, 1, 15, "javier coria");
		boolean venta3 = sala1.venderBoleta(0, 2, 16, "javier coria");
		assertEquals(3, sala1.contarAsientosOcupados());

	}

	@Test
	public void queSePuedaLiberarLaSala() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleta(0, 1, 19, "javier coria");
		sala1.venderBoleta(1, 1, 15, "javier coria");
		sala1.venderBoleta(0, 2, 16, "javier coria");
		assertEquals(3, sala1.contarAsientosOcupados());
		sala1.liberarAsiento(0, 1);
		sala1.liberarAsiento(1, 1);
		sala1.liberarAsiento(0, 2);
		assertEquals(0, sala1.contarAsientosOcupados());
	}

	@Test
	public void liberarAsientoVendidoFueraDeRangoTest() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleta(0, 1, 19, "javier coria");
		sala1.venderBoleta(1, 1, 15, "javier coria");
		sala1.venderBoleta(0, 2, 16, "javier coria");
		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(-2, -1));
		assertEquals(3, sala1.contarAsientosOcupados());

	}

	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeAccionYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[0]);
		sala1.getPeliculaActual();
		PeliculaAccion pelicula = new PeliculaAccion("Piratas del caribe 1", 160, 14);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}
	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeComediaYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[4]);
		sala1.getPeliculaActual();
		PeliculaComedia pelicula = new PeliculaComedia("La Máscara", 120, 7);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}
	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeDramaYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[7]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaDrama("El Padrino", 175, 16);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}
	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaDeTerrorYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[8]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaTerror("Scream", 111, 18);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}
	@Test
	public void queSeCreeUnaSalaDeCineConUnaPeliculaInfatilYSePuedaMostrarSinopsis() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[9]);
		sala1.getPeliculaActual();
		Pelicula pelicula = new PeliculaInfantil("Frozen", 102, 0);
		assertEquals(pelicula, sala1.getPeliculaActual());
		assertNotNull(pelicula.mostrarSinopsis());
	}
	
	@Test
	public void queSeCreeUnAsientoCorrectoYSeEntregueElNombreCorrectoEnSuGet() {
		Asiento asiento1= new Asiento("juan",true);
		assertEquals("juan",asiento1.getNombreComprador());
		
		assertNotNull(asiento1);
	}
	@Test
	public void queSeEntregueElNombreCorrectoDeLaPeliculaActual() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[9]);
		
		assertEquals("Frozen",sala1.getPeliculaActual().getTitulo());
		
	}
	@Test
	public void queSePuedaReiniciarLaSalaDeCineCorrectamente() {
		SalaCine sala1 = new SalaCine(2, 3);
		sala1.cambiarPelicula(peliculas[9]);
		sala1.venderBoleta(0, 1, 19, "javier coria");
		sala1.venderBoleta(1, 1, 19, "javier correa");
		sala1.reiniciarSala();
		assertEquals(0,sala1.contarAsientosOcupados());
	}
	
}
