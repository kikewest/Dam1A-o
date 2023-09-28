package Ejerciciosjava4;
import java.util.Scanner;
public class Mostrar50NumerosAleatoriosMediaMaxMin {

	public static void main(String[] args) {
		int n,max=0,min=199,media,suma=0,i;
		for (i=0;i<50;i++) {
			
			n=(int)(Math.random()*100+100);
			System.out.print(""+n+", ");
			if (n>max) {
				max=n;
			}
			if (n<min) {
				min=n;
			}
			suma=suma+n;
		}
		media=suma/50;
		System.out.println(" ");
		System.out.println("El maximo es: "+max);
		System.out.println("El minimo es:  "+min);
		System.out.println("La media es:  "+media);
	}

}
