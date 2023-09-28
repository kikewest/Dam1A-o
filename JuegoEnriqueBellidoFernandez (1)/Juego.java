
public class Juego {
	
	/* ATRIBUTOS */
	public int Vidas;
	
	public Juego(int vidasiniciales) {
		this.Vidas=vidasiniciales;
	
	}

	public int getVidas() {
		return Vidas;
	}

	public void setVidas(int vidas) {
		this.Vidas = vidas;
	}
	public String MuestraVidasRestantes() {
		String caracter= " ";
		caracter+= " Vidas Restantes = " + this.Vidas;
		return caracter;
	}
	
	public void RestaVidas () {
		this.Vidas=this.Vidas-1;
	}  
	public static void main(String[] args) {
	Juego j1 = new Juego(5);
	System.out.println(j1.MuestraVidasRestantes());
	j1.RestaVidas();
	System.out.println(j1.MuestraVidasRestantes());
	Juego j2 = new Juego(5);
	System.out.println(j2.MuestraVidasRestantes());
	System.out.println(j1.MuestraVidasRestantes());
	}
}
