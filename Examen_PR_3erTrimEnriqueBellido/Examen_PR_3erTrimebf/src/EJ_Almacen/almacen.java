package EJ_Almacen;

import java.io.*;
import java.io.RandomAccessFile;

/** CLASE ALMACÉN. 
 * Clase para incluir todo el código
 * para generar fichero aleatorio del almacén.
 * 
 * @author Juan Carlos
 * @version 1.0
 * @date May/2023
 *
 * @fichero almacen.dat
 * 
 * Nombre de fichero: "ALMACEN.DAT"
 */
public class almacen {
	// INSERTAR TODO EL CóDIGO NECESARIO PARA GESTIONAR EL FICHERO
	// Y RESOLVER EJERCICIO EXAMEN.
    private static final String FILE_PATH = "almacen.dat";
    private static final int RECORD_SIZE = 160;

    public static void main(String[] args) {
        /*¿Que tamaño tiene nuestro registro?=1604
         * ¿Cuantos registros tenemos en el fichero?=10
         * ¿Que tamaño tiene un registro?=160 bytes*/
    	try {
            insertarRegistros();
            costeAlmacen();
            String codigoArticuloAEliminar = "LEC001"; // Código del artículo a eliminar
            bajaArticulo(codigoArticuloAEliminar);
            String codigoArticuloVenta = "PAN002"; // Código del artículo a vender
            int unidadesVenta = 1; // Unidades a vender
            venta(codigoArticuloVenta, unidadesVenta);
            listarArticulos();
            int posicionRegistro = 7; // Posición del registro -1
            mostrarInformacionArticulo(posicionRegistro);
           
            File file = new File(FILE_PATH);
            long fileSize = file.length();
            System.out.println("Tamaño del fichero: " + fileSize + " bytes");     
            int numRegistros = (int) (fileSize / RECORD_SIZE);
            System.out.println("Registros en nuestro fichero= " + numRegistros);
            System.out.println("Tamaño de un registro:  " + RECORD_SIZE + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertarRegistros() throws IOException { //escribe en el fichero nuestros 10 registros
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
        articulos articulo1 = new articulos("PAN002", "Pan", "Pan de barra", "Departamento 2", 1.50, 10, "Panbisito");
        escribirRegistro(file, articulo1, 0);
        articulos articulo2 = new articulos("ARR003", "Arroz", "Arroz blanco", "Departamento 2", 3, 5, "Sol");
        escribirRegistro(file, articulo2, 1);
        articulos articulo3 = new articulos("PAN004", "Pan", "Andaluzas", "Departamento 2", 1.30, 10, "Panbisito");
        escribirRegistro(file, articulo3, 2);
        articulos articulo4 = new articulos("PAS005", "Pasta", "Espaguetis", "Departamento 2", 4.50, 5, "Yatecomo");
        escribirRegistro(file, articulo4, 3);
        articulos articulo5 = new articulos("PAS006", "Pasta", "Macarrones", "Departamento 2", 4, 4, "Gallo");
        escribirRegistro(file, articulo5, 4);
        articulos articulo6 = new articulos("HEL007", "Helado", "helado de vainilla", "Departamento 2", 7, 9, "Magnun");
        escribirRegistro(file, articulo6, 5);
        articulos articulo7 = new articulos("HEL008", "Helado", "Helado de chocolate", "Departamento 2", 9, 2, "Magnun");
        escribirRegistro(file, articulo7, 6);
        articulos articulo8 = new articulos("FRU009", "Fresas", "Fresa de huelva", "Departamento 2", 4, 6, "Fresero");
        escribirRegistro(file, articulo8, 7);
        articulos articulo9 = new articulos("AGU010", "Agua", "Fontbella", "Departamento 1", 1, 15, "Fontbella");
        escribirRegistro(file, articulo9, 8);
        articulos articulo10 = new articulos("LEC001", "Leche", "Leche de vaca","Departamento 1", 2, 5, "Asturiana");
        escribirRegistro(file, articulo10, 9);
        file.close();
    }

    public static void escribirRegistro(RandomAccessFile file, articulos articulo, int posicion) throws IOException { //escribe en el fichero nuestros 10 registros
        file.seek(posicion * RECORD_SIZE);
        escribirString(file, articulo.getCod_art(), 6);
        escribirString(file, articulo.getDescr(), 20);
        escribirString(file, articulo.getCaract(), 20);
        escribirString(file, articulo.getDepart(), 10);
        file.writeDouble(articulo.getPrecio());
        file.writeInt(articulo.getUnidades());
        escribirString(file, articulo.getProveedor(), 20);
    }

    public static void escribirString(RandomAccessFile file, String cadena, int longitud) throws IOException { // Cadena de string
        StringBuilder builder = new StringBuilder(cadena);
        builder.setLength(longitud);
        file.writeChars(builder.toString());
    }

    public static void costeAlmacen() throws IOException { //coste total de nuestro almacen 
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
        int numRegistros = (int) (file.length() / RECORD_SIZE);
        double costeTotal = 0.0;
        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            costeTotal += articulo.getPrecio() * articulo.getUnidades();
        }
        System.out.println("El coste total del almacén es: " + costeTotal + "€");
        file.close();
    }

    public static articulos leerRegistro(RandomAccessFile file, int posicion) throws IOException { //nos lee un registro segun la posicion que le digamos
        file.seek(posicion * RECORD_SIZE);
        String codigoArticulo = leerString(file, 6);
        String descripcion = leerString(file, 20);
        String caracteristicas = leerString(file, 20);
        String departamento = leerString(file, 10);
        double precio = file.readDouble();
        int unidades = file.readInt();
        String proveedor = leerString(file, 20);
        return new articulos(codigoArticulo, descripcion, caracteristicas, departamento, precio, unidades, proveedor);
    }

    public static String leerString(RandomAccessFile file, int longitud) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            builder.append(file.readChar());
        }
        return builder.toString().trim();
    }

    public static void bajaArticulo(String codigoArticulo) throws IOException { //Elimina un registro del fichero
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
        int numRegistros = (int) (file.length() / RECORD_SIZE);
        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (articulo.getCod_art().equals(codigoArticulo)) {
                articulo.setCod_art("");
                escribirRegistro(file, articulo, i);
                System.out.println("Artículo eliminado correctamente.");
                break;
            }
        }
        file.close();
    }

    public static void venta(String codigoArticulo, int unidadesVenta) throws IOException { //vende un articulo y actualiza el stock
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
        int numRegistros = (int) (file.length() / RECORD_SIZE);
        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (articulo.getCod_art().equals(codigoArticulo)) {
                if (articulo.getUnidades() >= unidadesVenta) {
                    articulo.setUnidades(articulo.getUnidades() - unidadesVenta);
                    escribirRegistro(file, articulo, i);
                    System.out.println("Venta realizada:");
                    System.out.println(articulo);
                } else {
                    System.out.println("No hay suficientes unidades disponibles para realizar la venta.");
                }
                break;
            }
        }

        file.close();
    }

    public static void listarArticulos() throws IOException { //nos dice los articulos completos de nuestro fichero
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
        int numRegistros = (int) (file.length() / RECORD_SIZE);
        System.out.println("Listado de artículos disponibles en el almacén:");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (!articulo.getCod_art().isEmpty()) {
                System.out.println(articulo);
            }
        }
        file.close();
    }

    public static void mostrarInformacionArticulo(int posicionRegistro) throws IOException { //nos muestra el registro segun la posicion indicada
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
        if (posicionRegistro >= 0 && posicionRegistro < file.length() / RECORD_SIZE) {
            articulos articulo = leerRegistro(file, posicionRegistro);
            System.out.println("Información del artículo en la posición " + (posicionRegistro + 1) + ":");
            System.out.println(articulo);
        } else {
            System.out.println("La posición de registro especificada no es válida.");
        }
        file.close();
    }
}
