package GestionDeAlmacenes;

public class VENTAS {
	public ARTICULOS articulo;
	public String FechaCompra;
	public int Unidades;
	public int PrecioTotal;
	public boolean ConfirmacionPago;
	
	public VENTAS(ARTICULOS articulo, String fechaCompra, int unidades, int precioTotal, boolean confirmacionPago) {
		this.articulo = articulo;
		FechaCompra = fechaCompra;
		Unidades = unidades;
		PrecioTotal = precioTotal;
		ConfirmacionPago = confirmacionPago;
	}

	public ARTICULOS getArticulo() {
		return articulo;
	}

	public void setArticulo(ARTICULOS articulo) {
		this.articulo = articulo;
	}

	public String getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public int getUnidades() {
		return Unidades;
	}

	public void setUnidades(int unidades) {
		Unidades = unidades;
	}

	public int getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		PrecioTotal = precioTotal;
	}

	public boolean isConfirmacionPago() {
		return ConfirmacionPago;
	}

	public void setConfirmacionPago(boolean confirmacionPago) {
		ConfirmacionPago = confirmacionPago;
	}
	

	@Override
	public String toString() {
		return "VENTAS [articulo=" + articulo + ", FechaCompra=" + FechaCompra + ", Unidades=" + Unidades
				+ ", PrecioTotal=" + PrecioTotal + ", ConfirmacionPago=" + ConfirmacionPago + "]";
	}
	
	
	
}
