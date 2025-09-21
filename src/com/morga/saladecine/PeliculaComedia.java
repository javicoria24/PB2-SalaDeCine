package com.morga.saladecine;

public class PeliculaComedia extends Pelicula {

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis= "sinopsis de pelicula de comedia" + "\n";
		sinopsis+= "Titulo: " + super.getTitulo() +"\n" ;
		sinopsis+= "Duracion" + super.getDuracion() +"\n" ;
		sinopsis+= "Edad minima" + super.getEdadMinima() +"\n" ;
		sinopsis+= "Las peliculas de comedia se caracterizan por tener un alto grado de gracia explosiva";
		return sinopsis;
	}

}
