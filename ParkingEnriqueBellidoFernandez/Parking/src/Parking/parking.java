package Parking;
import java.util.ArrayList;
public class parking {
	//atributos
	protected ArrayList<String> matriculas;
	protected String nombre;
	//constructor
	public parking(String nombre, int tamanio) {
		this.nombre = nombre;
		this.matriculas= new ArrayList<>();
		for (int i=0;i<tamanio;i++) {
			this.matriculas.add(null);
		}
	}
	//metodos
	public String getNombre() {
		return this.nombre;
	}
	public void entrada(String matricula, int plaza) throws ParkingException{
		if (plaza>matriculas.size() || plaza<0) {
			throw new ParkingException ("Plaza Incorrecta ",matricula);
		}
		if (matricula.length()<4 | matricula==(null)) {
			throw new ParkingException ("Matricula Incorrecta "+matricula,matricula);
		}
		if (plaza<matriculas.size()) {
			if(matriculas.get(plaza)!=null) {
				throw new ParkingException ("Plaza Ocupada ",matricula);
			}
		}
		boolean repetida=false;
		for (String p: matriculas) {
			if (p!=null) {
				if (p.equals(matricula)) {
					repetida=true;
				}
			}
		}
		if (repetida) {
			throw new ParkingException("Matricula Repetida",matricula);
		}
		matriculas.set(plaza, matricula);
	}
	public int salida(String matricula) throws ParkingException{
		int posicion=-1;
		boolean existe=false;
		for (String p: matriculas) {
			if (p!=null) {
				if (matricula.equals(p)) {
					posicion=matriculas.indexOf(p);
					existe = true;
				}	
			}
		}
		if (!existe) {
			throw new ParkingException("La Matricula "+matricula+" no existe",matricula);
		}
		matriculas.set(posicion, null);
		return posicion;
	}
	public int getPlazasTotales() {
		return matriculas.size();
	}
	public int getPlazasOcupadas() {
		int cont=0;
		for (String p: matriculas) {
			if (p!=null) {
				cont++;
			}
		}
		return cont;
	}
	public int getPlazasLibres() {
		int cont=0;
		for (String p: matriculas) {
			if (p==null) {
				cont++;
			}
		}
		return cont;
	}
	public String toString() {
		String cadena= "";
		cadena+="Nombre del parking: "+this.getNombre()+"\n----------------\n";
		for (int i=0;i<this.matriculas.size();i++) {
			if (this.matriculas.get(i)==null) {
				cadena+= "\nPlaza "+i+" : (Vacia)";
			}else {
				cadena+= "\nPlaza "+i+" : "+this.matriculas.get(i);
			}
		}
		return cadena;
	}
}
