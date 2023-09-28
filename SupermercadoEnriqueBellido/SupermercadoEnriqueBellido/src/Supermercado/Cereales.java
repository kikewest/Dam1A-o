package Supermercado;

import java.time.LocalDate;

public class Cereales implements EsAlimento {
	
	private String Marca;
	private double Precio;
	private String TipoCereal;
	private LocalDate Caducidad;
	
	
	public Cereales(String marca, double precio, String tipoCereal) {
		this.Marca = marca;
		this.Precio = precio;
		this.TipoCereal = tipoCereal;
	}

	
	
	public String getMarca() {
		return Marca;
	}



	public void setMarca(String marca) {
		Marca = marca;
	}



	public double getPrecio() {
		return Precio;
	}



	public void setPrecio(double precio) {
		Precio = precio;
	}



	public String getTipoCereal() {
		return TipoCereal;
	}



	public void setTipoCereal(String tipoCereal) {
		TipoCereal = tipoCereal;
	}



	@Override
	public void setCaducidad(LocalDate fc) {
		this.Caducidad=fc;
		
	}

	@Override
	public LocalDate getCaducidad() {
		
		return this.Caducidad;
	}

	@Override
	public int getCalorias() {
		if (this.TipoCereal.equals("espelta")) {
			return 5;
		}else if (this.TipoCereal.equals("maiz")) {
			return 8;
		}else if (this.TipoCereal.equals("trigo")) {
			return 12;
		}else {
			return 15;
		}
	}



	@Override
	public String toString() {
		return "Cereales--> Marca= " + Marca + "| Precio= " + Precio +
				"| TipoCereal= " + TipoCereal + "| Caducidad= "+ Caducidad +
				"| Calorias= " + this.getCalorias() + " |";
	}
	
	
	
}
