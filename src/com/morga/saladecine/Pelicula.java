package com.morga.saladecine;

public abstract class Pelicula {
	String titulo;
	int duracion;
	int edadMinima;

	public Pelicula(String titulo, int duracion, int edadMinima) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}

	public abstract void mostrarSipnopsis();

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

}
