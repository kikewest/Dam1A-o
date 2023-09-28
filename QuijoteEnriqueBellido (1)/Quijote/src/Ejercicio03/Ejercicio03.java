package Ejercicio03;

import java.io.*;

public class Ejercicio03 {

	public static void main(String[] args) {
		File miFichero = new File ("archivotxt\\elQuijote.txt");
		if (miFichero.exists()) {
			System.out.println("El fichero existe/es correcto");
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			PrintWriter pw = null;
			int capitulo=1;
			String nombrearchivo=null ; 
			String palabra;
			File archivocopia=null;
			try {
				fr = new FileReader(miFichero);
				br = new BufferedReader(fr);
				while ((palabra = br.readLine()) != null ) {
					if (palabra.startsWith("CAPÍTULO "+capitulo+ ": ") || palabra.startsWith("Capítulo "+capitulo+": ")) {
						if(fw!=null) fw.close();
							nombrearchivo="elQuijote_cap"+capitulo+".txt";
							archivocopia= new File("archivotxt\\",nombrearchivo);
							fw= new FileWriter(archivocopia);
							pw= new PrintWriter(fw);
							capitulo++;
					}
					if (fw!=null && pw!=null) {
						pw.println(palabra);
					}
				
				}
				System.out.println("El Fichero ha sido copiado por capitulos");
			}catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if ( br != null ) {
						br.close(); fr.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
