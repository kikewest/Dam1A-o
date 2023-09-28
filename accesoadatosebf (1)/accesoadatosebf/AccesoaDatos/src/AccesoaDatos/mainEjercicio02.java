package AccesoaDatos;

public class mainEjercicio02 {

	public static void main(String[] args) {
		Ejercicio02 ejercicio = new Ejercicio02();
		ejercicio.conectarBBDD();
		ejercicio.insertarDatos();
		ejercicio.consultarTodosRegistros();
		ejercicio.consultarVehiculos2019();
		ejercicio.eliminarRegistros();
		ejercicio.consultarTodosRegistros();

	}

}
