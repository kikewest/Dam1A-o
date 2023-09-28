package Ejerciciosjava05parte2;
import java.util.*;
public class EjTablaSumaAleatorio {

	public static void main(String[] args) {
		int[][] datos = new int[5][6];
		int conta=0;
		Random r = new Random();
		for (int i=0;i<4;i++) {
			for (int j=0;j<5;j++) {
				
				datos[i][j] = r.nextInt(100)+100;	
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
