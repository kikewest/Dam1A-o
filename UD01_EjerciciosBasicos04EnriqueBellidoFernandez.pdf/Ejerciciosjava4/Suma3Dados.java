package Ejerciciosjava4;
import java.util.Scanner;
public class Suma3Dados {

	public static void main(String[] args) {
		Scanner leer = new Scanner (System.in);
		int i,dado=1,res=0;
		for(i=1;i<4;i++) {
			System.out.println("dado "+i);
			dado=(int)(Math.random()*6+1);
			System.out.println("sacaste un "+dado);
			res=res+dado;
		}
		System.out.println("La suma de las tiradas es: "+res);
	}

}
