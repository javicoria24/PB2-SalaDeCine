package ar.edu.src.candyBar;

public class Bebida extends Producto {
	private Contenedor contenedor;

	public Bebida(String nombre, double precio, Contenedor vaso, int stock) {
		super(nombre, precio, stock);
		this.contenedor = vaso;

	}

	@Override
	public double calcularPrecioFinal() {
		double precioFinal = 0d;
		double recargo = 0d;

		if (this.contenedor.equals(Contenedor.BOTELLA)) {
			recargo = super.getPrecio() * 0.10;
			precioFinal = super.getPrecio() + recargo;
		}
		if (this.contenedor.equals(Contenedor.VASO)) {
			precioFinal = super.getPrecio();
		}

		return precioFinal;
	}
	/*
	 * Representa refrescos y jugos. El precio final tiene +10% de recargo en
	 * concepto de envase si su contenedor es una botella.
	 */

}
