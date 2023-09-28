package ELECTRODOMESTICO;

public class ELECTRODOMESTICO {

	/*atributos*/

	protected double precioBase; 
	protected int peso;
	protected String color, tipo;
	protected char consumo;
	protected static final int PRECIOBASE=100, PESO=5;
	protected static final String COLOR="blanco";
	protected static final char CONSUMO='F';

	/*getters y setters*/

	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getConsumo() {
		return consumo;
	}
	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPulgadas() {
		return 0;
	}
	public boolean isTdt() {
		return false;
	}

	public int getCarga() {
		return 0;
	}

	/*constructores*/


	public ELECTRODOMESTICO () {
		this.precioBase=PRECIOBASE;
		this.peso=PESO;
		this.color=COLOR;
		this.consumo=CONSUMO;
	}
	public ELECTRODOMESTICO(double precioBase, int peso, String color, char consumo) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = color;
		this.consumo = consumo;
		comprobarConsumoEnergetico(getConsumo());
		comprobarColor(getColor());
	}
	public ELECTRODOMESTICO(double precioBase, int peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = COLOR;
		this.consumo = CONSUMO;
	}

	public void comprobarConsumoEnergetico (char letra) {
		if ((letra!='A') & (letra!='B') & (letra!='C') & (letra!='D') & (letra!='E') & (letra!='F'))
			letra=CONSUMO;}
	public void comprobarColor (String color) {
		if ((color!="blanco")&(color!="negro")&(color!="rojo")&(color!="azul")&(color!="gris")&
				(color!="Blanco")&(color!="Negro")&(color!="Rojo")&(color!="Azul")&(color!="Gris")&
				(color!="BLANCO")&(color!="NEGRO")&(color!="ROJO")&(color!="AZUL")&(color!="GRIS"))
			color=COLOR;
	}
	public void precioFinal() {
		switch(getConsumo()) {
		case 'A': setPrecioBase(getPrecioBase()+100); 
		break;
		case 'B': setPrecioBase(getPrecioBase()+80); 
		break;
		case 'C': setPrecioBase(getPrecioBase()+60); 
		break;
		case 'D': setPrecioBase(getPrecioBase()+50); 
		break;
		case 'E': setPrecioBase(getPrecioBase()+30); 
		break;
		case 'F': setPrecioBase(getPrecioBase()+10); 
		break;
		}
		if (getPeso()<20) setPrecioBase(getPrecioBase()+10);
		if ((getPeso()>19)&(getPeso()<50)) setPrecioBase(getPrecioBase()+50);
		if ((getPeso()>49)&(getPeso()<80)) setPrecioBase(getPrecioBase()+80);
		if ((getPeso()>79)) setPrecioBase(getPrecioBase()+100);
	}

}

