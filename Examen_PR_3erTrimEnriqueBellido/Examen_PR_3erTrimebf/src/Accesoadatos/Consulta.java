package Accesoadatos;

import java.sql.*;
import java.sql.Connection;

import com.mysql.cj.xdevapi.Statement;

import java.sql.*;

public class Consulta {
    public static void main(String[] args) {
        Conexion conexion=null;
		try {
			conexion = new Conexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = conexion.getConnection();
        if (connection != null) {
            consultarAlquileresDisponibles(connection);
            conexion.cerrarConexion();
        }
    }

    public static void consultarAlquileresDisponibles(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT c.DNI, c.nombre, c.apellidos, v.matricula, v.marca, v.modelo, a.fecha_alquiler " +
                    "FROM alquileres a " +
                    "INNER JOIN clientes c ON a.DNI_cliente = c.DNI " +
                    "INNER JOIN vehiculos v ON a.matricula_vehiculo = v.matricula";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String dni = resultSet.getString("DNI");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String matricula = resultSet.getString("matricula");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                Date fechaAlquiler = resultSet.getDate("fecha_alquiler");

                System.out.print("DNI, nombre y apellidos: " + dni + ", " + nombre + " " + apellidos);
                System.out.print("-Matrícula, marca y modelo: " + matricula + ", " + marca + " " + modelo);
                System.out.print("-Fecha de alquiler: " + fechaAlquiler);
                System.out.println("");
                System.out.println("");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar los alquileres disponibles: " + e.getMessage());
        }
    }
}
