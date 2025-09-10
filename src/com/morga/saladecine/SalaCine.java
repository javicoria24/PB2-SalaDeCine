package com.morga.saladecine;

public class SalaCine {
	private Asiento[][] butacas;
	private Pelicula pelicula;

	public SalaCine(int fila, int columna) {

		this.butacas = new Asiento[fila][columna];

		for (int i = 0; i < fila; i++) {

			for (int j = 0; j < columna; j++) {
				this.butacas[i][j] = new Asiento();
			}

		}

	}

	public Asiento[][] getButacas() {
		return this.butacas;
	}

	public int contarAsientosOcupados() {
		int contador = 0;

		for (int i = 0; i < butacas.length; i++) {
			for (int j = 0; j < butacas[i].length; j++) {
				if (this.butacas[i][j].estaOcupado())
					contador++;
			}

		}
		return contador;
	}

	public int getTotalAsintos() {
		return butacas.length * butacas[0].length;
	}

}
