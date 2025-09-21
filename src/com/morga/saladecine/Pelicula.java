package com.morga.saladecine;

import java.util.Objects;

public abstract class Pelicula {
	private String titulo;
	private int duracion;
	private int edadMinima;

	public Pelicula(String titulo, int duracion, int edadMinima) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}

	public abstract String mostrarSinopsis();

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracion, edadMinima, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return duracion == other.duracion && edadMinima == other.edadMinima && Objects.equals(titulo, other.titulo);
	}

}
