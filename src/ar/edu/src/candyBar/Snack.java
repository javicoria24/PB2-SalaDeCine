package ar.edu.src.candyBar;

public class Snack extends Producto {
	private Tamano tamanio;

	public Snack(String nombre, double precio, Tamano tamanio, int stock) {
		super(nombre, precio, stock);
		this.tamanio = tamanio;

	}

	@Override
	public double calcularPrecioFinal() {
		double precioFinal = 0d;
		double recargo = 0d;

		if (this.tamanio.equals(Tamano.PEQUENIO)) {
			recargo = super.getPrecio() * 0.15;
			precioFinal = super.getPrecio() - recargo;
		}
		if (this.tamanio.equals(Tamano.MEDIANO)) {
			precioFinal = super.getPrecio();
		}
		if (this.tamanio.equals(Tamano.GRANDE)) {
			recargo = super.getPrecio() * 0.20;
			precioFinal = super.getPrecio() + recargo;
		}

		return precioFinal;
	}
	// nack: Representa productos como palomitas de maíz o nachos. El precio final
	// tiene 20% de
	// recargo si es grande y 15% de descuento si es pequeño.

}
