package com.morga.saladecine;

public class PeliculaTerror extends Pelicula {

	public PeliculaTerror(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis= "sinopsis de pelicula de accion" + "\n";
		sinopsis+= "Titulo: " + super.getTitulo() +"\n" ;
		sinopsis+= "Duracion" + super.getDuracion() +"\n" ;
		sinopsis+= "Edad minima" + super.getEdadMinima() +"\n" ;
		sinopsis+= "Las peliculas de accion se caracterizan por tener un alto grado de violencia explosiva y heroes que salvan el dia";
		return sinopsis;
	}

}
