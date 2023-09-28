package Programacionjava1;

import java.util.Scanner;
public class Ejercicio7ebf {

	public static void main(String[] args) {
		int n,i;
		double suma=0;//inicializar variables de operaciones siempre en double 
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese su numero: ");
		n=leer.nextInt();
		for (i=1; i<=(n/2); i++) {
			if (n % i==0) {
				suma=suma+i;
			}
			
			}
		if (suma==n) {
			System.out.println("El numero " +n+ " es perfecto");
		}else
			System.out.println("El numero " +n+ " no es perfecto");	
	}

	}


