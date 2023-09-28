package Ejercicio02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio02 {

	public static void main(String[] args) throws IOException {
		File miFichero = new File ("archivotxt\\elQuijote.txt");
		if (miFichero.exists()) {
			System.out.println("El fichero existe/es correcto");
			FileReader fr = null;
			BufferedReader br = null;
			int capitulos=0, molinos=0;
			try {
				fr = new FileReader(miFichero);
				br = new BufferedReader(fr);
				String palabra;
				while ( (palabra = br.readLine()) != null ) {
					if ( palabra.startsWith("CAPÍTULO") || palabra.startsWith("Capítulo") ) {
						capitulos++;
					}
					if (palabra.contains(" molinos ")|| palabra.contains(" molino")) {
						molinos++;
					}
				}
				System.out.println("El quijote tiene "+capitulos+" capitulos");
				System.out.println("Molinos en total :"+molinos);
			}catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if ( br != null ) br.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
