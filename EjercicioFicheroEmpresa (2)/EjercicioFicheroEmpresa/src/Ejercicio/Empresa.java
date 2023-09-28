package Ejercicio;

import java.io.*;

public class Empresa {
    private String nombre;
    private int tamaño;
    private Empleado[] empleados;
    private int contador;

    public Empresa(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.empleados = new Empleado[tamaño];
        this.contador = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Empleado getEmpleado(int numEmpleado) {
        if (numEmpleado >= 0 && numEmpleado < tamaño) {
            return empleados[numEmpleado];
        } else {
            return null;
        }
    }

    public void despideEmpleado(int numEmpleado) {
        if (numEmpleado >= 0 && numEmpleado < tamaño) {
            empleados[numEmpleado] = null;
        }
    }

    public void nuevoEmpleado(String nombre, int sueldo) {
        if (contador < tamaño) {
            Empleado empleado = new Empleado(this, nombre, sueldo, contador);
            empleados[contador] = empleado;
            contador++;
            try {
                FileOutputStream fileOut = new FileOutputStream("MisEmpleados.dat", true);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(empleado);
                out.close();
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pueden agregar más empleados, la empresa está llena.");
        }
    }
}
