package EjerciciosFunciones;

import Biblioteca.Biblioteca;

public class MostrarCapicuas1y99999 {

	public static void main(String[] args) {
		int n;
		for (n=1;n<99999;n++) {
			if (Biblioteca.Capicua(n)) {
				System.out.print(n+",");
			}			
		}			
	}
}
