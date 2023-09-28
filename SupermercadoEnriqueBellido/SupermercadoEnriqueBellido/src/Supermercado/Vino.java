package Supermercado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vino implements EsLiquido, EsAlimento, ConDescuento {
	private String Marca;
	private String TipoVino;
	private double Grados;
	private double Precio;
	private double Volumen;
	private String Envase;
	private LocalDate Caducidad;
	private double Descuento;
	
	public Vino(String marca, String tipoVino, double grados, double precio) {
		Marca = marca;
		TipoVino = tipoVino;
		this.Grados = grados;
		this.Precio = precio;
	}
	
	
	
	public String getMarca() {
		return Marca;
	}



	public void setMarca(String marca) {
		Marca = marca;
	}



	public String getTipoVino() {
		return TipoVino;
	}



	public void setTipoVino(String tipoVino) {
		TipoVino = tipoVino;
	}



	public double getGrados() {
		return Grados;
	}



	public void setGrados(double grados) {
		this.Grados = grados;
	}



	public double getPrecio() {
		return Precio;
	}



	public void setPrecio(double precio) {
		this.Precio = precio;
	}



	@Override
	public void setVolumen(double v) {
		this.Volumen=v;
		
	}
	@Override
	public double getVolumen() {
		
		return this.Volumen;
	}
	@Override
	public void setTipoEnvase(String env) {
		this.Envase=env;
		
	}
	@Override
	public String getTipoEnvase() {
		return this.Envase;
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
		return (int) (this.Grados*10);
	}
	@Override
	public void setDescuento(double des) {
		this.Descuento=des;
		
	}
	@Override
	public double getDescuento() {
		return this.Descuento;
	}
	@Override
	public double getPrecioDescuento() {
		return this.Precio - (this.Precio*(this.Descuento/100));
	}



	@Override
	public String toString() {
		return "Vino--> Marca= " + this.Marca + " | Tipo de Vino= " + this.TipoVino +
				"| Grados= " + this.Grados + "| Precio= " + this.Precio +
				"| Volumen= " + this.Volumen + "\n| Envase= " + this.Envase +
				"| Caducidad= " + this.Caducidad.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "| Descuento="+ this.Descuento +
				"| Con ofertita= "+ getPrecioDescuento() + "| Calorias= "+ getCalorias() +" |";
	}
	
	
	
}
