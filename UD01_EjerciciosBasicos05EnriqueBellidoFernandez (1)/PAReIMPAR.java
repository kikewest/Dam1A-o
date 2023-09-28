package Ejerciciosjava05;
import java.util.Scanner;
public class PAReIMPAR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k,num1,num2;
		 Scanner leer = new Scanner(System.in);
		 int[] numero = new int[8];
		 for(i=0; i<8; i++){
	            System.out.println("Introduzca número: ");
	            numero[i] = leer.nextInt();
	        }
		for(i=0; i<8; i++){
			if(numero[i] %2==0) {
				System.out.print(numero[i] + "'PAR'"+" "+" // ");
			}else {
				System.out.print(numero[i] + "'IMPAR'"+" "+" // ");
			}				

		}
	}

}
