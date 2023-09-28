package ArrayListVehiculo;

public class VEHICULO {
	public int idVehiculo;
	public String tipo;
	
	public VEHICULO(int idVehiculo, String tipo) {
		this.idVehiculo = idVehiculo;
		this.tipo = tipo;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public  String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "VEHICULO [idVehiculo=" + idVehiculo + ", tipo=" + tipo + "]";
	}
	
	
	}
	
	

