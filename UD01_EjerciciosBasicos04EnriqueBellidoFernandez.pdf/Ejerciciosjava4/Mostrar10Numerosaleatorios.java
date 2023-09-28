package Ejerciciosjava4;
import java.util.Scanner;
public class Mostrar10Numerosaleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		for (i=0;i<10;i++) {
			
			n=(int)(Math.random()*10);
			System.out.print(""+n+" ");
		}
	}

}
