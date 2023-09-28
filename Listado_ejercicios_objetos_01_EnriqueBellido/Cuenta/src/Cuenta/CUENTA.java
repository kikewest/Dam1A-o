package Cuenta;



public class CUENTA {
	/*ATRIBUTOS*/
	public String Cliente;
	public String Cuenta;
	public double Interes;
	public double Saldo;
	
	/*Contructores*/
	public CUENTA() {
		this.Cliente="";
		this.Cuenta="";
		this.Interes=0;
		this.Saldo=0;
	}
	public CUENTA(String cliente, String cuenta,double interes,double saldo) {
		this.Cliente=cliente;
		this.Cuenta=cuenta;
		this.Interes=interes;
		this.Saldo=saldo;
	}
	public CUENTA (CUENTA dato) {
		this.Cliente=dato.Cliente;
		this.Cuenta=dato.Cuenta;
		this.Interes=dato.Interes;
		this.Saldo=dato.Saldo;
	/*geter y seters*/
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public String getCuenta() {
		return Cuenta;
	}
	public void setCuenta(String cuenta) {
		Cuenta = cuenta;
	}
	public double getInteres() {
		return Interes;
	}
	public void setInteres(double interes) {
		Interes = interes;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	/*metodos*/
	
	public boolean Ingreso(double cantidad) {
		boolean correcto=true;
		if (cantidad>0) {
			this.setSaldo(this.getSaldo()+cantidad);
			System.out.println("Ingreso realizado");
			correcto= true;
		}else {
			System.out.println("Ingreso cancelado");
			correcto=false;
		}
		return correcto;
	}
	public boolean Reintegro(double cantidad) {
		boolean correcto=true;
		if (this.getSaldo()>cantidad) {
			this.setSaldo(this.getSaldo()-cantidad);
			System.out.println("reintegro realizado, se le ha restado una cantidad igual a :"+cantidad);
			correcto = true;
		}else {
			System.out.println("Reintegro cancelado");
			correcto= false;
		}
		return correcto;
	}
	public boolean transferencia(CUENTA destino, double n) {
        boolean correcto = true;
        if (n < 0) {
            correcto = false;
        } else if (this.getSaldo() >= n) {
            Reintegro(n);
            destino.Ingreso(n);
        } else {
            correcto = false;
        }
        return correcto;
    }
}

