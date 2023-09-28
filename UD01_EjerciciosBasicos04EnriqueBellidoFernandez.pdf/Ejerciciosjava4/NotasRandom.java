package Ejerciciosjava4;
import java.util.Scanner;
public class NotasRandom {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		int n, suspenso=0, suficiente=0, bien=0, notable=0, sobresaliente=0;
		System.out.print("Las notas son: ");
		for ( int i=1 ; i<=20 ; i++ ) {
			n = (int)(Math.random()*10)+1;
			System.out.print(n + " ");
			if ( n>=0 & n <=4.9 ) {
				suspenso++;
			}else if( n==5 ) {
				suficiente++;
			}else if ( n>5 & n<=6.9 ) {
				bien++;
			}else if ( n>=7 & n<=8.9 ) {
				notable++;
			}else if ( n>=9 & n<=10 ) {
				sobresaliente++;
			}
		}
		System.out.println("");
		System.out.println("Hay " + suspenso + " suspenso.");
		System.out.println("Hay " + suficiente + " suficientes.");
		System.out.println("Hay " + bien + " bien.");
		System.out.println("Hay " + notable + " notables.");
		System.out.println("Hay " + sobresaliente + " sobresalientes.");
	}
}