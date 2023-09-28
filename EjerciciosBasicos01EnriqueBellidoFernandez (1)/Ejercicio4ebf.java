package Programacionjava1;

import java.util.Scanner;
public class Ejercicio4ebf {

	public static void main(String[] args) {
		double n,i,c = 0;
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese su numero maximo: ");
		n=leer.nextDouble();
			for (i=1;i<n+1;i++) {
			c=c+(1/i);	
			}
			System.out.println(c);

	}

}
