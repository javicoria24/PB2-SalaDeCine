package com.coria.saladecine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.coria.saladecine.*;

public class SalaCine {

	private Pelicula pelicula;
	private Map<String, Integer> butacas;

	// Adaptar Sala de cine para manejo de butacas dinámicamente. (Utilizar Map con
	// LetrayNumero) (30%)
//	
	public SalaCine() {
		this.butacas = new TreeMap<>();
		this.pelicula = null;
	}

	public String getButacas() {
		String msj="";
		for (Map.Entry<String, Integer> entrada : butacas.entrySet()) {
			msj += " Asiento: " + entrada.getValue()  +"  nombre: " + entrada.getKey()+" \n"  ;
		}
		return msj;
	}

	public int contarAsientosOcupados() {
		int contador = 0;
		for (Map.Entry<String, Integer> entrada : butacas.entrySet()) {
			if (entrada.getValue() != null) {
				contador++;
			}
		}

		return contador;
	}

	public int getTotalAsientos() {
		return this.butacas.size();
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;

	}

	public Pelicula getPeliculaActual() {

		return this.pelicula;
	}

	public boolean venderBoleta(String NombreComprador, Integer asiento, int edad) {
		boolean venta = false;
		if (!this.butacas.containsValue(asiento) && edad > this.pelicula.getEdadMinima()) {
			this.butacas.put(NombreComprador, asiento);
			venta = true;
		}
		return venta;

	}

	public String getTitulo() {

		return this.pelicula.getTitulo();
	}

	public boolean liberarAsiento(int numero, String nombre) {
		boolean libero = false;

		if (this.butacas.containsValue(numero)) {
			this.butacas.remove(nombre);
			libero = true;
		}
		return libero;
	}

	public void reiniciarSala() {

		for (Map.Entry<String, Integer> entrada : butacas.entrySet()) {
			entrada.setValue(null);
		}
	}

}
