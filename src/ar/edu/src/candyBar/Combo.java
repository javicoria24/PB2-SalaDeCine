package ar.edu.src.candyBar;

public class Combo extends Producto {
	private double descuento;

	public Combo(String nombreCombo, Snack snack, Bebida bebida, double descuentoCombo, int stockCombo) {
		super(nombreCombo, (snack.getPrecio() + bebida.getPrecio()), stockCombo);
		this.descuento = descuentoCombo;
	}

	@Override
	public double calcularPrecioFinal() {
		double descuento = 0d;
		double precioFinal = super.getPrecio();
		if (super.getNombre().equalsIgnoreCase("Combo Deluxe")) {
			descuento = super.getPrecio() * 0.20;
			precioFinal = super.getPrecio() - descuento;
		}
		return precioFinal;
	}

}
