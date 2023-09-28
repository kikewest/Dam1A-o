package Supermercado;

public class Detergente implements EsLiquido, ConDescuento {
	private String Marca;
	private double Precio;
	private double Volumen;
	private String Envase;
	private double Descuento;
	
	
	//atributos
	public Detergente(String marca, double precio) {
		this.Marca = marca;
		this.Precio = precio;
		
		
		
	//getter y setters
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
	public String getEnvase() {
		return Envase;
	}
	public void setEnvase(String envase) {
		Envase = envase;
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
		this.Envase= env;
		
	}
	@Override
	public String getTipoEnvase() {
		// TODO Auto-generated method stub
		return this.Envase;
	}
	@Override
	public void setDescuento(double des) {
		this.Descuento=des;
		
	}
	@Override
	public double getDescuento() {
		// TODO Auto-generated method stub
		return this.Descuento;
	}
	@Override
	public double getPrecioDescuento() {
		return Precio - (Precio * (this.Descuento/100.0));
		
	}
	@Override
	public String toString() {
		return "Detergente--> Marca= " + this.getMarca() + " | Precio= " + this.getPrecio() +
				" | Volumen= " + this.getVolumen() + " | Envase= " + this.getEnvase() +
				" | Descuento= " + this.getDescuento() +
				" | Precio con descuento= " + getPrecioDescuento() + " |";
			
	}
	
	
	
}
