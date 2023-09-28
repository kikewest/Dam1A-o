package Ejercicio01;

import java.io.*;

public class Ejercicio01 {

	public static void main(String[] args) throws IOException {
		File miFichero = new File ("archivotxt\\elQuijote.txt");
		if (miFichero.exists()) {
			System.out.println("El fichero existe/es correcto");
			FileReader fr;
			int cont=0;
			int contpalabras=0;
			try {
				fr= new FileReader(miFichero);
				int letra;
				letra=fr.read();
				while (letra!=-1) {
					letra=fr.read();
					cont++;
					if (letra==32 || letra==10) {
						contpalabras++;
					}
					
				}
				fr.close();
				System.out.println("El Quijote tiene "+cont+" caracteres");
				System.out.println("El Quijote tiene "+contpalabras+" palabras");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
	}

}
