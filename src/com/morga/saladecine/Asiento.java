package com.morga.saladecine;

public class Asiento {

	private String nombreComprador;
	private boolean ocupado;

	public Asiento() {
		this.liberar();

	}

	public Asiento(String nombrecomprador, boolean estado) {
		this.nombreComprador = nombrecomprador;
		this.ocupado = estado;

	}

	public String getNombreComprador() {
		return this.nombreComprador;
	}

	public void ocupar(String nombreComprador) {
		this.nombreComprador = nombreComprador;
		this.ocupado = true;
	}

	public void liberar() {
		this.nombreComprador = " ";
		this.ocupado = false;
	}

	public boolean estaOcupado() {
		return ocupado;
	}
}
