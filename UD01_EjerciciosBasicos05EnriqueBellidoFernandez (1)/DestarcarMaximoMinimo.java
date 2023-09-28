package Ejerciciosjava05;
import java.util.Scanner;
public class DestarcarMaximoMinimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		int min=500;
		int max=0;
		int opcion;
		
		int[] numero = new int[100];
		for(i=0; i<100; i++){
			int aleatorio = (int)(Math.random()*501);
			numero[i]=aleatorio;
		}
		for(i=0; i<100; i++){
			if (numero[i]>max) {
				max=numero[i];
			}
		}
		for(i=0; i<100; i++){
			if (numero[i]<min) {
				min=numero[i];
			}
		}
		for(i=0; i<100; i++){
			System.out.print(numero[i]+" ");
		}
		System.out.println(" ");
		Scanner leer = new Scanner(System.in);
		System.out.println("Que numero quieres destacar mayor=1 // menor=2");
		opcion= leer.nextInt();
		if (opcion==1) {
			for(i=0; i<100; i++){
				if(numero[i]==max) {
					System.out.print("'"+numero[i]+"'"+" ");
				}else {
					System.out.print(numero[i]+" ");

				}
			}
		}
		if (opcion==2) {
			for(i=0; i<100; i++){
				if(numero[i]==min) {
					System.out.print("'"+numero[i]+"'"+" ");
				}else {
					System.out.print(numero[i]+" ");

				}
			}
		}
	}

}
