package AccesoAleatorioVehiculos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class claseVehiculo {
	//Atributos de nuestra clase
	protected String matricula;
	protected String marca;
	protected Double deposito;
	protected String modelo;
	static int cont=0;
	
	static Scanner lectura = new Scanner(System.in);
	static RandomAccessFile fichero = null;
	StringBuffer SBmarca = null;
	StringBuffer SBmodelo = null;
	//constructores
	public claseVehiculo(String matricula, String marca, Double deposito, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.deposito = deposito;
		this.modelo = modelo;
	}
	
	public claseVehiculo( ) {
		this.matricula =null ;
		this.marca =null ;
		this.deposito =null;
		this.modelo = null;
	}
	//getter y setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getDeposito() {
		return deposito;
	}

	public void setDeposito(Double deposito) {
		this.deposito = deposito;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void almacenarVehiculo() {
		String depos;
		try {
			fichero = new RandomAccessFile("Ficheros//Vehiculos.dat","rw");
			fichero.seek(fichero.length());
			do{
	            System.out.println("Introduce la matricula del vehiculo:");
	            matricula=lectura.nextLine();
	            fichero.writeChars(matricula);
	        }while(matricula.isEmpty() || matricula.length() >=14);
	        
	        do{
	            System.out.println("Introduce la marca del vehiculo: ");
	            marca=lectura.nextLine();
	            SBmarca = new StringBuffer();
	            SBmarca.append(marca);// Le decimos al StringBuffer que lo que almacena es la lecutra de marca
	            SBmarca.setLength(20);//le decimos al StringBuffer que el espacio para marca es de 20 caracteres = 40 bytes
	            fichero.writeChars(SBmarca.toString());//Cogemos el StringBuffer de marca entero y lo escribimos en el fichero
	        }while(marca.isEmpty() || marca.length()>20);
	        
	        do{
	            System.out.println("Introduce el tamaño del deposito del vehiculo: ");
	            depos=lectura.nextLine();
	            try {
	            	deposito=Double.parseDouble(depos);
	            	fichero.writeDouble(deposito);
	            } catch (NumberFormatException e) {
	            	System.out.println("No se pudo convertir el deposito a double");
	            }
	        }while(deposito.BYTES>8 || deposito==0);
	        
	        do{
	            System.out.println("Introduce el modelo del vehiculo: ");
	            modelo=lectura.nextLine();
	            SBmodelo = new StringBuffer();
	            SBmodelo.append(modelo);
	            SBmodelo.setLength(20);
	            fichero.writeChars(SBmodelo.toString());
	        }while(modelo.isEmpty() || modelo.length()>20);
	        cont++;
	        fichero.close();
	        
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			
		}
	}
	
	public static void mostrarFicheroEntero() {
		try {
			fichero = new RandomAccessFile("Ficheros//Vehiculos.dat","r");
			fichero.seek(0);
			String mostrarmatricula = "";
			String mostrarmarca="";
			String mostrardeposito="";
			String mostrarmodelo="";
			String mostrar="";
			Double aux;
			for(int i=0;i<cont;i++) {
				fichero.seek(i*102);
				 byte[] bytes = new byte[102];
			        fichero.read(bytes,0,14);// lee desde la posicion 0 y 14 bytes apartir de esa posicion
			        mostrarmatricula = new String(bytes,0,14);
			        fichero.read(bytes,14,40);
			        mostrarmarca = new String(bytes,14,40).trim();
			        aux = fichero.readDouble();
			        mostrardeposito = Double.toString(aux);
			        fichero.read(bytes,62,40);
			        mostrarmodelo = new String(bytes,62,40).trim();
			        mostrar+="Matricula :"+mostrarmatricula+" \t Marca : "+mostrarmarca+" \t Deposito : "+mostrardeposito+" \t Modelo : "+mostrarmodelo+"\n";
			        
			}
	       System.out.println(mostrar);
	        fichero.close();
			
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void mostrarVehiculo() {
		int pos;
		int tamañoCoche=102;
		String mostrarmatricula = "";
		String mostrarmarca="";
		String mostrardeposito="";
		String mostrarmodelo="";
		String mostrar="";
		Double aux;
		try {
			fichero = new RandomAccessFile("Ficheros//Vehiculos.dat","r");
			
			System.out.println("Indique que la posicion del vehiculo que quiere ver (de 0 a fin)");
			pos = lectura.nextInt();
				fichero.seek(pos*tamañoCoche);
				byte[] bytes = new byte[tamañoCoche];
				fichero.read(bytes,0,14);// lee desde la posicion 0 y 14 bytes apartir de esa posicion
		        mostrarmatricula = new String(bytes,0,14);
		        fichero.read(bytes,14,40);
		        mostrarmarca = new String(bytes,14,40).trim();
		        aux = fichero.readDouble();
		        mostrardeposito = Double.toString(aux);
		        fichero.read(bytes,62,40);
		        mostrarmodelo = new String(bytes,62,40).trim();
		        mostrar+="Matricula :"+mostrarmatricula+" \t Marca : "+mostrarmarca+" \t Deposito : "+mostrardeposito+" \t Modelo : "+mostrarmodelo+"\n";
		        System.out.println(mostrar);
			
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	

	public static void menu() {
		int opcion = 0;
	    claseVehiculo vehiculo = new claseVehiculo();

	    do {
	        System.out.println("======= MENÚ =======");
	        System.out.println("1. Almacenar un vehículo");
	        System.out.println("2. Mostrar un vehículo");
	        System.out.println("3. Mostrar todos los vehículos");
	        System.out.println("0. Salir");
	        System.out.print("Selecciona una opción: ");

	        opcion = lectura.nextInt();
	        lectura.nextLine(); 

	        switch (opcion) {
	            case 1:
	                vehiculo.almacenarVehiculo();
	                break;
	            case 2:
	                vehiculo.mostrarVehiculo();
	                break;
	            case 3:
	                claseVehiculo.mostrarFicheroEntero();
	                break;
	            case 0:
	                System.out.println("Saliendo del programa...");
	                break;
	            default:
	                System.out.println("Opción no válida");
	                break;
	        }

	        System.out.println();
	    } while (opcion != 0);
	}
}
