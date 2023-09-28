package Ejerciciosjava4;
import java.util.Scanner;
public class NumeroRandomHasta24 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int n=0,i=0;
		while ( n!=24 ) {
			n = (int)(Math.random()*50 + 1)*2;
			System.out.println(n + " ");
			i++;
		}
		System.out.println("Han salido: " + i + " números.");
	}
}