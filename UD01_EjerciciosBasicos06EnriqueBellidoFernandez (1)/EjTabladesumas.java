package Ejerciciosjava05parte2;
import java.util.*;
public class EjTabladesumas {

	public static void main(String[] args) {
		int[][] datos = new int[5][6];
		int conta=0;
		Scanner leer = new Scanner (System.in);
		for (int i=0;i<4;i++) {
			for (int j=0;j<5;j++) {
				System.out.println("Introduce numero de la columna= "+i+" de la fila= "+j);
				datos[i][j] = leer.nextInt();	
			}
		}
		for (int i=0;i<4;i++) {
			for (int j=0;j<5;j++) {
				conta += datos [i][j];
			}
			datos[i][5] = conta;
			conta=0;
			
			}
		
		for (int j=0;j<6;j++) {
			for (int i=0;i<4;i++) {
				conta += datos [i][j];
			}
			datos[4][j] = conta;
			conta=0;
		
			}
		for (int k=0;k<5;k++) {
			for (int l=0;l<6;l++) {
				System.out.print("|"+datos[k][l]+" ");
			}
			System.out.println("");
		}
	}

}
