package Ejerciciosjava05;
import java.util.Scanner;
public class ArrayInversa {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int num[] = new int[10];
		for ( int i=0 ; i<num.length ; i++ ) {
			System.out.print("Introduzca el elemento [" + i + "] del vector: ");
			num[i] = leer.nextInt();
		}
		System.out.println("\nEl orden inverso de dichos números es: ");
		for ( int i=9 ; i>=0 ; i-- ) {
			System.out.println(" " + num[i]);
		}
	}
}