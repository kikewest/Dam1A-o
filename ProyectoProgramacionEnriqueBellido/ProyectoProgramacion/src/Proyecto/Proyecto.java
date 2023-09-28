package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * Clase Proyecto que contiene métodos para interactuar con una base de datos dedicada a un centro educativo EBF.
 */
public class Proyecto {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/proyecto";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";

	Scanner lectura = new Scanner(System.in);
	Connection conec = conectarBBDD();
	/**
	 * Establece una conexión con nuestra base de datos.
	 *
	 * @return La conexión establecida.
	 */
	public Connection conectarBBDD() {
		Connection conec = null;

		try {
			Class.forName(DRIVER);
			conec = DriverManager.getConnection(BBDD, USUARIO, PASSWORD);

		} catch (Exception errores) {
			System.out.println("Se ha producido un error al conectar\n"+ errores);
		}
		return conec;
	}
	/**
	 * Cierra la conexión con nuestra base de datos.
	 *
	 * @param conec La variable de nuestra conexion a cerrar.
	 */
	public void cerrarConexion (Connection conec) {

		try {
			conec.close();

		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion\n"+e);
		}
	}
	/**
	 * Muestra el menú de inicio de sesión para los usuarios de nuestra BBDD.
	 * Solicita el nombre de usuario y la contrasenia, y realiza la autenticación en la base de datos.
	 * Dependiendo del rol del usuario, muestra su menú correspondiente.
	 * Cierra la conexión a la base de datos al finalizar.
	 */
	public void menuUsuario() {
		System.out.println("Bienvenido al centro Ilerna\n");
		System.out.println("Por favor introduzca su nombre de usuario");
		String usuario=lectura.next();
		System.out.println();
		System.out.println("Por favor introduzca su contraseña");
		String contrasenia=lectura.next();
		Connection conec = conectarBBDD();
		String consulta = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' AND contraseña = '"+contrasenia+"';";
		if (conec!=null) 
			try {
				Statement consultaaux = conec.createStatement();
				ResultSet resultSet = consultaaux.executeQuery(consulta);

				if (resultSet.next()) {
					String rol = resultSet.getString("rol");
					System.out.println("Inicio de sesión exitoso. Rol: " + rol);
					switch (rol) {
					case "director":
						System.out.println("Bienvenido, Director");
						menuDirector();
						break;
					case "secretario":
						System.out.println("Bienvenido, Secretario");
						menuSecretaria();
						break;
					case "profesor":
						System.out.println("Bienvenido, Profesor");
						menuProfesor();
						break;
					default:
						System.out.println("Rol no reconocido, cerrando base de datos");
						break;
					}

				} else {
					System.out.println("Nombre de usuario y/o contraseña incorrectos, cerrando base de datos");
					cerrarConexion(conec);
				}

				consultaaux.close();
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Error al ejecutar la consulta: " + e.getMessage());


			}
		cerrarConexion(conec);
	}	
	/**
	 * Muestra el menú de opciones para el rol de Director.
	 * Permite realizar diferentes acciones de gestión y obtención de listados de nuestras tablas.
	 * El menú se repite hasta que se seleccione la opción de salir.
	 * Cierra la conexión a la base de datos antes de regresar al menú de inicio de sesión.
	 */
	public void menuDirector() {
		
		int opcion = 0;

		do {
			System.out.println("\n--- Menú de Director ---");
			System.out.println("1. Gestión del Centro");
			System.out.println("2. Listados del Centro");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.print("Seleccione una opción: ");
			opcion = lectura.nextInt();
			

			
			try {
				switch (opcion) {
				case 1:		
					System.out.println("Gestión del Centro");
					menuGestionTabla();
					break;
				case 2:
					System.out.println("Listados del Centro");
					menuListado();
					break;
				case 0:
					System.out.println("Saliendo del menu Director\n");
					cerrarConexion(conec);
					menuUsuario();
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);

		
	}
	/**
	 * Muestra un menú de gestión para una tabla específica.
	 * Solicita al usuario que seleccione el tipo de gestión que desea realizar.
	 * Realiza la acción correspondiente según la opción seleccionada.
	 * Si la tabla es "alumnos" y se selecciona la opción de añadir datos, también solicita la matrícula del alumno ya que la tabla matricula lleva el id del alumno y el del curso .
	 * Si se selecciona la opción de añadir datos para la tabla "alumnos", también se solicita la matrícula del alumno.
	 * Si se selecciona la opción 0, muestra un mensaje de salida.
	 * Si se selecciona una opción no válida, muestra un mensaje de error.
	 * tambien puede hacer una consulta en especifico, una actulizacion de un registro de la tabla seleccionando la tabla y la columna a actualizar y eliminar 
	 * @param nombreTabla el nombre de la tabla sobre la cual se realizará la gestión
	 */
	public void menuGestion(String nombreTabla) {
		System.out.println("¿Qué tipo de gestión desea hacer?");
		System.out.println("1. Consulta");
		System.out.println("2. Actualización");
		System.out.println("3. Eliminación");
		System.out.println("4. Añadir");
		System.out.println("0. Salir");

		int opcion = lectura.nextInt();
		

		switch (opcion) {
		case 1:
			consultarDatos(nombreTabla);
			break;
		case 2:
			actualizarDatos(nombreTabla);
			break;
		case 3:
			eliminarDatos(nombreTabla);
			break;
		case 4:
			aniadirDatos(nombreTabla);
			if (nombreTabla.equals("alumnos")) {
				aniadirMatricula();
			}
			break;
		case 0:
			System.out.println("Saliendo del menú de gestión...");
			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}
	}
	/**
	 * Permite añadir una matrícula de un alumno en un curso.
	 * Solicita al usuario que indique el curso en el que se va a matricular el alumno.
	 * Obtiene el último ID de alumno en la tabla "alumnos".
	 * Realiza la inserción de la matrícula en la tabla "matricula" con los datos proporcionados.
	 * Imprime un mensaje de éxito después de realizar la inserción.
	 * Si ocurre una excepción SQLException, imprime el stack trace del error.
	 */
	public void aniadirMatricula () {
		Statement consulta;
		try {
			consulta = conec.createStatement();
			String insert="";
			System.out.println("indica el curso en el que se va ha matricular el alumno");
			int cursoaux= lectura.nextInt();
			int idalumno = ultimoIdAlumno("alumnos");
			insert = "insert into matricula (id_curso , id_alumnos) values ("+cursoaux+","+idalumno+")";
			consulta.executeUpdate(insert);
			System.out.println("Datos añadidos con éxito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * Muestra un menú de gestión para una tabla específica.
	 * Solicita al usuario que seleccione el tipo de gestión que desea realizar.
	 * Realiza la acción correspondiente según la opción seleccionada.
	 * Si la tabla es "alumnos" y se selecciona la opción de añadir datos, también solicita la matrícula del alumno.
	 * Si se selecciona la opción de añadir datos para la tabla "alumnos", también se solicita la matrícula del alumno.
	 * Si se selecciona la opción 0, muestra un mensaje de salida.
	 * Si se selecciona una opción no válida, muestra un mensaje de error.
	 *
	 * 
	 */
	public void menuGestionTabla() {
		int opcionaux=0;
		do {
			System.out.println("\n--- Menú de Gestion ---");
			System.out.println("1. Gestión de Alumnos");
			System.out.println("2. Gestión de Personal");
			System.out.println("3. Gestión de Materias");
			System.out.println("4. Gestión de Aulas");
			System.out.println("5. Gestión de Cursos");
			System.out.println("6. Gestión de Notas");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.println("Seleccione la tabla que quiere gestionar: ");
			opcionaux = lectura.nextInt();
			

			// Realizar acciones según la opción seleccionada
			try {
				switch (opcionaux) {
				case 1:
					menuGestion("alumnos");
					break;
				case 2:
					// Acciones para la gestión de Personal
					menuGestion("personal");
					break;
				case 3:
					// Acciones para la gestión de Materias
					menuGestion("materias");
					break;
				case 4:
					// Acciones para la gestión de Aulas
					menuGestion("aula");
					break;
				case 5:
					// Acciones para la gestión de Cursos
					menuGestion("cursos");
					break;
				case 6:
					// Acciones para la gestión de Notas
					menuGestion("notas");
					break;
				case 0:
					
					System.out.println("Saliendo del programa...");
					
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcionaux != 0);

		
	}
	/**
	 * Realiza la inserción de nuevos datos en la tabla especificada.
	 * Solicita al usuario que ingrese los valores para las columnas correspondientes.
	 * Inserta el nuevo registro en la tabla.
	 * Muestra un mensaje de éxito después de la inserción.
	 * ResultSetMetaData metadata = resultSet.getMetaData(); nos recorre toda la base de datos aunque en este metodo no lo usamos podria sobrar la variable.
	 * @param nombreTabla el nombre de la tabla en la cual se insertarán los datos
	 */
	public void aniadirDatos(String nombreTabla) {
		Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para insertar es sobre la tabla: " + nombreTabla);

	        String consulta = "SELECT * FROM " + nombreTabla;
	        Statement statement = conec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet resultSet = statement.executeQuery(consulta);
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int contarColumnas = metadata.getColumnCount();

	        // Crear un nuevo registro en el ResultSet
	        resultSet.moveToInsertRow();

	        // Solicitar los valores para las columnas
	        for (int i = 1; i <= contarColumnas; i++) {
	            String columna = metadata.getColumnName(i);
	            System.out.println("Ingrese el valor para la columna '" + columna + "':");
	            String nuevoValor = lectura.next();
	            resultSet.updateString(i, nuevoValor);
	        }

	        // Insertar el nuevo registro en la tabla
	        resultSet.insertRow();

	        System.out.println("Registro insertado con éxito");

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        cerrarConexion(conec);
	    }
	}
	/**
	 * Realiza una consulta en la tabla especificada para obtener el valor de una columna en base al ID proporcionado.
	 * Solicita al usuario que ingrese el ID y el nombre de la columna a consultar.
	 * Ejecuta la consulta y muestra el valor de la columna correspondiente.
	 * Si no se encuentra ningún registro con el ID especificado, muestra un mensaje de error.
	 *
	 * @param nombreTabla el nombre de la tabla en la cual se realizará la consulta
	 */
	public void consultarDatos(String nombreTabla) {
	    Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para consultar es sobre la tabla: " + nombreTabla);

	        System.out.println("Introduzca el ID que desea consultar:");
	        int idConsulta = lectura.nextInt();

	        System.out.println("Introduzca el nombre de la columna que desea consultar:");
	        String columnaConsulta = lectura.next();

	        String consulta = "SELECT " + columnaConsulta + " FROM " + nombreTabla + " WHERE cod_alumno = ?";
	        PreparedStatement statement = conec.prepareStatement(consulta);
	        statement.setInt(1, idConsulta);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            Object valor = resultSet.getObject(1);
	            System.out.println("Columna: " + columnaConsulta + " Dato: " + valor);
	        } else {
	            System.out.println("No se encontró ningún registro con el ID especificado.");
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        cerrarConexion(conec);
	    }
	}
	/**
	 * Realiza la actualización de un registro en la tabla especificada.
	 * Solicita al usuario que ingrese el ID del registro a actualizar, el nombre de la columna
	 * que se desea actualizar y el nuevo valor para esa columna.
	 * Realiza la actualización en la tabla y muestra un mensaje de éxito.
	 * Si no se encuentra una columna autoincremental en la tabla, muestra un mensaje de error.
	 * Usamos metadata para sacar el nombre de la columna con la primary key.
	 * @param nombreTabla el nombre de la tabla en la cual se realizará la actualización
	 */
	public void actualizarDatos(String nombreTabla) {
	    Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para actualizar es sobre la tabla: " + nombreTabla);

	        System.out.println("Introduce el ID que desea actualizar:");
	        int idActualizar = lectura.nextInt();
	        lectura.nextLine(); // Limpiar el búfer del teclado
	        System.out.println("Escriba el nombre de la columna que desea actualizar:");
	        String columnaActualizar = lectura.next();
	        System.out.println("Ingrese el nuevo valor para la columna '" + columnaActualizar + "':");
	        String nuevoValor = lectura.next();

	        String consulta = "SELECT * FROM " + nombreTabla;
	        Statement statement = conec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet resultSet = statement.executeQuery(consulta);
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int contarColumnas = metadata.getColumnCount();
	        String nombreColumnaID = null;
			/*usamos ResultSetMetaData para recorrer nuestra bbdd, contamos el numero de columnas que tiene
	        nuestra bbdd hacemos un for para que se pare en la primera columna que tenga una columna autoincrement (las primarykeys) y nos que damo con el nombre de la columna con la primary key y paramos el bucle for*/
	        for (int i = 1; i <= contarColumnas; i++) {
	            if (metadata.isAutoIncrement(i)) {
	                nombreColumnaID = metadata.getColumnName(i);
	                break;
	            }
	        }

	        if (nombreColumnaID == null) {
	            System.out.println("No se encontró una columna autoincremental en la tabla.");
	            return;
	        }

	        while (resultSet.next()) {
	            int idActual = resultSet.getInt(nombreColumnaID);

	            if (idActual == idActualizar) {
	                resultSet.updateString(columnaActualizar, nuevoValor);
	                resultSet.updateRow();
	                System.out.println("Registro actualizado con éxito");
	            }
	        }

	        System.out.println("Datos actualizados con éxito");

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        cerrarConexion(conec);
	    }
	}
	/**
	 * Realiza la eliminación de un registro en la tabla especificada.
	 * Solicita al usuario que ingrese el ID del registro a eliminar.
	 * Verifica si existen restricciones de clave externa (FK) en otras tablas antes de eliminar el registro.
	 * Si existen restricciones de clave externa, muestra un mensaje indicando que el registro no puede ser eliminado
	 * hasta que se eliminen las restricciones relacionadas.
	 * Si no existen restricciones de clave externa, procede a eliminar el registro y muestra un mensaje de éxito.
	 * Usamos metadata para sacar el nombre de la columna con la primary key.
	 * @param nombreTabla el nombre de la tabla en la cual se realizará la eliminación
	 */
	public void eliminarDatos(String nombreTabla) {  //el metodo funciona perfectamente pero en la taba alumnos al tener la tabla matriculas de por medio te avisa de que no puedes borrar el registro por que tiene la fk con matriculas habriaque borrar primero la fk de la tabla matricula y luego borrar el alumno
	    Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para eliminar es sobre la tabla: " + nombreTabla);

	        System.out.println("Introduce el ID del registro que deseas eliminar:");
	        int idEliminar = lectura.nextInt();
	        lectura.nextLine(); // Limpiar el búfer del teclado

	        String consulta = "SELECT * FROM " + nombreTabla;
	        Statement statement = conec.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet resultSet = statement.executeQuery(consulta);
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int contarColumnas = metadata.getColumnCount();
	        String nombreColumnaID = null;
	        /*usamos ResultSetMetaData para recorrer nuestra bbdd, contamos el numero de columnas que tiene
	        nuestra bbdd hacemos un for para que se pare en la primera columna que tenga una columna autoincrement (las primarykeys) y nos que damo con el nombre de la columna con la primary key y paramos el bucle for*/
	        for (int i = 1; i <= contarColumnas; i++) {
	            if (metadata.isAutoIncrement(i)) {
	                nombreColumnaID = metadata.getColumnName(i);
	                break;
	            }
	        }

	        if (nombreColumnaID == null) {
	            System.out.println("No se encontró una columna autoincremental en la tabla.");
	            return;
	        }

	        while (resultSet.next()) {
	            int idActual = resultSet.getInt(nombreColumnaID);

	            if (idActual == idEliminar) {
	                resultSet.deleteRow();
	                System.out.println("Registro eliminado con éxito");
	                break;
	            }
	        }

	        System.out.println("Datos eliminados con éxito");

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        cerrarConexion(conec);
	    }
	}
	/**
	 * Obtiene el último ID de alumno registrado en la tabla especificada.
	 * Realiza una consulta para obtener el máximo valor de la columna "cod_alumno".
	 *
	 * @param tabla el nombre de la tabla en la que se buscará el último ID de alumno
	 * @return el último ID de alumno registrado en la tabla, 0 si no se encontraron registros o ocurrió un error
	 */
	public int ultimoIdAlumno(String tabla) {
        int id = 0;
        if (conec != null) {
            try {
                String baseconsulta = "SELECT MAX(cod_alumno) FROM " + tabla;
                Statement consulta = conec.createStatement();
                ResultSet salida = consulta.executeQuery(baseconsulta);

                if (salida.next()) {
                    id = salida.getInt(1);
                }

                salida.close();
                consulta.close();
            } catch (SQLException e) {
                System.err.println("Se ha producido un error al obtener los registros.\n" + e);
            }
        }
        return id;
    }
	/**
	 * Muestra el menú de listado y permite al usuario seleccionar una tabla para visualizar.
	 * Realiza acciones según la opción seleccionada por el usuario.
	 */
	public void menuListado() {
		int opcionaux=0;
		do {
			System.out.println("\n--- Menú de Listado ---");
			System.out.println("1. Listado de Alumnos");
			System.out.println("2. Listado de Personal");
			System.out.println("3. Listado de Materias");
			System.out.println("4. Listado de Aulas");
			System.out.println("5. Listado de Cursos");
			System.out.println("6. Listado de Notas");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.println("Seleccione la tabla que quiere visualizar: ");
			opcionaux = lectura.nextInt();
			

			// Realizar acciones según la opción seleccionada
			try {
				switch (opcionaux) {
				case 1:
					listado("alumnos");
					break;
				case 2:
					// Acciones para la gestión de Personal
					listado("personal");
					break;
				case 3:
					// Acciones para la gestión de Materias
					listado("materias");
					break;
				case 4:
					// Acciones para la gestión de Aulas
					listado("aula");
					break;
				case 5:
					// Acciones para la gestión de Cursos
					listado("cursos");
					break;
				case 6:
					// Acciones para la gestión de Notas
					listado("notas");
					break;
				case 0:
					
					System.out.println("Saliendo del programa...");
					
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcionaux != 0);
	}
	/**
	 * Muestra el menú de listado y permite al usuario seleccionar una tabla para visualizar.
	 * Realiza acciones según la opción seleccionada por el usuario.
	 * @param nombreTabla recibe el nombre de la tabla que tiene que hacer el listado
	 */
	public void listado(String nombreTabla) {
		Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para consultar es sobre la tabla: " + nombreTabla);

	        String consulta = "SELECT * FROM " + nombreTabla;
	        Statement statement = conec.createStatement();
	        ResultSet resultSet = statement.executeQuery(consulta);
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int contarColumnas = metadata.getColumnCount();

	        while (resultSet.next()) {
	            for (int i = 1; i <= contarColumnas; i++) {
	                String columna = metadata.getColumnName(i);
	                String valor = resultSet.getString(i);
	                System.out.printf("%-15s: %s%n", columna, valor);
	            }
	            System.out.println();
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        System.out.println("Sin errores en la consulta");
	    }
	}
	/**
	 * Muestra el menú de opciones para el rol de Secretaría.
	 * Permite seleccionar entre diferentes opciones de gestión y listados del centro.
	 * La función se ejecuta en un bucle hasta que se seleccione la opción de salida.
	 */
	public void menuSecretaria() {
		int opcion = 0;

		do {
			System.out.println("\n--- Menú de Secretaría ---");
			System.out.println("1. Gestión del Centro");
			System.out.println("2. Listados del Centro");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.print("Seleccione una opción: ");
			opcion = lectura.nextInt();
			

			
			try {
				switch (opcion) {
				case 1:		
					System.out.println("Gestión del Centro");
					menuGestionSecretario();
					break;
				case 2:
					System.out.println("Listados del Centro");
					menuListadoSecretario();
					break;
				case 0:
					System.out.println("Saliendo del menu secretaría\n");
					cerrarConexion(conec);
					menuUsuario();
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);
	}
	/**
	 * Muestra el menú de opciones de gestión para el rol de Secretaría.
	 * Permite seleccionar entre diferentes opciones de gestión de alumnos, matrículas, notas y aulas.
	 * La función se ejecuta en un bucle hasta que se seleccione la opción de salida.
	 */
	public void menuGestionSecretario() {
		int opcionaux=0;
		do {
			System.out.println("\n--- Menú de Gestion ---");
			System.out.println("1. Alta de Alumnos");
			System.out.println("2. Modificacion de alumno");
			System.out.println("3. Matriculas");
			System.out.println("4. Insertar notas");
			System.out.println("5. Gestión de Aulas");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.println("Seleccione su gestion por favor :");
			opcionaux = lectura.nextInt();
			
			try {
				switch (opcionaux) {
				case 1:
					aniadirDatos("alumnos");
					break;
				case 2:
					actualizarDatos("personal");
					break;
				case 3:
					int opcionm=0;
					System.out.println("1. Insertar Matricula");
					System.out.println("2. Actualizar Matricula");
					System.out.println("3. Elminiar Matricula");
					System.out.println("4. Consultar Matriculas");
					System.out.println("Seleccione una opcion :");
					opcionm=lectura.nextInt();
					if (opcionm==1) {
						aniadirDatos("matricula");
					}else if (opcionm==2) {
						actualizarDatos("matricula");
					}else if (opcionm==3) {
						eliminarDatos("matricula");
					}else if (opcionm==4){
						listado("matricula");
					}else System.out.println("Introduzca una opcion correcta");
					break;
				case 4:
					aniadirDatos("notas");
					break;
					
				case 5:
					int opciona=0;
					System.out.println("1. Insertar Aula");
					System.out.println("2. Actualizar Aula");
					System.out.println("3. Elminiar Aula");
					System.out.println("4. Consultar Aulas");
					System.out.println("Seleccione una opcion :");
					opciona=lectura.nextInt();
					if (opciona==1) {
						aniadirDatos("aula");
					}else if (opciona==2) {
						actualizarDatos("aula");
					}else if (opciona==3) {
						eliminarDatos("aula");
					}else if (opciona==4){
						listado("aula");
					}else System.out.println("Introduzca una opcion correcta");
					break;
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcionaux != 0);
	}
	/**
	 * Muestra el menú de opciones de listado para el rol de Secretaría.
	 * Permite seleccionar entre diferentes opciones de listado de alumnos y materias.
	 * La función se ejecuta en un bucle hasta que se seleccione la opción de salida.
	 */
	public void menuListadoSecretario() {
		int opcionaux=0;
		do {
			System.out.println("\n--- Menú de Listado ---");
			System.out.println("1. Listado de Alumnos");
			System.out.println("2. Listado de Materias");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.println("Seleccione la tabla que quiere visualizar: ");
			opcionaux = lectura.nextInt();
			

			// Realizar acciones según la opción seleccionada
			try {
				switch (opcionaux) {
				case 1:
					listado("alumnos");
					break;
				case 2:
					// Acciones para la gestión de Personal
					listado("materias");
					break;
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcionaux != 0);
	}
	/**
	 * Muestra el menú de opciones para el rol de Profesor.
	 * Permite realizar consultas de datos de alumnos y materias, consultar los datos del propio profesor
	 * y acceder al listado de alumnos.
	 * La función se ejecuta en un bucle hasta que se seleccione la opción de salida.
	 */	
	public void menuProfesor() {
		int opcion = 0;

		do {
			System.out.println("\n--- Menú de Profesor ---");
			System.out.println("1. Consultar datos de alumnos");
			System.out.println("2. Consultar datos de materias");
			System.out.println("3. Consultar mis datos en el sistema");
			System.out.println("4. Listado alumnos");
			System.out.println("0. Salir");
			System.out.println("-----------------------");
			System.out.print("Seleccione una opción: ");
			opcion = lectura.nextInt();
			

			
			try {
				switch (opcion) {
				case 1:		
					consultarDatos("alumnos");
					break;
				case 2:
					consultarDatos("materias");
					break;
				case 3:
					consultaProfesor("personal");
					break;
				case 4:
					listado("alumnos");
					break;
				case 0:
					System.out.println("Saliendo del menu secretaría\n");
					cerrarConexion(conec);
					menuUsuario();
					break;
				default:
					System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);
	}
	/**
	 * Realiza una consulta de los datos de un profesor en la tabla especificada.
	 * Muestra los datos del profesor cuyo ID corresponda al proporcionado por el usuario.
	 *
	 * @param nombreTabla El nombre de la tabla en la base de datos donde se encuentran los datos del profesor.
	 *                    Debe ser "personal" en este caso.
	 */
	public void consultaProfesor(String nombreTabla) {
	    Connection conec = conectarBBDD();
	    try {
	        System.out.println("Su gestión para consultar es sobre la tabla: " + nombreTabla);

	        System.out.println("Introduzca el id_personal que desea consultar:");
	        int idPersonal = lectura.nextInt();
	        lectura.nextLine(); // Limpiar el búfer del teclado

	        String consulta = "SELECT * FROM " + nombreTabla + " WHERE id_personal = " + idPersonal;
	        Statement statement = conec.createStatement();
	        ResultSet resultSet = statement.executeQuery(consulta);
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int contarColumnas = metadata.getColumnCount();

	        while (resultSet.next()) {
	            for (int i = 1; i <= contarColumnas; i++) {
	                String columna = metadata.getColumnName(i);
	                String valor = resultSet.getString(i);
	                System.out.printf("%-15s: %s%n", columna, valor);
	            }
	            System.out.println();
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage().toString());
	    } finally {
	        cerrarConexion(conec);
	    }
	}
	
}
