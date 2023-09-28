package JERARQUIA;

public class EMPLEADO {
	private String Nombre;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public EMPLEADO(String nombre) {
		this.Nombre=nombre;
	}
	public String toString() {
    	String cadena="";
    	cadena+="Empleado: "+this.getNombre();
    	return cadena;
    }
}
