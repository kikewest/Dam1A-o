package JERARQUIA;

public class OPERARIO extends EMPLEADO {
	public String toString() {
    	String cadena=super.toString();
    	cadena+="--> Operario";
    	return cadena;
    }
	public OPERARIO(String nombre) {
		super(nombre);
	}
}
