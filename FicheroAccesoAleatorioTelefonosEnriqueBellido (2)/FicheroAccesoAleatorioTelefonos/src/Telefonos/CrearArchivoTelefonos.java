package Telefonos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivoTelefonos { //clase que crea el archivo

	public static void main(String[] args) {
		File fichero = null;	
		FileWriter escribir = null;
		BufferedWriter bufW = null;
		int telefonos;
		int numero;
		
		
		try {
			
			fichero = new File("archivo\\telefonos.txt"); //Crea un archivo llamado "telefonos.txt" en la carpeta "archivo"
			escribir = new FileWriter(fichero); //Crea un objeto FileWriter y lo asigna a la variable "escribir"
			bufW = new BufferedWriter(escribir); //Crea un objeto BufferedWriter y lo asigna a la variable "bufW"
			telefonos = (int)(Math.random()*(31-25)+25); //Genera un número aleatorio entre 25 y 30 y lo asigna a la variable "telefonos"
			for (int i = 0; i < telefonos; i++) { //Bucle for que se ejecuta "telefonos" veces
				numero = (int)(Math.random()*1000000); //Genera un número aleatorio entre 0 y 999999 y lo asigna a la variable "num"
				String telefono = "955-" +  String.format("%06d", numero); //Concatena un prefijo "955-" con "num" con un formato que asegura que tiene 6 dígitos y lo asigna a la variable "telefono"
				bufW.write(telefono); //Escribe el número de teléfono en el archivo
				bufW.newLine(); //Escribe un salto de línea en el archivo
			} 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != fichero) {
					bufW.close();		
				}
			} catch (Exception e2) {		
				e2.printStackTrace();		
			}
		}
	}
}
