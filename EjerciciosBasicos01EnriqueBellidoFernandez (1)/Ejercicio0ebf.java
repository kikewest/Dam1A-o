package Programacionjava1;

import java.util.Scanner;

public class Ejercicio0ebf {

	public static void main(String[] args) {
	
			float peso, altura, imc;
			try (Scanner leer = new Scanner (System.in)) {
				{
				System.out.println("Introduce tu peso");
				peso = leer.nextFloat();
				System.out.println("Introduce tu altura");
				altura = leer.nextFloat();
				imc = peso/(altura*altura);
				}
			}
			System.out.println("su peso es: "+ peso + " y su altura es: "+ altura +" y su incide de masa corporal es: "+ imc);
			if (imc<16) {
				System.out.println("Usted tiene Delgadez Severa");
			}else if (imc>=16 & imc<=17){
				System.out.println("Usted tiene Delgadez Moderada");
			}else if (imc>=17 & imc<=18.5){
				System.out.println("Usted tiene Delgadez Leve");
			}else if (imc>=18.5 & imc<=25){
				System.out.println("Usted tiene Peso Normal");
			}else if (imc>=25 & imc<=30){
				System.out.println("Usted tiene Sobrepeso");
			}else if (imc>=30 & imc<=35){
				System.out.println("Usted tiene Obesidad leve");
			}else if (imc>=35 & imc<=40){
				System.out.println("Usted tiene Obesidad moderada");
			}else if (imc>40){
				System.out.println("Usted tiene Obesidad morbida");
			}
			
			
			
			
	}

}

//ejercicio: Hacer un programa que calcule las raizes de una ecuacion de 2º grado
//ejercicio: un programa que dado un numero de un mes presente el nombre del mes y la cantidad de dias que tiene
//ejercicio: determinar si un año es bisiesto o no
//ejercicio: escribir un programa que dado un numero n calcule la siguiente serie 1+1/2+1/3+1/4... hasta 1/n
//ejercicio: escribir un programa que calcule los primeros n numeros de la suseccion de fibonatcci
//ejercicio: determinar si un numero es un numero de anstorm -> si 371-3^3+7^3+1^3=371
//ejercicio: determinar si un numero es un numero perfecto -> 28-> divisores->1,2,4,7,14-> su suma es 28 es perfecto