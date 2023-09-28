package GestionDeAlmacenes;

public class ARTICULOS {
	public int CodigoArticulo;
	public String Nombre;
	public String Descripcion;
	public int PrecioVenta;
	public int IVA;
	public PROVEEDORES Proveedor;
	public int UnidadesDisponibles;


	public ARTICULOS(int codigoArticulo, String nombre, String descripcion, int precioVenta, int iVA, PROVEEDORES proveedor,
			int unidadesDisponibles) {
		this.CodigoArticulo = codigoArticulo;
		this.Nombre = nombre;
		this.Descripcion = descripcion;
		this.PrecioVenta = precioVenta;
		this.IVA = iVA;
		this.Proveedor = proveedor;
		this.UnidadesDisponibles = unidadesDisponibles;
	}


	public int getCodigoArticulo() {
		return CodigoArticulo;
	}


	public void setCodigoArticulo(int codigoArticulo) {
		CodigoArticulo = codigoArticulo;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public int getPrecioVenta() {
		return PrecioVenta;
	}


	public void setPrecioVenta(int precioVenta) {
		PrecioVenta = precioVenta;
	}


	public int getIVA() {
		return IVA;
	}


	public void setIVA(int iVA) {
		IVA = iVA;
	}

	public int getUnidadesDisponibles() {
		return UnidadesDisponibles;
	}


	public void setUnidadesDisponibles(int unidadesDisponibles) {
		UnidadesDisponibles = unidadesDisponibles;
	}


	public PROVEEDORES getProveedor() {
		return Proveedor;
	}


	public void setProveedor(PROVEEDORES proveedor) {
		this.Proveedor = proveedor;
	}


	@Override
	public String toString() {
		return "ARTICULOS [CodigoArticulo=" + CodigoArticulo + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion
				+ ", PrecioVenta=" + PrecioVenta + ", IVA=" + IVA + ", Proveedor=" + Proveedor
				+ ", UnidadesDisponibles=" + UnidadesDisponibles + "]";
	}

	
	
	
	
}
