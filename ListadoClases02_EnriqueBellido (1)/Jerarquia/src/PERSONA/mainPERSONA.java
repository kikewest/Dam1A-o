package PERSONA;
import java.util.*;

import Fecha.FECHA;
public class mainPERSONA {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PERSONA[] personas= new PERSONA[3];
		String nombre="";
		String direccion="";
		String ciudad="";
		int cp,dia,mes,anio;
		for(int i=0;i<1;i++) {
			System.out.println("Nombre de la persona "+(i+1));
			nombre= sc.nextLine();
			System.out.println("Direccion de la persona "+(i+1));
			direccion= sc.nextLine();
			System.out.println("Ciudad de la persona "+(i+1));
			ciudad= sc.nextLine();
			System.out.println("Codigo Postal de la persona "+(i+1));
			cp= sc.nextInt();
			System.out.println("Indica el DIA Nacimiento de la persona "+(i+1));
			dia= sc.nextInt();
			System.out.println("Indica el MES Nacimiento de la persona "+(i+1));
			mes= sc.nextInt();
			System.out.println("Indica el AÑO Nacimiento de la persona "+(i+1));
			anio= sc.nextInt();
			sc.nextLine();
			personas[i]= new PERSONA(nombre,direccion,ciudad,cp,new FECHA (dia,mes,anio));
		}
		for (int i=0;i<1;i++) {
			System.out.println(personas[i]);
		}
		
	}

}
