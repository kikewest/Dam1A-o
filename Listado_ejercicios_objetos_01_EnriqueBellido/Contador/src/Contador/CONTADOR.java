package Contador;



public class CONTADOR {
	/*ATRIBUTOS*/
	public int cont;

	/*Contructores*/
	public CONTADOR() {
		this.cont=0;
	}
	public CONTADOR(int valor) {
		if (valor<0) {
			this.cont=0;
		}else {
			this.cont=valor;
		}	
	}
	public CONTADOR (CONTADOR dato) {
		this.cont=dato.cont;
	}
	
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void Incrementa() {
		this.setCont(this.cont+1);
	}
	public void Decrementa() {
		this.setCont(this.cont-1);
		if(this.cont<0) {
			this.setCont(0);
		}
	}
}