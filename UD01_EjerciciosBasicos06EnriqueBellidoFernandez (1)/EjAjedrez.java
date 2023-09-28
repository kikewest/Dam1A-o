package Ejerciciosjava05parte2;
import java.lang.reflect.Array;
import java.util.*;
public class EjAjedrez {

	public static void main(String[] args) {
		int[][] datos=new int[8][8];
		int posx;
		int posy = 0;
		Scanner sc = new Scanner(System.in);
		String columna="";
		System.out.println("Posicion de la fila 1-8: ");
		posx=sc.nextInt();
		System.out.println("Posicion de la columna de la a-h: ");
		columna=sc.next();
			
		switch (columna) {
		case "a": {
			posy =0;
			break;
		}
		case "b": {
			posy =1;
			break;
		}
		case "c": {
			posy =2;
			break;
		}
		case "d": {
			posy =3;
			break;
		}
		case "e": {
			posy =4;
			break;
		}
		case "f": {
			posy =5;
			break;
		}
		case "g": {
			posy =6;
			break;
		}
		case "h": {
			posy =7;
			break;
		}
		default:
		{
			System.out.println("El valor introducido no es valido");
		}
		}
		
		for (int i=1;i<=8;i++) {
			for (int j=0;j<8;j++) {
				if ((i+j==(posx+posy)|| (i-j==(posx-posy)))) {
			System.out.println("El alfil puede ir a las posiciones ("+i+")("+j+")");
				}
				
				
		}
	}
}
}