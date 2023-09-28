package GestionDeAlmacenes;

import java.util.*;

public class MainAlmacen {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int num;
		ArrayList<ARTICULOS> articulos = new ArrayList<ARTICULOS>();
		ArrayList<PROVEEDORES> proveedores = new ArrayList<PROVEEDORES>();
		ArrayList<VENTAS> ventas = new ArrayList<VENTAS>();



		System.out.println("Selecciona una opcion:\n1. Alta Articulo\n2. Baja Articulo\n3."
				+ " Alta Proveedor\n4. Baja Proveedor\n5. Listar Articulos\n6. Listar Proveedores"
				+ "\n7. Venta Artículo\n8. Existencias Disponibles");

		num = leer.nextInt();

		if (num==1) {
			System.out.println("Escriba el codigo del articulo a añadir: ");
			int codigo = leer.nextInt();
			System.out.println("Escriba el nombre del articulo a añadir: ");
			String nombre = leer.nextLine();
			System.out.println("Escriba la descripcion del articulo a añadir:");
			String descripcion = leer.nextLine();
			System.out.println("Escriba el precio del articulo a añadir:");
			int precio = leer.nextInt();
			System.out.println("Escriba el iva aplicado del articulo a añadir:");
			int iva = leer.nextInt();
			System.out.println("Escriba el PROVEEDOR del articulo a añadir:");
			String proveedor = leer.nextLine();
			System.out.println("Escriba las unidades disponibles del articulo a añadir:");
			int unidades = leer.nextInt();
			articulos.add(new ARTICULOS(codigo, nombre, descripcion,precio,iva,null,unidades));
		}else if (num==2) {
			System.out.println("escriba el codigo del articulo a borrar");
			int codigo = leer.nextInt();
			Iterator<ARTICULOS> iteradorA = articulos.iterator();
			while (iteradorA.hasNext()) {
				ARTICULOS b=iteradorA.next();
				if (b.getCodigoArticulo()==codigo) {
					iteradorA.remove();
				}else {
					System.out.println("el codigo del articulo no existe");
				}
			}
		}else if (num==3) {
			System.out.println("Escriba el codigo del proveedor a añadir: ");
			int codigo = leer.nextInt();
			System.out.println("Escriba el nombre del proveedor a añadir: ");
			String nombre = leer.nextLine();
			System.out.println("Escriba la direccion del proveedor a añadir:");
			String direccion = leer.nextLine();
			System.out.println("Escriba la fecha de alta del proveedor a añadir:");
			String fechaAlta = leer.nextLine();
			System.out.println("Escriba el telefono aplicado del proveedor a añadir:");
			int telefono = leer.nextInt();
			System.out.println("Escriba el correo electronico del proveedor a añadir:");
			String correo = leer.nextLine();
			proveedores.add(new PROVEEDORES(codigo, nombre, direccion,fechaAlta,telefono,correo));
		}else if (num==4) {
			System.out.println("escriba el codigo del Proveedor a dar de baja");
			int codigo = leer.nextInt();
			Iterator<PROVEEDORES> iteradorP = proveedores.iterator();
			while (iteradorP.hasNext()) {
				PROVEEDORES b=iteradorP.next();
				if (b.getCodigo()==codigo) {
					iteradorP.remove();
				}else {
					System.out.println("el codigo del articulo no existe");
				}
			}
		}else if (num==5) {
			System.out.println(articulos);
		}else if (num==6) {
			System.out.println(proveedores);
		}else if (num==7) {
			Iterator<ARTICULOS> iteradorA = articulos.iterator();
			ARTICULOS b=iteradorA.next();
			while (iteradorA.hasNext()) {
				System.out.println("Introduzca el codigo del articulo vendido para añadirlo a la lista de ventas :");
				int codigo= leer.nextInt();
				for (int i=0;i<articulos.size();i++) {
					if (b.getCodigoArticulo()==codigo) {
						System.out.println("Escriba la fecha de la venta a añadir: ");
						String fecha = leer.nextLine();
						System.out.println("Escriba las unidades vendidas del articulo: ");
						int unidades = leer.nextInt();
						System.out.println("Escriba el precio total de la venta:");
						int precio = leer.nextInt();
						System.out.println("Escriba si la venta se ha pagado con S para si y N para no: ");
						boolean confirmacion =leer.hasNext();	
						ventas.add(new VENTAS(articulos.get(i),fecha,unidades,precio,confirmacion));
					}else {
						System.out.println("El codigo Introducido no existe");
					}
				}
			}
		}else if (num==8) {
			
		}



	}

}
