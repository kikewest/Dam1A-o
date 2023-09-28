package EjerciciosFunciones;
import java.util.Scanner;

import Biblioteca.Biblioteca;
public class Binario_A_Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n;
		Scanner leer= new Scanner (System.in);
		System.out.println("Introduzca el numero binario para pasar a decimal:");
		n=leer.next();
			System.out.print("El Numero en decimal es: "+Biblioteca.BinarioaDecimal(n));
		}
	}


