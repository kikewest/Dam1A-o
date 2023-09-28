package ArrayListVehiculo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainVehiculo {

	public static void main(String[] args) {
		ArrayList<VEHICULO> vehiculos = new ArrayList<VEHICULO>();
		String[] tipos = {"coche", "camion", "furgoneta", "moto"};
		int coches = 0;
		int camiones = 0;
		int furgonetas = 0;
		int motos = 0;
		
		for (int i = 0; i <500; i++) {
			int nVehiculo = i + 1;
			vehiculos.add(new VEHICULO(nVehiculo,tipos[(int) (Math.random()*tipos.length)]));
			if (vehiculos.get(i).getTipo().equals("coche")) {
				coches++;
			}
			if (vehiculos.get(i).getTipo().equals("camion")) {
				camiones++;
			}
			if (vehiculos.get(i).getTipo().equals("furgoneta")) {
				furgonetas++;
			}
			if (vehiculos.get(i).getTipo().equals("moto")) {
				motos++;
			}
			System.out.println(vehiculos.get(i));
		}
		System.out.println("Coches: " + coches);
		System.out.println("Camiones: " + camiones);
		System.out.println("Furgonetas: " + furgonetas);
		System.out.println("Motos: " + motos);
		//con un for each sera asi
		//for (VEHICULO v:vehiculos) {
		 	//if (v.getTipo().equals("coche")) {
				//coches++;
			//}else if(v.getTipo().equals("camion")){
				//camiones++;
			//}else if (v.getTipo().equals("furgonetas")) {
				//furgonetas++;
			//}else if (v.getTipo().equals("moto")) {
				//motos++;
			//}
		Iterator<VEHICULO> iterador = vehiculos.iterator();
		while (iterador.hasNext()) {
			VEHICULO b=iterador.next();
			if (!b.getTipo().equals("coche")) {
				iterador.remove();
			}
		}
		
		int totalBorrado = camiones+furgonetas+motos;
		int inicio=vehiculos.get(vehiculos.size()-1).getIdVehiculo()+1;
		for (int i=inicio;i<inicio+totalBorrado;i++) {
			vehiculos.add(new VEHICULO(i,"coche"));
			
		coches = 0;
		camiones = 0;
		furgonetas = 0;
		motos = 0;	
		}
		for (int i = 0; i <500; i++) {
			int nVehiculo = i + 1;
			vehiculos.add(new VEHICULO(nVehiculo,tipos[(int) (Math.random()*tipos.length)]));
			if (vehiculos.get(i).getTipo().equals("coche")) {
				coches++;
			}
			if (vehiculos.get(i).getTipo().equals("camion")) {
				camiones++;
			}
			if (vehiculos.get(i).getTipo().equals("furgoneta")) {
				furgonetas++;
			}
			if (vehiculos.get(i).getTipo().equals("moto")) {
				motos++;
			}
			System.out.println(vehiculos.get(i));
		}
		System.out.println("------------------------------------");
		System.out.println("Coches: "+ coches+"\nCamiones: "+camiones+"\nFurgonetas: "+furgonetas+"\nMotos: "+motos);
	}
}

//La diferencia a simple vista del arraylist y el linkedlist no se aprecia, al buscar informacion he encontrado que el linkedlist es mas rapido que el arraylist


