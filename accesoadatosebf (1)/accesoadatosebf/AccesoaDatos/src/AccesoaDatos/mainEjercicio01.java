package AccesoaDatos;

import java.sql.Connection;

public class mainEjercicio01 {

	public static void main(String[] args) {
		Ejercicio01 ejercicio = new Ejercicio01();

        // Conectar a la base de datos
        Connection conexion = ejercicio.conectarBBDD();

        if (conexion != null) {
            // Leer datos desde la base de datos
            ejercicio.leerDatos();

            // Cerrar la conexión
            ejercicio.cerrarConexion(conexion);
        }

	}

}
