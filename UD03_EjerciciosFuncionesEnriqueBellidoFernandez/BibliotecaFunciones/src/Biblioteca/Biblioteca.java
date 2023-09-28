package Biblioteca;
import java.util.Scanner;
public class Biblioteca {
	
	public static boolean Capicua (int n) {
		int num, aux, inv=0,cif;
		num=n;
		while (num!=0) {
			cif=num %10;
			inv=inv * 10+cif;
			num=num/10;
		}
		if (n==inv) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean EsPrimo (int n) {
		int i;
		for (i=2;i<n;i++) {
			if (n%i==0) {
				return false;
				
			}
		}
		return true;

	}
	
	public static int SigPrimo (int n) {
		while (!EsPrimo(++n)) {};
		return n;
	}
	
	public static int Potencia (int b,int e) {
		if (b==0) {
			return 1;
		}
		if (b<0) {
			return 1/Potencia(b,-e);
		}
		int n =1;
		for (int i=0;i<Math.abs(e);i++) {
			n=n*b;
		}
		return n;
	}

	public static int Digitos (int n) {
		if (n<0) {
			n=-n;
		}
		if (n==0) {
			return 1;
		}else {
			int x =0;
			while (n>0) {
				n=n/10;
				x++;
			}
			return x;
		}
	}

	public static int Voltea (int n) {
		if (n<0) {
			return -Voltea(-n);
		}
		int volt = 0;
		while (n>0) {
			volt =(volt*10)+(n%10);
			n=n/10;
		}
		return volt;
	}

	public static int DigitoN (int z,int x) {
		int respuesta = 0,i;
		String a=Integer.toString(z);
		char [] array=a.toCharArray();
		for  (i=0;i<array.length;i++){
			if (i==x) {
				respuesta=Character.getNumericValue(array[i]);
			}
		}
		return respuesta;
		
		
	
	}
	
	public static int PosicionDigito (int z,int x) {

		int respuesta = 0,i;
		String a=Integer.toString(z);
		char [] array=a.toCharArray();
		for  (i=0;i<array.length;i++){
			if (Character.getNumericValue(array[i])==x) {
				respuesta=i;
			}
		}
		return respuesta;
	}
	
	public static int Quitapordetras (int z,int x) {
		for (int i=0;i<x;i++) {
			z=z/10;			
		}
		return z;
	}

	public static int Quitapordelante (int z,int x) {
		String num=Integer.toString(z);//para pasar de int a string
		char [] array=num.toCharArray();//para pasar el string a un array de char []
		String numa=new String();
		for (int i=x;i<array.length;i++) {
			numa+=array[i];
		}
		int respuesta=Integer.parseInt(numa);//integer.parseint() pasa el string a int
		return respuesta;
	}

	public static String Pegapordetras (int q,int w) {
		String num=Integer.toString(q);
		String num2=Integer.toString(w);
		num+=num2;
		return num;
		
	}

	public static String Pegapordelante (int t,int r) {
		String num=Integer.toString(t);
		String num2=Integer.toString(r);
		num2+=num;
		return num2;
	}

	public static int Trozodenumero (int y,int u,int o) {
		String num=Integer.toString(y);//para pasar de int a string
		char [] array=num.toCharArray();//para pasar el string a un array de char []
		String numa=new String();
		for (int i=u;i<o;i++) {
			numa+=array[i];
		}
		int respuesta=Integer.parseInt(numa);//integer.parseint() pasa el string a int
		return respuesta;
	}

	public static String Juntanumeros (int s,int a) {
		return Pegapordetras(s,a); 
	}

	public static String DecimalaBinario (String n) {
		int n1=Integer.parseInt(n);
		
		String n2=Integer.toBinaryString(n1);
		return n2;
	}

	public static String BinarioaDecimal (String n) {
		int n1;
		n1=Integer.parseInt(n,2);
		String n2=Integer.toString(n1);
		return n2;
	}

	public static String BinarioaHexadecimal (String n) {
		int n1=Integer.parseInt(n);		
		String n2=Integer.toHexString(n1);
		return n2;
	}

	public static String BinarioaOctal (String n) {
		int n1=Integer.parseInt(n);
		String n2=Integer.toOctalString(n1);
		return n2;
	}

	public static String Hexadecimaladecimal (String n) {
		int n1=Integer.parseInt(n,16);
		String n2=Integer.toString(n1);
		return n2;
	}
	
	public static String DecimalaHexadecimal (String n) {
		int n1=Integer.parseInt(n);
		String n2=Integer.toHexString(n1);
		return n2;
		}
	
	public static String DecimalaOctal (String n) {
		int n1=Integer.parseInt(n);
		String n2=Integer.toOctalString(n1);
		return n2;
		}

	public static String OctalaDecimal (String n) {
		int n1=Integer.parseInt(n,8);
		String n2=Integer.toString(n1);
		return n2;
		}
}

