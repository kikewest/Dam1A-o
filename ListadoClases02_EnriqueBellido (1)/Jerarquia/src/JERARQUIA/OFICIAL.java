package JERARQUIA;

public class OFICIAL extends OPERARIO {
	public OFICIAL(String nombre) {
		super(nombre);
		
	}

	public String toString() {
    	String cadena=super.toString();
    	cadena+="--> Oficial";
    	return cadena;
    }
}
