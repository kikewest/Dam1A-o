package Ejerciciosjava4;
import java.util.Scanner;
public class Sumadedados {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int a=1, b=0, i=1;
		while ( a!=b ) {
			a = (int)(Math.random()*6);
			b = (int)(Math.random()*6);
			System.out.println("Dado 1.Tirada " + i + ": " + a + " ");
			System.out.println("Dado 2.Tirada " + i + ": " + b + " ");
			i++;
			if ( a==b ) {
				System.out.println("Ambas tiradas son iguales: " + a + " y " + b + ".");
			}
			}
		}
	}