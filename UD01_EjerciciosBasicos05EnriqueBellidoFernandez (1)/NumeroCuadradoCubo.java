package Ejerciciosjava05;
import java.util.Scanner;
public class NumeroCuadradoCubo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int numero[] = new int[20];
		int cuadrado[] = new int[20];
		int cubo[] = new int[20];
		for ( int i=0 ; i<numero.length ; i++ ) {
			numero[i] = (int)(Math.random()*100)+1;
		}
		for ( int i=0 ; i<cuadrado.length ; i++ ) {
			cuadrado[i] = (numero[i])*(numero[i]);
		}
		for ( int i=0 ; i<cuadrado.length ; i++ ) {
			cubo[i] = (numero[i])*(numero[i])*(numero[i]);
		}
		System.out.print("Numero  ");
		System.out.print("Cuadrado  ");
		System.out.println("Cubo ");
		System.out.println(" ");
		for ( int i=0 ; i<20 ; i++ ) {
			System.out.print("| " + numero[i] + " |");
			System.out.print("| " + cuadrado[i] + " |");
			System.out.println("| " + cubo[i] + " |");
		}
	}
}