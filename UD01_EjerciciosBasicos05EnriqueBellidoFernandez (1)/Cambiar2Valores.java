package Ejerciciosjava05;
import java.util.Scanner;
public class Cambiar2Valores {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int num[] = new int[100];
		System.out.println("Los 100 números aleatorios son: ");
		for ( int i=0 ; i<num.length ; i++ ) {
			num[i] = (int)(Math.random()*21);
			System.out.print(" " + num[i]);
		}
		int a, b;
		System.out.println("");
		System.out.print("Introduzca un número: ");
		a = leer.nextInt();
		System.out.print("Introduzca otro número: ");
		b = leer.nextInt();
		for ( int i=0 ; i<num.length ; i++ ) {
			if ( num[i] == a ) {
				System.out.print(" '" + b + "'");
			}else {
				System.out.print(" " + num[i]);
			}
		}
	}
}