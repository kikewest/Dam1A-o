package JERARQUIA;

public class TECNICO extends OPERARIO {
	public TECNICO(String nombre) {
		super(nombre);
		
	}

	public String toString() {
    	String cadena=super.toString();
    	cadena+="--> Oficial";
    	return cadena;
    }
}
