
public class JuegoDos {
	/* ATRIBUTOS */
	private int Vidas;
	private int vidasiniciales;
	private static int Record=0;
	/*Contructor*/
	public JuegoDos(int vidasiniciales) {
		this.Vidas=vidasiniciales;
		this.vidasiniciales=vidasiniciales;
	}
	/*metodos*/
	public void ReiniciarPartida() {
		this.setVidas(this.vidasiniciales);
		System.out.println("La Partida Se Reinicio");
	}
	
	public void ActualizaRecord() {
		
		if (this.Vidas==JuegoDos.Record) {
			System.out.println("Se ha alcanzado el Record su record es ="+Record);
		}else if (this.Vidas>Record) {
			Record=this.Vidas;
			System.out.println("Se ha batido el Record, su record es = "+Record);
		}
	}
	/*geteruseters*/
	public int getVidas() {
		return this.Vidas;
	}

	public void setVidas(int vidas) {
		this.Vidas = vidas;
	}
	
	public int getVidasiniciales() {
		return vidasiniciales;
	}
	public void setVidasiniciales(int vidasiniciales) {
		this.vidasiniciales = vidasiniciales;
	}
	public int getRecord() {
		return Record;
	}

	public void setRecord(int record) {
		Record = record;
	}
	/*metodos*/
	public boolean QuitaVida() {
		this.Vidas=this.Vidas-1;
		System.out.println("Usted a perdido una vida");
		if (this.Vidas==0)
			System.out.println("Game Over");
		return this.Vidas>0;
	}
	public String toString() {
		String caracter= " ";
		caracter+= " Vidas Restantes = " + this.Vidas;
		return caracter;
	}
	public void MuestraVidasRestantes() {
		System.out.println(this.toString());
	}
}