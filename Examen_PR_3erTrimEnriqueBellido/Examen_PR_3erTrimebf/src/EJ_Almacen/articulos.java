package EJ_Almacen;

import java.io.*;
import java.util.Scanner;



/** CLASE ARTÍCULOS. 
 * Base para generar fichero aleatorio del almacén.
 * 
 * @author Juan Carlos
 * @version 1.0
 * @date May/2023
 *
 *
 * Nota: Se debe modificar la presente clase para utilizarla para el fichero "ALMACEN.DAT"
 */
public class articulos {
	
	/* ATRIBUTOS de la Clase ARTICULOS tamaño total de un articolo=164 bytes */
	public static final int SIZE = 6 + 20 + 20 + 10 + 8 + 4 + 20;
	/** Atributo; COD_ART. Identificación del artículo
	 *  Formato: 3 caracteres + 3 números 
	 *  Ejemplo: Artículo PAN: PAN001 
	 *  Ejemplo: Artículo LECHE: LEC001 .... etc 
	 *  TAMAÑO: 6 caracteres. tamaño = 12 bytes */
	private String cod_art;
	
	/** Atributo DESCR. Descripción/Identificación del artículo 
	 * TAMAÑO: 20 caracteres.tamaño= 40 bytes */
	private String descr;
	
	/** Atributo CARACT. Características del artículo. 
	 * TAMAÑO: 20 caracteres.tamaño= 40 bytes */	
	private String caract;
	
	/** Atributo DEPART. Departamento al que pertenece el artículo 
	 * TAMAÑO: 10 caracteres. 20 bytes */
	private String depart;
	
	/** Atributo PRECIO. Precio en decimal(con dos decimales) del artículo 8 bytes*/
	private Double precio;
	
	/** Atributo UNIDADES. Unidades disponibles del artículo. Numérico entero 4 bytes*/
	private int unidades;
	
	/** Atributo PROVEEDOR. Nombre/Identificación del proveedor del artículo 
	 * TAMAÑO: 20 caracteres.40 bytes */
	private String proveedor;
	
	static Scanner lectura = new Scanner(System.in);
	static RandomAccessFile fichero = null;
	StringBuffer SBdescr = null;
	StringBuffer SBcaract = null;
	StringBuffer SBdepart = null;
	StringBuffer SBprov = null;
	/* Constructores de la clase ARTICULO */
	
	public articulos() {
		super();
	}
	
	public articulos(String cod, String des, String cara, String dep, double p, int s, String prove) {
		super();
		setCod_art(cod);
		setDescr(des);
		setCaract(cara);
		setDepart(dep);
		setPrecio(p);
		setUnidades(s);
		setProveedor(prove);
	}
	
	/*Métodos Setter y Getter de los atributos */
	


	public String getCod_art() {
		return cod_art;
	}

	public void setCod_art(String cod_art) {
		this.cod_art = cod_art;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCaract() {
		return caract;
	}

	public void setCaract(String caract) {
		this.caract = caract;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	/* Método toString predefinido por @author */
	@Override
	public String toString() {
		return "ARTICULO --  ["+ cod_art + " \t " + descr + " - " + caract + " \t" + precio + "€ " + unidades + " unidades ] \n";
	}

	
	
	public void InserccionDatos() {
		String pre;
		String uni;
		try {
			fichero = new RandomAccessFile("almacen.dat","rw");
			fichero.seek(fichero.length());
			do{
	            System.out.println("Introduce el codigo del articulo:");
	            cod_art=lectura.nextLine();
	            fichero.writeChars(cod_art);
	        }while(cod_art.isEmpty() || cod_art.length() >=12);
	        
	        do{
	            System.out.println("Introduce la descripcion del articulo: ");
	            descr=lectura.nextLine();
	            SBdescr = new StringBuffer();
	            SBdescr.append(descr);// Le decimos al StringBuffer que lo que almacena es la lecutra de descripcion
	            SBdescr.setLength(20);//le decimos al StringBuffer que el espacio para la descripcion es de 20 caracteres = 40 bytes
	            fichero.writeChars(SBdescr.toString());//Cogemos el StringBuffer de descripcion entero y lo escribimos en el fichero
	        }while(descr.isEmpty() || descr.length()>20);
	        
	        do{
	            System.out.println("Introduce las caracteristicas del articulo: ");
	            caract=lectura.nextLine();
	            SBcaract = new StringBuffer();
	            SBcaract.append(caract);// Le decimos al StringBuffer que lo que almacena es la lecutra de descripcion
	            SBcaract.setLength(20);//le decimos al StringBuffer que el espacio para la descripcion es de 20 caracteres = 40 bytes
	            fichero.writeChars(SBcaract.toString());//Cogemos el StringBuffer de descripcion entero y lo escribimos en el fichero
	        }while(caract.isEmpty() || caract.length()>20);
	        
	        do{
	            System.out.println("Introduce el departamento del articulo: ");
	            depart=lectura.nextLine();
	            SBdepart = new StringBuffer();
	            SBdepart.append(caract);// Le decimos al StringBuffer que lo que almacena es la lecutra de descripcion
	            SBdepart.setLength(10);//le decimos al StringBuffer que el espacio para la descripcion es de 10 caracteres = 20 bytes
	            fichero.writeChars(SBdepart.toString());//Cogemos el StringBuffer de descripcion entero y lo escribimos en el fichero
	        }while(depart.isEmpty() || depart.length()>10);
	        
	        
	        do{
	            System.out.println("Introduce el precio del articulo: ");
	            pre=lectura.nextLine();
	            try {
	            	precio=Double.parseDouble(pre);
	            	fichero.writeDouble(precio);
	            } catch (NumberFormatException e) {
	            	System.out.println("No se pudo convertir el deposito a double");
	            }
	        }while(precio.BYTES>8 || precio==0);
	        
	        do {
	            System.out.println("Introduce las unidades del articulo: ");
	            uni = lectura.nextLine();
	            try {
	                unidades = Integer.parseInt(uni);
	                fichero.writeInt(unidades);
	            } catch (NumberFormatException e) {
	                System.out.println("No se pudo convertir las unidades a entero");
	                continue; // Salta a la siguiente iteración del bucle sin comprobar la condición nuevamente
	            }
	            break; // Sale del bucle si las unidades se han introducido correctamente
	        } while (true);

	        
	        do{
	            System.out.println("Introduce la descripcion del articulo: ");
	            proveedor=lectura.nextLine();
	            SBprov = new StringBuffer();
	            SBprov.append(proveedor);// Le decimos al StringBuffer que lo que almacena es la lecutra de descripcion
	            SBprov.setLength(20);//le decimos al StringBuffer que el espacio para la descripcion es de 20 caracteres = 40 bytes
	            fichero.writeChars(SBprov.toString());//Cogemos el StringBuffer de descripcion entero y lo escribimos en el fichero
	        }while(proveedor.isEmpty() || proveedor.length()>20);
	        
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void agregarRegistros() {
        try {
            fichero = new RandomAccessFile("almacen.dat", "rw");
            fichero.seek(fichero.length());

            for (int i = 0; i < 10; i++) {
                System.out.println("Registro " + (i + 1));
                System.out.println("----------------");
                InserccionDatos();
                System.out.println();
            }

            System.out.println("¡Registros añadidos correctamente!");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public void mostrarArticulo() {
	    int pos;
	    int tamañoArticulo = 164;
	    String mostrarcod = "";
	    String mostrardescr = "";
	    String mostrarcaract = "";
	    String mostrardep = "";
	    String mostrarprec = "";
	    String mostrarunid = "";
	    String mostrarprov = "";
	    String mostrar = "";
	    Double aux;
	    int aux1 = 0;
	    try {
	        fichero = new RandomAccessFile("almacen.dat", "r");

	        System.out.println("Indique la posición del artículo que desea ver (de 0 a fin):");
	        pos = lectura.nextInt();
	        fichero.seek(pos * tamañoArticulo);
	        byte[] bytes = new byte[tamañoArticulo];

	        fichero.read(bytes, 0, 12);
	        mostrarcod = new String(bytes, 0, 12).trim();

	        fichero.read(bytes, 12, 40);
	        mostrardescr = new String(bytes, 12, 40).trim();

	        fichero.read(bytes, 52, 40);
	        mostrarcaract = new String(bytes, 52, 40).trim();

	        fichero.read(bytes, 92, 20);
	        mostrardep = new String(bytes, 92, 20).trim();

	        aux = fichero.readDouble();
	        mostrarprec = Double.toString(aux);

	        fichero.read(bytes, 120, 4);
	        aux1 = fichero.readInt();
	        mostrarunid = Integer.toString(aux1);

	        fichero.read(bytes, 124, 40);
	        mostrarprov = new String(bytes, 124, 40).trim();

	        mostrar += "Código: " + mostrarcod + "\tDescripción: " + mostrardescr + "\tCaracterística: " + mostrarcaract
	                + "\tDepartamento: " + mostrardep + "\tPrecio: " + mostrarprec + "\tUnidades: " + mostrarunid
	                + "\tProveedor: " + mostrarprov;

	        System.out.println(mostrar);

	    } catch (EOFException e) {
	        System.out.println("Fin del fichero");
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            fichero.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void costeAlmacen() {
	    double costeTotal = 0.0;
	    int posicion = 0;
	    int tamañoArticulo = 164;

	    try {
	        fichero = new RandomAccessFile("almacen.dat", "r");

	        while (true) {
	            fichero.seek(posicion * tamañoArticulo);

	            // Leer el código del artículo
	            byte[] bytes = new byte[12];
	            fichero.read(bytes, 0, 12);
	            String codArticulo = new String(bytes, 0, 12).trim();

	            // Leer las unidades del artículo
	            fichero.seek(posicion * tamañoArticulo + 120);
	            int unidades = fichero.readInt();

	            // Leer el precio del artículo
	            fichero.seek(posicion * tamañoArticulo + 92);
	            double precio = fichero.readDouble();

	            // Calcular el coste del artículo
	            double costeArticulo = unidades * precio;
	            costeTotal += costeArticulo;

	            // Mostrar información del artículo
	            System.out.println("Código: " + codArticulo);
	            System.out.println("Unidades: " + unidades);
	            System.out.println("Precio: " + precio);
	            System.out.println("Coste del artículo: " + costeArticulo);
	            System.out.println("----------------------");

	            posicion++;
	            if (fichero.getFilePointer() == fichero.length()) {
	                break;
	            }
	        }

	        System.out.println("Coste total del stock actual: " + costeTotal);

	    } catch (FileNotFoundException ex) {
	        System.out.println(ex.getMessage());
	    } catch (IOException ex) {
	        System.out.println(ex.getMessage());
	    } finally {
	        try {
	            fichero.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void bajaArticulo(String cod_articulo) {
	    int tamañoArticulo = 164;
	    int posicion = 0;
	    boolean encontrado = false;
	    try {
	        fichero = new RandomAccessFile("almacen.dat", "rw");

	        while (true) {
	            fichero.seek(posicion * tamañoArticulo);

	            // Leer el código del artículo
	            byte[] bytes = new byte[12];
	            fichero.read(bytes, 0, 12);
	            String codArticulo = new String(bytes, 0, 12).trim();

	            if (codArticulo.equals(cod_articulo)) {
	                encontrado = true;
	                break;
	            }

	            posicion++;
	            if (fichero.getFilePointer() == fichero.length()) {
	                break;
	            }
	        }

	        if (encontrado) {
	            //la posición del artículo a eliminar
	            long posicionEliminar = (long) posicion * tamañoArticulo;

	            //el puntero al final del fichero
	            fichero.seek(fichero.length());

	            //leer el último artículo del fichero
	            long posicionUltimo = fichero.getFilePointer() - tamañoArticulo;
	            byte[] ultimoArticuloBytes = new byte[tamañoArticulo];
	            fichero.seek(posicionUltimo);
	            fichero.read(ultimoArticuloBytes);

	            // Escribir el último artículo en la posición del artículo a eliminar
	            fichero.seek(posicionEliminar);
	            fichero.write(ultimoArticuloBytes);

	            // Truncar el fichero para eliminar el último artículo duplicado
	            fichero.setLength(fichero.length() - tamañoArticulo);

	            System.out.println("Artículo eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró el artículo con el código especificado.");
	        }

	    } catch (FileNotFoundException ex) {
	        System.out.println(ex.getMessage());
	    } catch (IOException ex) {
	        System.out.println(ex.getMessage());
	    } finally {
	        try {
	            fichero.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public void ventas(String cod_articulo, int unidades) {
	    RandomAccessFile fichero = null;
	    int tamañoArticulo = 164;
	    int posicion = 0;

	    try {
	        fichero = new RandomAccessFile("almacen.dat", "rw");

	        while (true) {
	            fichero.seek(posicion * tamañoArticulo);

	            // Leer el código del artículo
	            byte[] bytes = new byte[12];
	            fichero.read(bytes, 0, 12);
	            String codArticulo = new String(bytes, 0, 12).trim();

	            // Leer las unidades del artículo
	            fichero.seek(posicion * tamañoArticulo + 120);
	            int stock = fichero.readInt();

	            if (codArticulo.equals(cod_articulo)) {
	                if (stock >= unidades) {
	                    // Actualizar el stock
	                    fichero.seek(posicion * tamañoArticulo + 120);
	                    fichero.writeInt(stock - unidades);

	                    System.out.println("=== VENTA REALIZADA ===");
	                    System.out.println("Código: " + codArticulo);
	                    System.out.println("Unidades vendidas: " + unidades);
	                    System.out.println("Stock restante: " + (stock - unidades));

	                    break; //salir del bucle si se encontró el artículo y se realizó la venta
	                } else {
	                    System.out.println("No hay suficientes unidades disponibles para la venta.");
	                    break; //salir del bucle si no hay suficientes unidades para la venta
	                }
	            }

	            posicion++;
	            if (fichero.getFilePointer() == fichero.length()) {
	                System.out.println("No se encontró el artículo con el código especificado.");
	                break; //salir del bucle si se recorrió todo el fichero sin encontrar el artículo
	            }
	        }

	    } catch (FileNotFoundException ex) {
	        System.out.println(ex.getMessage());
	    } catch (IOException ex) {
	        System.out.println(ex.getMessage());
	    } finally {
	        try {
	            if (fichero != null) {
	                fichero.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

 	
	public void menu() {
	    int opcion = 0;
	    articulos art1 = new articulos();

	    do {
	        System.out.println("======= MENÚ =======");
	        System.out.println("1. Insertar datos");
	        System.out.println("2. Mostrar un artículo");
	        System.out.println("3. Mostrar coste total del stock");
	        System.out.println("4. Eliminar un artículo");
	        System.out.println("5. Realizar venta de un artículo");
	        System.out.println("0. Salir");
	        System.out.print("Selecciona una opción: ");

	        opcion = lectura.nextInt();
	        lectura.nextLine();

	        switch (opcion) {
	            case 1:
	                art1.InserccionDatos();
	                break;
	            case 2:
	                art1.mostrarArticulo();
	                break;
	            case 3:
	                art1.costeAlmacen();
	                break;
	            case 4:
	                System.out.println("Introduce el código del artículo a eliminar: ");
	                String codigoEliminar = lectura.nextLine();
	                art1.bajaArticulo(codigoEliminar);
	                break;
	            case 5:
	                System.out.println("Introduce el código del artículo a vender: ");
	                String codigoVenta = lectura.nextLine();
	                System.out.println("Introduce la cantidad de unidades a vender: ");
	                int unidadesVenta = lectura.nextInt();
	                lectura.nextLine();
	                art1.ventas(codigoVenta, unidadesVenta);
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
