package AccesoaDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Ejercicio02 {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/vehiculos";
	private static final String USUARIO = "ebf";
	private static final String PASSWORD = "ebf";
	
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
	
	public void insertarDatos() {
		Connection conec = conectarBBDD();
		if (conec !=null) {
			try {
				String inserccion = "INSERT INTO `vehiculos`.`vehiculos`"
						+ " VALUES (default,'1276ljv', 'seat', 'leon', 2019, 130, 5, 80, 12, 1, 'carrazo'),"
						+ " (default,'1234ggc', 'ford', 'fiesta', 2012, 90, 5, 70, 8, 1, 'esta bien'),"
						+ " (default,'1276dnb', 'skoda', 'fabia', 2005, 90, 5, 60, 7, 1, 'reliquia'),"
						+ " (default,'44567abc', 'mercedes', 'clase c', 2019, 200, 5, 80, 12, 1, 'clase'),"
						+ " (default,'8521qwe', 'ford', 'focus', 2020, 110, 5, 75, 9, 0, 'bonito'),"
						+ " (default,'3498rty', 'wagen', 'golf', 2017, 180, 5, 67, 14, 1, 'cochazo'),"
						+ " (default,'4582atr', 'seat', 'ibiza', 2015, 110, 5, 60, 7, 1, 'ta bien'),"
						+ " (default,'7852jkl', 'seat', 'altea', 2022, 150, 5, 90, 12, 1, 'familiar'),"
						+ " (default,'9514hgb', 'bmw', 'q7', 2018, 215, 7, 95, 15, 1, 'tanque'),"
						+ " (default,'3564poi', 'peugeot', 302, 2008, 90, 5, 65, 6, 1, 'ta bien');";
					System.out.println(inserccion);
					
					Statement consulta = conec.createStatement();
					
					consulta.executeUpdate(inserccion);
					System.out.println("Datos insertados correctamente");
					consulta.close();
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				cerrarConexion(conec);
			}
		}
	}

	public void consultarTodosRegistros() {
		Connection conec = conectarBBDD();
		if (conec !=null)
			try {
				String consultaSelect = "SELECT * FROM vehiculos;";
				System.out.println(consultaSelect);
				Statement consulta = conec.createStatement();
				if (consulta.execute(consultaSelect)) {
					ResultSet resultSet = consulta.getResultSet();
					while (resultSet.next()) {
						System.out.println(resultSet.getInt("ID_Vehiculo")+
								"\t"+resultSet.getString("Matricula")+
								"\t"+resultSet.getString("Marca")+
								"\t"+resultSet.getString("Modelo")+
								"\t"+resultSet.getInt("Anyo")+
								"\t"+resultSet.getInt("Potencia")+
								"\t"+resultSet.getInt("Plazas")+
								"\t"+resultSet.getDouble("Deposito")+
								"\t"+resultSet.getDouble("Consumo")+
								"\t"+resultSet.getBoolean("L_correcto")+
								"\t"+resultSet.getString("Observaciones"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Error al insertar en la BBDD\n"+e);
			}finally {
				cerrarConexion(conec);
			}
	}

	public void consultarVehiculos2019() {
		Connection conec = conectarBBDD();
		if (conec !=null)
			try {
				String consultaSelect = "SELECT * FROM vehiculos where Anyo = 2019;";
				System.out.println(consultaSelect);
				Statement consulta = conec.createStatement();
				if (consulta.execute(consultaSelect)) {
					ResultSet resultSet = consulta.getResultSet();
					while (resultSet.next()) {
						System.out.println(resultSet.getInt("ID_Vehiculo")+
								"\t"+resultSet.getString("Matricula")+
								"\t"+resultSet.getString("Marca")+
								"\t"+resultSet.getString("Modelo")+
								"\t"+resultSet.getInt("Anyo")+
								"\t"+resultSet.getInt("Potencia")+
								"\t"+resultSet.getInt("Plazas")+
								"\t"+resultSet.getDouble("Deposito")+
								"\t"+resultSet.getDouble("Consumo")+
								"\t"+resultSet.getBoolean("L_correcto")+
								"\t"+resultSet.getString("Observaciones"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Error al insertar en la BBDD\n"+e);
			}finally {
				cerrarConexion(conec);
			}
	}

	public void eliminarRegistros() {
		Connection conec = conectarBBDD();
		if (conec !=null) {
			try {
				String inserccion = "delete from vehiculos where marca='ford'";
					System.out.println(inserccion);
					
					Statement consulta = conec.createStatement();
					
					consulta.executeUpdate(inserccion);
					System.out.println("Datos Eliminados correctamente");
					consulta.close();
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				cerrarConexion(conec);
			}
		}
	}
}
