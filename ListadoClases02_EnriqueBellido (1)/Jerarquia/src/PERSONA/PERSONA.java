package PERSONA;
import java.util.Date;
import Fecha.FECHA;

public class PERSONA {
	/*atributos*/
	private String Nombre;
    private String Direccion;
    private int CP;
    private String Ciudad;
    private FECHA FN;
    /*Constructores*/
    public PERSONA() {
		this.Nombre="";
		this.Direccion="";
		this.CP=0;
		this.Ciudad="";
		this.FN=FN;
	}
    public PERSONA(String nombre, String direccion,String ciudad,int cp,FECHA fn) {
		this.Nombre=nombre;
		this.Direccion=direccion;
		this.CP=cp;
		this.Ciudad=ciudad;
		this.FN=fn;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public FECHA getFecha() {
		return FN;
	}
	public void setFecha(FECHA fecha) {
		FN = fecha;
	}
	/*Metodos*/
    public boolean EsMayorDeEdad() {
    	boolean correcto=true;
    	FECHA mas18= new FECHA(FN.getDia(),FN.getMes(),FN.getAnio()+18);
    	Date FPC = new Date();
    	FECHA Actual= new FECHA(FPC.getDate(),FPC.getMonth()+1,FPC.getYear()+1900);
    	if(Actual.EsMayorQue(mas18)) {
    		correcto=false;
    		System.out.println("Es Menor de Edad");
    	}else {
    		correcto=true;
    		System.out.println("Es mayor de edad");
    	}
    	return correcto;
    }
    public String toString() {
    	String cadena="";
    	cadena+="Nombre: "+this.getNombre();
    	cadena+="\nFecha Nacimiento: "+this.FN;
    	cadena+="\nCiudad: "+this.getCiudad();
    	cadena+="\nDireccion: "+this.getDireccion();
    	cadena+="\nCodigo Postal : "+this.getCP();
    	return cadena;
    }
    
}
