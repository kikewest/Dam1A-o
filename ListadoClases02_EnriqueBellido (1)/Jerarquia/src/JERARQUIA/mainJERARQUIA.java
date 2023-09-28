package JERARQUIA;

public class mainJERARQUIA {

	public static void main(String[] args) {
		EMPLEADO e1= new EMPLEADO("Rafa");
		DIRECTIVO d1= new DIRECTIVO("Mario");
		OPERARIO op1= new OPERARIO("Alfonso");
		OFICIAL of1= new OFICIAL("Luis");
		TECNICO t1= new TECNICO ("Pablo");
		System.out.println(e1);
		System.out.println(d1);
		System.out.println(op1);
		System.out.println(of1);
		System.out.println(t1);
	}

}
