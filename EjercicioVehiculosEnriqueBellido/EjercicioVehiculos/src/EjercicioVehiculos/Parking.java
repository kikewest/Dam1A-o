package EjercicioVehiculos;

import java.util.Arrays;

public class Parking {
	private String nombre;
	private int capacidad;
	private int[] horasApertura = {6, 12, 18, 24};
	private int plazasOcupadas = 0;

	// Constructor por defecto
	public Parking() {}

	// Constructor que recibe todos los atributos
	public Parking(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	// Método que indica si hay plazas libres
	public boolean libre() {
		return plazasOcupadas < capacidad;
	}

	// Método que muestra el número de plazas libres
	public int disponibles() {
		return capacidad - plazasOcupadas;
	}

	// Método para aumentar el número de plazas ocupadas
	public void ocuparPlaza() {
		plazasOcupadas++;
		System.out.println("Se ha ocupado una plaza, quedan= "+(this.capacidad-this.plazasOcupadas)+" plazas libres");
	}

	// Método para liberar una plaza
	public void liberarPlaza() {
		plazasOcupadas--;
	}

	@Override
	public String toString() {
		return "Parking [nombre=" + nombre + ", capacidad=" + capacidad + ", horasApertura="
				+ Arrays.toString(horasApertura) + ", plazasOcupadas=" + plazasOcupadas + "]";
	}
	

}
