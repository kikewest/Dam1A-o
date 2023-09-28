package Accesoadatos;

import java.sql.*;

public class Conexion {
	    private static final String URL = "jdbc:mysql://localhost:3306/rentacar";
	    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "root";

	    private Connection connection;
	    
	    public Conexion() throws ClassNotFoundException {
	        try {
	        	Class.forName(DRIVER);
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            System.out.println("Conexión exitosa a la base de datos RentACar.");
	        } catch (SQLException e) {
	            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
	        }
	    }
	    public Connection getConnection() {
	        return connection;
	    }
	    public void cerrarConexion() {
	        try {
	            if (connection != null && !connection.isClosed()) {
	                connection.close();
	                System.out.println("Conexión cerrada correctamente.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar la conexión: " + e.getMessage());
	        }
	    }
	}

