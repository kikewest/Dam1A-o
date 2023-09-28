package Programacionjava1;

import java.util.Scanner;

public class Ejercicio2ebf {
	public static void main(String[] args) {
		int dia;
		String mes="", t="";
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese el numero del mes en el que está: ");
		dia =leer.nextInt();
		switch (dia) {
			case 1:
				mes= "Enero";
				t = "31 dias";
				break;
			case 3:
				mes= "marzo";
				t = "31 dias";
				break;
			case 5:
				mes= "Mayo";
				t = "31 dias";
				break;
			case 7:
				mes= "Julio";
				t = "31 dias";
				break;
			case 8:
				mes= "Agosto";
				t = "31 dias";
				break;
			case 10:
				mes= "Octubre";
				t = "31 dias";
				break;
			case 12:
				mes= "Diciembre";
				t = "31 dias";
				break;
			case 4:
				mes= "Abril";
				t = "30 dias";
				break;
			case 6:
				mes= "Junio";
				t = "30 dias";
				break;
			case 9:
				mes= "Septiembre";
				t = "30 dias";
				break;
			case 11:
				mes= "Noviembre";
				t="30 dias";
				break;
			case 2:
				mes= "Febrero";
				t="28 dias";
				break;
				
		}

		System.out.println("Su mes es: " + mes + " y tiene " + t);
		
	}
}
//mm=31=e1,mar3,may5,jul7,ago8,oct10,dic12