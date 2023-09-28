package AccesoaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/sakila";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";

	public Connection conectarBBDD() {
		Connection conec = null;

		try {
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD, USUARIO, PASSWORD);

		} catch (Exception errores) {
			System.out.println("Se ha producido un error al conectar\n"+ errores);
		}
		return conec;
	}

	public void cerrarConexion (Connection conec) {

		try {
			conec.close();

		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion\n"+e);
		}
	}

	public void leerDatos() {
		Connection conec = conectarBBDD();
		if (conec !=null)
			try {
				String consultaSelect = "SELECT * FROM actor;";
					System.out.println(consultaSelect);
					Statement consulta = conec.createStatement();
					if (consulta.execute(consultaSelect)) {
						ResultSet resultSet = consulta.getResultSet();
						while (resultSet.next()) {
							System.out.println(resultSet.getInt("actor_id")+
									"\t"+resultSet.getString("first_name")+
									"\t"+resultSet.getString("last_name")+
									"\t"+resultSet.getTimestamp("last_update"));
						}
					}
					System.out.println("datos recuperados correctamente");
					consulta.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar en la BBDD\n"+e);
			}finally {
				cerrarConexion(conec);
			}
		
	}
}
