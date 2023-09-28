package JERARQUIA;

public class DIRECTIVO extends EMPLEADO {
	public String toString() {
    	String cadena=super.toString();
    	cadena+="--> Directivo";
    	return cadena;
    }
	public DIRECTIVO(String nombre) {
		super(nombre);
	}
}
