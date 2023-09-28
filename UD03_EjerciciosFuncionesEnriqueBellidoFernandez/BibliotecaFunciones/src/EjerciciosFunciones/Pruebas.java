package EjerciciosFunciones;
import java.util.Scanner;

import Biblioteca.Biblioteca;
public class Pruebas {

	public static void main(String[] args) {
		Scanner leer= new Scanner (System.in);
		int n,b,p,j,z,x,q,w,t,r,y,u,o,a,s;
		System.out.println("Introduzca un numero");
		n=leer.nextInt();
		
		if (Biblioteca.Capicua(n)) {
			System.out.println(n+" Es Capicua");
		}else {
			System.out.println(n+" No es Capicua");
		}
		
		if (Biblioteca.EsPrimo(n)) {
			System.out.println("Es primo");
		}else {
			System.out.println("No es primo");
		}
		
		
		System.out.println(Biblioteca.SigPrimo(n));
		System.out.println("Introduzca la base");
		b=leer.nextInt();
		System.out.println("Introduzca el exponente");
		t=leer.nextInt();
		System.out.println("Su resultado es "+Biblioteca.Potencia(b, t));
		System.out.println("Su numero "+n+ " tiene "+Biblioteca.Digitos(n)+" Digitos");
		System.out.println("Su numero volteado es "+Biblioteca.Voltea(n));
		System.out.println("Introduzca su numero digiton");
		p=leer.nextInt();
		System.out.println("Introduzca la posicion de su numero digiton");
		j=leer.nextInt();
		System.out.println("La posicion "+j+" de su numero "+p+" es:"+Biblioteca.DigitoN(p, j));
		System.out.println("El Numero "+j+" esta en la posicion "+Biblioteca.PosicionDigito(p, j));
		System.out.println("Introduzca un Numero para quitar cifras:");
		z=leer.nextInt();
		System.out.println("Introduzca cuantas cifras quiere quitar por detras:");
		x=leer.nextInt();
		System.out.println("El Numero "+z+" queda sin "+x+" Cifras detras: "+Biblioteca.Quitapordetras(z, x));
		System.out.println("El numero "+z+" Queda sin "+x+" Cifras por delante: "+Biblioteca.Quitapordelante(z, x));
		System.out.println("Introduzca un Numero para añadir cifras por detras:");
		q=leer.nextInt();
		System.out.println("Introduzca cuantas cifras añadir por delante:");
		w=leer.nextInt();
		System.out.println("El Numero "+q+" con el numero "+w+" queda: "+Biblioteca.Pegapordetras(q, w));
		System.out.println("Introduzca un numero para añadir cifras por delante: ");
		t=leer.nextInt();
		System.out.println("Introduzca que cifras añadir por delante:");
		r=leer.nextInt();
		System.out.println("El Numero "+t+" con el numero por delante "+r+" queda: "+Biblioteca.Pegapordelante(t, r));
		System.out.println("Introduzca un numero para sacar el trozodenumero");
		y=leer.nextInt();
		System.out.println("Introduzca la posicion inicial del numero:");
		u=leer.nextInt();
		System.out.println("Introduzca la posicion final del numero:");
		o=leer.nextInt();
		System.out.println("El trozo Correspondiente es: "+Biblioteca.Trozodenumero(y, u, o));
		System.out.println("Introduzca un numero para juntar con otro:");
		s=leer.nextInt();
		System.out.println("Introduzca el segundo numero a juntar:");
		a=leer.nextInt();
		System.out.println("Los numeros "+s+" y "+a+" juntos son: "+Biblioteca.Juntanumeros(s, a));
		
	}

}
