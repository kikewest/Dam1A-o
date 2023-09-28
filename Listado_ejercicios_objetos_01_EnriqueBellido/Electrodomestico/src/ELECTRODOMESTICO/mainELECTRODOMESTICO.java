package ELECTRODOMESTICO;

public class mainELECTRODOMESTICO {

	public static void main(String[] args) {

		double total=0;
		double totalTV=0;
		double totalLavadora=0;
		ELECTRODOMESTICO[ ] E = new ELECTRODOMESTICO[10];

		E[0]  = new LAVADORA();
		E[1]  = new LAVADORA(100, 40, "Blanca", 'B', 100);
		E[2]  = new LAVADORA(100, 40);
		E[3]  = new TELEVISION();
		E[4]  = new TELEVISION(800, 15, "Gris", 'D', 42, false);
		E[5]  = new TELEVISION(700, 12);
		E[6]  = new ELECTRODOMESTICO();
		E[7]  = new ELECTRODOMESTICO(320, 15, "Negra", 'C');
		E[8]  = new ELECTRODOMESTICO(350, 8);
		E[9]  = new LAVADORA(120, 35, "Verde", 'A', 70);

		for (int i=0; i<10; i++) {
			System.out.println("\n\nElectrodomestico: " + E[i] + " // precio base: " + E[i].getPrecioBase() + " // color: " + E[i].getColor() +" // peso: " + E[i].getPeso()+ " // consumo " + E[i].getConsumo());
			if (E[i].getTipo()=="television") System.out.println("\npulgadas: " + E[i].getPulgadas() + " // TDT: " + E[i].isTdt());
			if (E[i].getTipo()=="lavadora") System.out.println("\ncarga: " + E[i].getCarga());
			E[i].precioFinal();
			System.out.println("\n\nPrecio final: " + E[i].getPrecioBase() + "€.\n\n");
			total=total+E[i].getPrecioBase();
			if (E[i].getTipo()=="television") {
				totalTV=totalTV+E[i].getPrecioBase();
			}
			if (E[i].getTipo()=="lavadora") {
				totalLavadora=totalLavadora+E[i].getPrecioBase();
			}
		}
		System.out.println("Precio total de las televisiones: " + totalTV + "€.");
		System.out.println("Precio total de las lavadoras: " + totalLavadora + "€.");
		System.out.println("Precio total: " + total + "€.");
		
	}

}
