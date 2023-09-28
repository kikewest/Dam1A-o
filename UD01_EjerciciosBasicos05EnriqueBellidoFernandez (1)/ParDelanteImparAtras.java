package Ejerciciosjava05;
import java.util.Scanner;
public class ParDelanteImparAtras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String pares="";
		String impares="";
		Scanner leer = new Scanner(System.in);
		int[] numero = new int[20];
		for(i=0; i<20; i++){
			int aleatorio = (int)(Math.random()*101);
			numero[i]=aleatorio;
		}
		
		for(i=0; i<20; i++){
			if (numero[i]%2==0) {
				pares=pares+ String.valueOf(numero[i]+" ");
			}else {
				impares=impares+ String.valueOf(numero[i]+" ");
			}
		}
		System.out.println("Numeros desordenados");
		for(i=0; i<20; i++){
		System.out.print(numero[i]+" ");	
		}
		System.out.println(" ");
		System.out.println("Numeros ordenados");
		System.out.println(pares +impares);

	}





}


