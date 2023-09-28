package EjercicioVehiculos;

public class VehiculoCliente implements Vehiculo {
	/*atributos*/
	private final String matricula;
	private int tiempo;
	private final double PRECIO_DIA = 25.0;
	private final double PRECIO_HORA = 1.2;

	public VehiculoCliente(String matricula) {
		this.matricula = matricula;
		this.tiempo = 0;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public double factura() {
		int dias = tiempo / 1440; //1440 son los minutos que teiene 1 dia entero
		int horas = (tiempo % 1440) / 60;
		return dias * PRECIO_DIA + horas * PRECIO_HORA;
	}

	public boolean hayPlaza(Parking parking) {
		return parking.libre();
	}

	public void aparca(Parking parking) {
		parking.ocuparPlaza();
	}

	@Override
	public String toString() {
		return "VehiculoCliente [matricula=" + matricula + ", tiempo=" + tiempo + ", PRECIO_DIA=" + PRECIO_DIA
				+ ", PRECIO_HORA=" + PRECIO_HORA + "]";
	}
		
}


