package Accesoadatos;

import java.sql.*;
import java.util.Scanner;

public class actualizar {
	public static void main(String[] args) throws ClassNotFoundException {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        if (connection != null) {
            actualizarDatosVehiculos(connection);
            conexion.cerrarConexion();
        }
    }
    public static void actualizarDatosVehiculos(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la matrícula del vehículo a actualizar: ");
        String matricula = scanner.nextLine();
        try {
            // Consultar los datos actuales del vehículo
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM vehiculos WHERE matricula = '" + matricula + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                // Mostrar los datos actuales del vehículo
                String marcaActual = resultSet.getString("marca");
                String modeloActual = resultSet.getString("modelo");
                String combustibleActual = resultSet.getString("combustible");
                System.out.println("Datos actuales del vehículo:");
                System.out.println("Matrícula: " + matricula);
                System.out.println("Marca: " + marcaActual);
                System.out.println("Modelo: " + modeloActual);
                System.out.println("Combustible: " + combustibleActual);

                // Solicitar los nuevos valores para el vehículo
                System.out.print("\nIntroduce la nueva marca del vehículo: ");
                String nuevaMarca = scanner.nextLine();
                System.out.print("Introduce el nuevo modelo del vehículo: ");
                String nuevoModelo = scanner.nextLine();
                System.out.print("Introduce el nuevo combustible del vehículo: ");
                String nuevoCombustible = scanner.nextLine();
                // Actualizar los datos del vehículo en la base de datos
                String updateQuery = "UPDATE vehiculos SET marca = ?, modelo = ?, combustible = ? WHERE matricula = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, nuevaMarca);
                preparedStatement.setString(2, nuevoModelo);
                preparedStatement.setString(3, nuevoCombustible);
                preparedStatement.setString(4, matricula);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("\n¡Los datos del vehículo han sido actualizados exitosamente!");
                    System.out.println("\nNuevos datos del vehículo:");
                    System.out.println("Matrícula: " + matricula);
                    System.out.println("Marca: " + nuevaMarca);
                    System.out.println("Modelo: " + nuevoModelo);
                    System.out.println("Combustible: " + nuevoCombustible);
                } else {
                    System.out.println("\nNo se pudo actualizar los datos del vehículo. Verifica la matrícula.");
                }
                preparedStatement.close();
            } else {
                System.out.println("\nNo se encontró un vehículo con la matrícula proporcionada.");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del vehículo: " + e.getMessage());
        }
        scanner.close();
    }
}
