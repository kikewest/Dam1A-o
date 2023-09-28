package EjerciciosFunciones;
import java.util.Scanner;

import Biblioteca.Biblioteca;
public class Decimal_A_Binario {

	public static void main(String[] args) {
		String n;
		Scanner leer= new Scanner (System.in);
		System.out.println("Introduzca el numero decimal para pasar a binario:");
		n=leer.next();
			System.out.print("El Numero en Binario es: "+Biblioteca.DecimalaBinario(n));
		}
			

	}


