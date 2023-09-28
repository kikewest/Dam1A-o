package Ejercicio04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio04 {

	public static void main(String[] args) throws IOException {
		File Mifichero=null;
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		File archivocopia=null;
		String linea;
		//String[] palabramayus;
		String Nombrecopia;
		
		try {
			Mifichero = new File("archivotxt\\elQuijote.txt");
			fr = new FileReader(Mifichero);
			br = new BufferedReader(fr);
			Nombrecopia="copia_elQuijote.txt";
			archivocopia= new File("archivotxt\\"+Nombrecopia);
			fw= new FileWriter(archivocopia);
			pw= new PrintWriter(fw);		
			while ((linea = br.readLine()) != null ) {		
				String[] palabramayus=linea.split(" ");
				for (int i=0; i<palabramayus.length;i++) {
					if (palabramayus[i].equals("hidalgo")|| palabramayus[i].equals("Dulcinea")
							||palabramayus[i].equals("molinos")||palabramayus[i].equals("hidalgos")||palabramayus[i].equals("hidalgo")) {
						palabramayus[i]=palabramayus[i].toUpperCase();
					}
				}
				String Lineacopia=String.join(" ",palabramayus);
				pw.write(Lineacopia);
				pw.write("\n");
						
				}
				if (br!= null) {
					br.close();
					pw.close();
					fr.close();
					fw.close();
				}
			
			
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
