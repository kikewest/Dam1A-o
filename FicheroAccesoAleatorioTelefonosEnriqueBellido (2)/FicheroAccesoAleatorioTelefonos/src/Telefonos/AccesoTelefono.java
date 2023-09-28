package Telefonos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AccesoTelefono {//clase que lee el archivo
	public static void main(String[] args) {
		String ruta = "archivo\\telefonos.txt";
		File fichero = null;
		FileReader leer = null;
		BufferedReader bufR = null;
		String[] telefonos = null;

		try {
			fichero = new File(ruta);
			leer = new FileReader(fichero);
			bufR = new BufferedReader(leer);
			int cont = 0;
			while (bufR.readLine() != null) {//contamos el numero de lineas que tiene el archivo
				cont++;
			}
			bufR.close();
			telefonos = new String[cont];//array que almacena los telefonos
			leer = new FileReader(fichero);
			bufR = new BufferedReader(leer);
			String linea;
			int i = 0;
			while ((linea = bufR.readLine()) != null) {//se lee el archivo de nuevo para almacenar los teléfonos en el array
				telefonos[i] = linea;
				i++;
			}
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			int opcion = 0;
			while (opcion != 2) {
				System.out.println("******** MENU ********");
				System.out.println("1. Mostrar numero al azar");
				System.out.println("2. Salir");
				System.out.print("Seleccione una opcion: ");
				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					int indice = random.nextInt(cont);
					System.out.println("El numero al azar es: " + telefonos[indice]);
					System.out.println();// Se genera un índice al azar y mostramos el numero 
					break;
				case 2:
					System.out.println("Fin del programa...");
					System.out.println();
					break;
				default:
					System.out.println("Introduzca una opcion valida");
					System.out.println();
					break;
				}
			}
			sc.close();
		}catch(InputMismatchException e) {
			System.out.println("Caracter erroneo");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != bufR) {
					bufR.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
