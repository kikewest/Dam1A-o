package Parking;

public class ParkingException extends Exception {
	public String mensaje;
	public String matricula;
	
	public ParkingException() {
		super();
	}
	public ParkingException(String mensaje, String matricula) {
		super(mensaje+" --- "+matricula);
		this.mensaje = mensaje;
		this.matricula = matricula;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
