package Ejerciciosjava05;
import java.util.Scanner;
public class TemperaturaMeses {

	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String [] mes= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio","Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		int [] temperatura = new int [12];
		int i,j;
		for (i=0; i< 12 ; i++) {
			System.out.println("Introduzca la temperatura media de: "+mes[i]);
			temperatura[i] = leer.nextInt();
			}
		System.out.println();
		   for (i = 0; i < 12; i++) {
			   System.out.println();
			      System.out.println("|"+mes[i]+"|"+temperatura[i]+"ºC|");
			    
			      for (j = 0; j < temperatura[i]; j++) {
			         
			    	  System.out.print("*");
			      }
			      
		}
		
	}


}
