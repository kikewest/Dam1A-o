package EjerciciosFunciones;
import java.util.Scanner;

import Biblioteca.Biblioteca;
public class MostrarPrimos1y1000 {

	public static void main(String[] args) {
		int n;
		for (n=1;n<1000;n++) {
			if (Biblioteca.EsPrimo(n)) {
				System.out.print(n+",");
			}			
		}			
	}
}
