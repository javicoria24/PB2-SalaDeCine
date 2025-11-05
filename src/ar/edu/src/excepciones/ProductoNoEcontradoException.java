package ar.edu.src.excepciones;

public class ProductoNoEcontradoException extends Exception {
	public ProductoNoEcontradoException(){
		super("El producto no se encuentra en la coleccion");
		}

}
