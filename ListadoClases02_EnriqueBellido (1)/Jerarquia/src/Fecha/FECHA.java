package Fecha;

public class FECHA {
	/*ATRIBUTOS*/
	private int Dia;
	private int Mes;
	private int Anio;
	
	
	/*Contructores*/
	public FECHA() {
		this.Dia=0;
		this.Mes=0;
		this.Anio=0;
	}
	public FECHA(int dia, int mes, int anio) {
		this.Dia=dia;
		this.Mes=mes;
		this.Anio=anio;
	}
	/*geter y setters*/
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		this.Dia = dia;
	}
	public int getMes() {
		return Mes;
	}
	public void setMes(int mes) {
		this.Mes = mes;
	}
	public int getAnio() {
		return Anio;
	}
	public void setAnio(int anio) {
		this.Anio = anio;
	}
	/*metodos*/
	private boolean EsBisiesto() {
		boolean correcto=true;
		if ((this.getAnio() % 4 == 0) && ((this.getAnio() % 100 != 0) || (this.getAnio() % 400 == 0))) {
			System.out.println("El año es bisiesto");
			correcto = true;
		}else {
			System.out.println("El año no es bisiesto");
			correcto= false;
		}
		return correcto;
	}
	public boolean FechaCorrecta() {

		boolean correcto=true;
		if (this.getDia()<1|this.getMes()<1|this.getMes()>12|this.getAnio()<1) {
			correcto=false;
		}
		switch (this.getMes()) {
		case 1:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 2:
			if (EsBisiesto()&this.getDia()>29) {
				correcto=false;
			}else if (!EsBisiesto()&this.getDia()>28) {
				correcto=false;
			}
				break;
		case 3:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 4:
			if (this.getDia()>30) {
				correcto=false;
			}
				break;
		case 5:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 6:
			if (this.getDia()>30) {
				correcto=false;
			}
				break;
		case 7:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 8:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 9:
			if (this.getDia()>30) {
				correcto=false;
			}
				break;
		case 10:
			if (this.getDia()>31) {
				correcto=false;
			}
				break;
		case 11:
			if (this.getDia()>30) {
				correcto=false;
			}
				break;
		case 12:
			if (this.getDia()>31) {
				correcto=false;
				this.setAnio(this.getAnio()+1);
			}
				break;
		} if (correcto==true)	{
			System.out.println("La Fecha es Correcta");
		}else {
			System.out.println("La Fecha no es Correcta");
		}
		return correcto;
	}
	public void DiaSiguiente() {
		this.setDia(this.getDia()+1);
		if (FechaCorrecta()==false) {
			this.setDia(1);
			this.setMes(this.getMes()+1);
		}
		if (FechaCorrecta()==false) {
			this.setMes(1);
			}
	}
	public String toString() {	
	        StringBuilder sb = new StringBuilder();
	        if (this.Dia < 10) {
	            sb.append("0");
	        }
	        sb.append(this.Dia);
	        sb.append("-");
	        if (this.Mes < 10) {
	            sb.append("0");
	        }
	        sb.append(this.Mes);
	        sb.append("-");
	        sb.append(this.Anio);
	        return sb.toString();
	    }
	
	public boolean EsMayorQue(FECHA f) {
		boolean correcto=true;
		if (this.getAnio()<f.getAnio()) {
			correcto=false;
		}
		if (this.getAnio()==f.getAnio()&this.getMes()<f.getMes()) {
			correcto=false;
		}
		if (this.getAnio()==f.getAnio()&this.getMes()==f.getMes()&this.getDia()<f.getDia()) {
			correcto=false;
		}
		return correcto;
	}
	
	public String MostrarFecha() {
		String mes="";
		switch (this.getMes()) {
		case  1: mes="Enero";
				break;
		case 2: mes="Febrero";
				break;
		case 3: mes="Marzo";
				break;
		case 4:	mes="Abril";
				break;
		case 5: mes="Marzo";
				break;
		case 6: mes="Junio";
				break;
		case 7: mes ="Julio";
				break;
		case 8: mes ="Agosto";
				break;
		case 9: mes="Septiembre";
				break;
		case 10: mes="Octubre";
				break;
		case 11: mes="Noviembre";
				break;
		case 12: mes="Diciembre";
				break;
	}
		String caracter="";
		if (this.Dia < 10) {
            caracter+="0"+this.getDia()+"/"+mes+"/"+this.getAnio();
            System.out.println(caracter);
        }else {
        	caracter+=this.getDia()+"/"+mes+"/"+this.getAnio();
        	System.out.println(caracter);
        }
		return caracter;
	}
}



