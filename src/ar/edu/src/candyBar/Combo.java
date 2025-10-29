package ar.edu.src.candyBar;

public class Combo extends Producto {
	private double descuento;
	private Snack snack;
	private Bebida bebida;

	public Combo(String nombreCombo, Snack snack, Bebida bebida, double descuentoCombo, int stockCombo) {
		super(nombreCombo, (snack.getPrecio() + bebida.getPrecio()), stockCombo);
		this.descuento = descuentoCombo;
		this.snack=snack;
		this.bebida=bebida;
	}

	@Override
	public double calcularPrecioFinal() {
		double descuento = 0d;
		double precioFinal = super.getPrecio();
		if (super.getNombre().equalsIgnoreCase("Combo Deluxe")) {
			descuento = super.getPrecio() * this.descuento;
			precioFinal = super.getPrecio() - descuento;
		}
		return precioFinal;
	}

	

}
