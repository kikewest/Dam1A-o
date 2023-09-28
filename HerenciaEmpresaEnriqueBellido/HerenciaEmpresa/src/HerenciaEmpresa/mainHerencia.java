package HerenciaEmpresa;

public class mainHerencia {

	public static void main(String[] args) {
		Empresa empresa1=new Empresa("Zara", 4);
		empresa1.nuevoEmpleado("Enrique",1000);
		System.out.println(empresa1.empleados[0]);
		empresa1.empleados[0].ascender();
		System.out.println(empresa1.empleados[0]);
		empresa1.despideEmpleados(0);
		System.out.println(empresa1.empleados[0]);
		empresa1.nuevoEmpleado("Antonio",1200);
		System.out.println(empresa1.empleados[0]);
		empresa1.empleados[0].aumentarsueldo(2);
		System.out.println(empresa1.empleados[0]);
		empresa1.empleados[0].despedir();
		System.out.println(empresa1.empleados[0]);
		System.out.println("---------------------------------");

		empresa1.nuevoEmpleado("yerai",1300);
		empresa1.nuevoEmpleado("rafa",1000);
		empresa1.nuevoEmpleado("santiago",1100);
		empresa1.nuevoEmpleado("pablo",1200);
		for (int i=0; i<empresa1.tamanio;i++) {
			System.out.println(empresa1.empleados[i]);
		}

		System.out.println("---------------------------------");
		empresa1.despideEmpleados(1);

		for (int i=0; i<empresa1.tamanio;i++) {
			System.out.println(empresa1.empleados[i]);
		}
		System.out.println("---------------------------------");
		empresa1.nuevoEmpleado("Sergio",1000);

		for (int i=0; i<empresa1.tamanio;i++) {
			System.out.println(empresa1.empleados[i]);
		}
		System.out.println("---------------------------------");
		empresa1.nuevoEmpleado("Jose",2000);
	}

}


