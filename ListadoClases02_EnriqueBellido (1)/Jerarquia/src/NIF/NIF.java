package NIF;
import java.util.*;
public class NIF {
	//atributos
	private int dni;
    private char letra;

    //Constructores


    public NIF(int dni) {
        this.dni = dni;
        letra = calcularLetra();
    }

    //Métodos
    private char calcularLetra() {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                         'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};                      
        return letras[dni % 23];
    }

    
    public void leer() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce dni: ");
            dni = sc.nextInt();
        } while (dni <= 0);
        letra = calcularLetra();
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dni);
        sb.append("-");
        sb.append(letra);
        return sb.toString();
    }

}

