package Programacionjava1;

import java.util.Scanner;
public class Ejercicio5ebf {
	public static void main(String[] args) {
		int n,a,b = 1,c = 0,i;
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese el numero maximo de la cadena: ");
		n=leer.nextInt();
		for(i=1;i<(n+1);i++) {
			a=b+c;//la suma se hace en todo los bucles
			b=c;//el primer numero pasa a ser el segundo
			c=a;//el segundo numero pasa a ser el resultado de la suma
			System.out.print(a+",");//para escribir en la misma linea println se le quita ln
		}
		
	}
}
