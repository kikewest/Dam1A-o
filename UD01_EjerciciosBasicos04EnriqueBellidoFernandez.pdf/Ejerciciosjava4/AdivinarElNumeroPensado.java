package Ejerciciosjava4;
import java.util.Scanner;
public class AdivinarElNumeroPensado {

	public static void main(String[] args) {
	int na,ni = 0,i;
	String acierto="";
	na=(int)(Math.random()*100);
	for (i=0;i<5;i++) {
		System.out.println("En que numero estoy pensando?");
		Scanner leer = new Scanner (System.in);
		ni=leer.nextInt();
		acierto.equals(leer);
		if (ni<na) {
			System.out.println("El numero Introducido es mayor y le quedan " +(4-i)+" Intentos");
		}
		if (ni>na) {
			System.out.println("El numero Introducido es menor y le quedan " +(4-i)+" Intentos");
		}
		if (ni==na) {
			System.out.println("El numero Introducido es el correcto, eres una maquina");
			i=6;
		}
		if ((i==4) & (ni!=na)) {
			System.out.println("Lo siento mijo el numero era el: "+na);
	}
		}
}
	}
