package Programacionjava1;

import java.util.Scanner;
public class Ejercicio6ebf {
	public static void main(String[] args) {
		int n,cifras=0,i;
		double suma=0;		
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese su numero: ");
		n=leer.nextInt();
		System.out.println("Ingrese el numero de cifras que contiene su numero: ");
		cifras=leer.nextInt();
		int[] valor_cifras=new int[cifras];
		for (i = 0; i<cifras;i++) {
			System.out.println("Ingrese el numero de la cifra "+ (i+1));
			valor_cifras[i]=leer.nextInt();
		}
		for (i=0; i<cifras;i++) {
			suma=suma+Math.pow(valor_cifras[i],cifras);//math.pow para elevar, entre parentesis lo que quieres elevar coma al numero que lo quieres elevar
		}
		if (suma==n) {
			System.out.println("El Numero es armstrong");	
		}	else {
			System.out.println("El Numero no es armstrong");
			}
	}
}
