package Programacionjava1;


import java.util.Scanner;
public class Ejercicio1ebf {

	public static void main(String[] args) {
		double a, b, c, res_pos=0, res_neg=0;
		Scanner leer = new Scanner (System.in);
			System.out.println("Ingrese el numero a");
			a=leer.nextDouble();
			System.out.println("Ingrese el numero b");
			b=leer.nextDouble();
			System.out.println("Ingrese el numero c");
			c=leer.nextDouble();
			res_pos=(-b+ Math.sqrt((b*b)-4*a*c))/(2*a);
			res_neg=(-b- Math.sqrt((b*b)-4*a*c))/(2*a);
			if (a!=0) {
				System.out.println("El resultado es: x = "+res_pos);
				System.out.println("El resultado es: x1 = "+res_neg);
			}
		}

	}

