package Ejerciciosjava05parte2;
import java.util.*;
public class EjMaximoyMinimoArraySinRepetir {

	public static void main(String[] args) {
		int[][] datos = new int[6][10];
		Random r = new Random();
		int maximo=0;
		int minimo=1000;
		for (int i=0;i<6;i++) {
			for (int j=0;j<10;j++) {			
				datos[i][j] = r.nextInt(1001);
				System.out.print(datos[i][j]+" ");
			}
			System.out.println("");
		}
		
		for (int i=0;i<6;i++) {
			for (int j=0;j<10;j++) {			
			if (maximo==maximo) {
				maximo = r.nextInt(1001);
			}
			if (minimo==minimo) {
				minimo = r.nextInt(1001);
			}
			}
		}
		
		for (int i=0;i<6;i++) {
			for (int j=0;j<10;j++) {
				if (datos[i][j]>maximo) {
					maximo = datos[i][j];
				}
			}
			}
		System.out.println("");
		System.out.println("El numero maximo es: "+ maximo);
		
		for (int i=0;i<6;i++) {
			for (int j=0;j<10;j++) {
				if (datos[i][j]<minimo) {
					minimo = datos[i][j];
				}
			}
			}
		System.out.println("");
		System.out.println("El numero minimo es: "+ minimo);
	
		System.out.println("");
		
		for (int i=0;i<6;i++) {
			for (int j=0;j<10;j++) {
				if (datos[i][j]==maximo || datos[i][j]==minimo) {	
					
					System.out.print("*"+datos[i][j]+"*"+"");
					
				}else {
					System.out.print(""+datos[i][j]+"  ");
				}
			}
			System.out.println(" ");
			}
		
		
		
	}

}
