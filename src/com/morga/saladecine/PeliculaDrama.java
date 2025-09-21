package com.morga.saladecine;

public class PeliculaDrama extends Pelicula {

	public PeliculaDrama(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis= "sinopsis de pelicula de Drama" + "\n";
		sinopsis+= "Titulo: " + super.getTitulo() +"\n" ;
		sinopsis+= "Duracion" + super.getDuracion() +"\n" ;
		sinopsis+= "Edad minima" + super.getEdadMinima() +"\n" ;
		sinopsis+= "Las peliculas de drama se caracterizan por tener historias reales dramaticas";
		return sinopsis;
	}

}
