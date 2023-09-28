package Supermercado;
import java.time.LocalDate;
import java.util.ArrayList;
import Supermercado.*;
public class MainSupermercado {

	public static void main(String[] args) {
		Detergente det1= new Detergente ("Don Limpio",1.60);
		det1.setVolumen(2000);
		det1.setDescuento(3);
		det1.setTipoEnvase("Gigante");
		
		System.out.println(det1);
		
		Cereales cer1= new Cereales("Chocapih",2.40,"maiz");
		cer1.setCaducidad(LocalDate.of(2023, 04, 15));
		
		System.out.println(cer1);
		
		Vino vin1= new Vino("Moro","Tinto",40,150);
		vin1.setVolumen(340);
		vin1.setTipoEnvase("Botella de cristal");
		vin1.setCaducidad(LocalDate.of(2024, 04, 14));
		vin1.setDescuento(2);
		
		System.out.println(vin1);
		
		ArrayList<EsAlimento> Lista = new ArrayList<>();
		Lista.add(vin1);
		Lista.add(cer1);
		
		int TotalCalorias=0;
		for (EsAlimento alimento: Lista) {
			TotalCalorias += alimento.getCalorias();
		}
		
		System.out.println("Total Calorias= "+TotalCalorias);
		
	}

}
