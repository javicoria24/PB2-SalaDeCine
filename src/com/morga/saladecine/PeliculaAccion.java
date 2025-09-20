package com.morga.saladecine;

public class PeliculaAccion extends Pelicula {

	public PeliculaAccion(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	public String mostrarSipnopsis() {
		String sinopsis= "sinopsis de pelicula de accion" + "\n";
		sinopsis+= "Titulo: " + super.getTitulo() +"\n" ;
		sinopsis+= "Duracion" + super.getDuracion() +"\n" ;
		sinopsis+= "Edad minima" + super.getEdadMinima() +"\n" ;
		sinopsis+= "Las peliculas de accion se caracterizan por tener un alto grado de violencia explosiva y heroes que salvan el dia";
		return sinopsis;
	}

}
