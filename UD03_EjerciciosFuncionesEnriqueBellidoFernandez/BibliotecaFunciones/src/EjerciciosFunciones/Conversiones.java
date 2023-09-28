package EjerciciosFunciones;

import java.util.Scanner;

import Biblioteca.Biblioteca;

public class Conversiones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n,tipo;
		Scanner leer= new Scanner (System.in);
		System.out.println("Que tipo de numeor me va a dar?:");
		tipo=leer.next();
		System.out.println("Introduzca su numero:");
		n=leer.next();
		if (tipo.equals("binario")) {
			System.out.println("El Numero en Decimal es: "+Biblioteca.BinarioaDecimal(n));
			System.out.println("El Numero en hexadecimal es: "+Biblioteca.BinarioaHexadecimal(Biblioteca.BinarioaDecimal(n)));
			System.out.println("El Numero en octal es: "+Biblioteca.BinarioaOctal(Biblioteca.BinarioaDecimal(n)));
		}
		if (tipo.equals("decimal")) {
			System.out.println("El Numero en binario es: "+Biblioteca.DecimalaBinario(n));
			System.out.println("El Numero en hexadecimal es: "+Biblioteca.DecimalaHexadecimal(n));
			System.out.println("El Numero en octal es: "+Biblioteca.DecimalaOctal(n));
		}
		if (tipo.equals("octal")) {
			System.out.println("El Numero en decimal es: "+Biblioteca.OctalaDecimal(n));
			System.out.println("El Numero en hexadecimal es: "+Biblioteca.DecimalaHexadecimal(Biblioteca.OctalaDecimal(n)));
			System.out.println("El Numero en binario es: "+Biblioteca.DecimalaBinario(Biblioteca.OctalaDecimal(n)));
		}
		if (tipo.equals("hexadecimal")) {
			System.out.println("El Numero en decimal es: "+Biblioteca.Hexadecimaladecimal(n));
			System.out.println("El Numero en octal es: "+Biblioteca.DecimalaOctal(Biblioteca.Hexadecimaladecimal(n)));
			System.out.println("El Numero en binario es: "+Biblioteca.DecimalaBinario(Biblioteca.Hexadecimaladecimal(n)));
		}
	
	}
}


