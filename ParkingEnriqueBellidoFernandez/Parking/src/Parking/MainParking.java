package Parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainParking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		parking p1= new parking("Erosky", 10);
		int opcion=5;
		int plaza=-1;
		do {
			System.out.println("1)Entrada de coche \n2)Salida de coche \n3)Mostrar parking \n4)Salir del programa");
			System.out.println("\nSeleccione una opcion");
			String opcionaux = sc.next();
			try {
				opcion=Integer.parseInt(opcionaux);
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un valor numerico\n");
				opcion=5;
			} catch (Exception e) {
				System.out.println("error inesperado");
			}

			if (opcion==1) {
				System.out.println("Introduzca su matricula: ");
				String matricula=sc.next();
				System.out.println("Introduzca la plaza: ");
				String plazaaux=sc.next();
				try {
					plaza=Integer.parseInt(plazaaux);
					p1.entrada(matricula, plaza);
				} catch (NumberFormatException e) {
					System.out.println("Introduzca un valor numerico");	
				} catch (ParkingException e) {
					System.out.println(e.getMensaje());
				} catch (Exception e) {
					System.out.println("error inesperado");
				}
				System.out.println("Plazas Totales: "+p1.getPlazasTotales());
				System.out.println("Plazas Ocupadas: "+p1.getPlazasOcupadas()); 
				System.out.println("Plazas Libres: "+p1.getPlazasLibres()+"\n");
			}
			if (opcion==2) {
				System.out.println("Introduzca su matricula: ");
				String matricula=sc.next();
				try {
					p1.salida(matricula);
				} catch (NumberFormatException e) {
					System.out.println("");	
				} catch (ParkingException e) {
					System.out.println(e.getMensaje());
				} catch (Exception e) {
					System.out.println("error inesperado");
				}
				System.out.println("Plazas Totales: "+p1.getPlazasTotales());
				System.out.println("Plazas Ocupadas: "+p1.getPlazasOcupadas()); 
				System.out.println("Plazas Libres: "+p1.getPlazasLibres()+"\n");
			}
			if (opcion==3) {
				System.out.println(p1.toString()); 
				System.out.println();
			}
		}while (opcion!=4);
		sc.close();
	}
}
