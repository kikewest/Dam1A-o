package ELECTRODOMESTICO;

public class LAVADORA extends ELECTRODOMESTICO{


	/*atributos*/

	private int carga;
	protected static final int CARGA=5;
	protected static final String TIPO="lavadora";

	/*getters y setters*/

	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}

	/*constructores*/

	public LAVADORA() {
		super();
		this.precioBase=PRECIOBASE;
		this.peso=PESO;
		this.color=COLOR;
		this.consumo=CONSUMO;
		this.carga=CARGA;
		this.tipo=TIPO;
	}
	public LAVADORA(double precioBase, int peso, String color, char consumo, int carga) {
		super(precioBase, peso, color, consumo);
		this.carga=carga;
		this.tipo=TIPO;
		comprobarConsumoEnergetico(getConsumo());
		comprobarColor(getColor());
	}
	public LAVADORA(double precioBase, int peso) {
		super(precioBase, peso);
		this.color = COLOR;
		this.consumo = CONSUMO;
		this.carga=CARGA;
		this.tipo=TIPO;
	}

	/*metodos*/

	public void precioFinal(){
		super.precioFinal();
		if (getCarga()>30) setPrecioBase(getPrecioBase()+50);
	}


}
