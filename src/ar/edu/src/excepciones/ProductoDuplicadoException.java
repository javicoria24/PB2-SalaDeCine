package ar.edu.src.excepciones;

public class ProductoDuplicadoException extends Exception {

	public ProductoDuplicadoException() {
		super("El producto  se encuentra duplicado en la coleccion");
	}
}
