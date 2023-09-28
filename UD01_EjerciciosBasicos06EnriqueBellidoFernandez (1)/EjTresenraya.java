package Ejerciciosjava05parte2;
import java.lang.reflect.Array;
import java.util.*;
public class EjTresenraya {

	public static void main(String[] args) {
		String[] tablero = {"_","_","_","_","_","_","_","_","_"};
		String ficha="";
		int tirada=0;
		boolean alguienGano =false;
		Scanner sc = new Scanner(System.in);
		System.out.println(tablero[0]+" | "+tablero[1]+" | "+tablero[2]);
		System.out.println(tablero[3]+" | "+tablero[4]+" | "+tablero[5]);
		System.out.println(tablero[6]+" | "+tablero[7]+" | "+tablero[8]);
		System.out.println("");
		do {
			tirada++;
			if (tirada%2==0) {
				ficha="X";
			}else {
				ficha="O";
			}
			System.out.println("Donde quieres mover, jugador "+ ficha);
			int posi=sc.nextInt();	
			tablero[posi]= ficha;
			
			
			System.out.println(tablero[0]+" | "+tablero[1]+" | "+tablero[2]);
			System.out.println(tablero[3]+" | "+tablero[4]+" | "+tablero[5]);
			System.out.println(tablero[6]+" | "+tablero[7]+" | "+tablero[8]);
			
		if (tablero[0].equals(tablero[1]) && tablero[0].equals (tablero[2]) && !tablero[0].equals("_")){
			alguienGano = true;
				 } else if(tablero[3].equals (tablero[4]) && tablero[3].equals(tablero[5]) && !tablero[3].equals("_")){
					 alguienGano = true;
			     }else if(tablero[6].equals(tablero[7]) && tablero[6].equals(tablero[8]) && !tablero[6].equals("_")){
			    	 alguienGano = true;
			     }else if(tablero[0].equals (tablero[3]) && tablero[0].equals(tablero[6]) && !tablero[0].equals("_")){
			    	 alguienGano = true;
			     }else if(tablero[1].equals (tablero[4]) && tablero[1].equals (tablero[7]) && !tablero[1].equals("_")){
			    	 alguienGano = true;
			     }else if(tablero[2].equals (tablero[5]) && tablero[2].equals (tablero[8]) && !tablero[2].equals("_")){
			    	 alguienGano = true;
			     } else if(tablero[0].equals (tablero[4]) && tablero[0].equals (tablero[8]) && !tablero[0].equals("_")){
			    	 alguienGano = true;
			     }else if(tablero[2].equals (tablero[4]) && tablero[0].equals (tablero[6]) && !tablero[2].equals("_")){
			    	 alguienGano = true;
			     }
		
		
			     } while (!alguienGano);
		
		if (alguienGano = true) {
			System.out.println("Enhorabuena jugador, "+ ficha);
		}
		}
	
			}
		
	
