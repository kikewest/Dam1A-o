package Ejercicio;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String nombre;
    protected int sueldo;
    protected final int numEmpleado;

    public Empleado(Empresa empresa, String nombre, int sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.numEmpleado = empresa.nuevoEmpleado(this);
    }

    protected Empleado(Empresa empresa, String nombre, int sueldo, int numEmpleado) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.numEmpleado = numEmpleado;
        empresa.nuevoEmpleado(this);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String toString() {
        return "Empleado " + numEmpleado + ": " + nombre + " (" + sueldo + " €)";
    }

    public final void aumentarSueldo(int porcentaje) {
        sueldo += sueldo * porcentaje / 100;
    }

    public void despedir(Empresa empresa) {
        empresa.despideEmpleado(numEmpleado);
        actualizarFichero(empresa);
    }

    private void actualizarFichero(Empresa empresa) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("MisEmpleados.dat"));
            out.writeObject(empresa);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
