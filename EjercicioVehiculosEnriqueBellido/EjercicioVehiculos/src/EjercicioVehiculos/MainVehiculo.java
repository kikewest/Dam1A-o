package EjercicioVehiculos;

public class MainVehiculo {

	public static void main(String[] args) {
		Parking p1 = new Parking("Parking 1", 0);
		Parking p2 = new Parking("Parking 2", 50);

		VehiculoCliente v1 = new VehiculoCliente("ABC123");
		VehiculoCliente v2 = new VehiculoCliente("DEF456");
		VehiculoCliente v3 = new VehiculoCliente("GHI789");

		System.out.println("Plazas libres en Parking 1: " + p1.disponibles());
		System.out.println("Plazas libres en Parking 2: " + p2.disponibles());

		v1.setTiempo(1500);
		if (v1.hayPlaza(p1)) {
			v1.aparca(p1);
		} else {
			System.out.println("No hay plazas en Parking 1 para el vehículo 1");
		}

		v2.setTiempo(1200);
		if (v2.hayPlaza(p1)) {
			v2.aparca(p1);
		} else {
			System.out.println("No hay plazas en Parking 1 para el vehículo 2");
		}

		v3.setTiempo(640);
		if (v3.hayPlaza(p2)) {
			v3.aparca(p2);
		} else {
			System.out.println("No hay plazas en Parking 2 para el vehículo 3");
		}

		System.out.println("Plazas libres en Parking 1: " + p1.disponibles());
		System.out.println("Plazas libres en Parking 2: " + p2.disponibles());
		System.out.println(" ");

		System.out.println( v1 + " ->Factura del vehiculo 1: " + v1.factura());
		System.out.println( v2 + " ->Factura del vehiculo 1: " + v2.factura());
		System.out.println( v3 + " ->Factura del vehiculo 1: " + v3.factura());

	}
}






