package Programacionjava1;

import java.util.Scanner;
public class Ejercicio3ebf {

	public static void main(String[] args) {
		int año;
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese año esta: ");
		año=leer.nextInt();
		if ((año % 4 == 0) & ((año % 100 != 0) | (año % 400 == 0)))
			System.out.println("El año es bisiesto");
		else
			System.out.println("El año no es bisiesto");

	}

}
