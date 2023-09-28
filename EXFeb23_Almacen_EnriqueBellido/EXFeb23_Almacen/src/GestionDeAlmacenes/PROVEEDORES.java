package GestionDeAlmacenes;

public class PROVEEDORES {
		private int codigo;
	    private String nombre;
	    private String direccion;
	    private String fechaAlta;
	    private int telefono;
	    private String correo;

	    public PROVEEDORES(int codigo, String nombre, String direccion, String fechaAlta, int telefono, String correo) {
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.direccion = direccion;
	        this.fechaAlta = fechaAlta;
	        this.telefono = telefono;
	        this.correo = correo;
	    }

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(String fechaAlta) {
			this.fechaAlta = fechaAlta;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		@Override
		public String toString() {
			return "PROVEEDORES [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaAlta="
					+ fechaAlta + ", telefono=" + telefono + ", correo=" + correo + "]";
		}
	    
	    
}
