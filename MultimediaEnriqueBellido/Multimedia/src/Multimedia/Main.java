package Multimedia;

public class Main {

	public static void main(String[] args) {
		Listamultimedia lista=new Listamultimedia(10);
		Pelicula p1=new Pelicula("Star Wars", "Lucas Film",Formatos.dvd,120,"Luck Skywalker", null);
		Pelicula p2=new Pelicula("Interestellar", "Dream Works",Formatos.dvd,120,null, "Lucia");
		Pelicula p3=new Pelicula("Fast and Furius", "Holliwood",Formatos.dvd,130,"Vin diesel", "Rebeca");

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		System.out.println(lista.toString());
		
		System.out.println("------------------------------------");
		Disco d1=new Disco("YHLQMDLG", "bad bunny",Formatos.mp3,3,Genero.regeton);
		Disco d2=new Disco("BBO", "HOOKE",Formatos.mp3,3,Genero.rap);
		Disco d3=new Disco("NIÑA", "Jose rey",Formatos.mp3,4,Genero.flamenco);
		
		lista.add(d1);
		lista.add(d2);
		lista.add(d3);
		
		System.out.println(lista.toString());
		System.out.println("");
		
		Disco d4=new Disco(d2.getTitulo(), d2.getAutor(),Formatos.mp3,3,Genero.rock);
		for(int i=0; i<lista.size(); i++) {
			if(d4.equals(lista.obtenerObjeto(i))){
				System.out.println(" El disco con el mismo titutlo y autor es= "+lista.obtenerObjeto(i)+" y su posicion es "+i);
			}
		}
	}
}
