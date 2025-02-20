package Teoria.Tema1.Programas_Ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej18ContarLineas {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = entrada.next();
        int cantidadLíneas = contarLíneas(nombreFichero);
        System.out.println("El fichero tiene " + cantidadLíneas + " líneas");
    }

    private static int contarLíneas(String nombreFichero) throws FileNotFoundException {
        int cantidad = 0;  // Cantidad de líneas
        Scanner entrada = new Scanner(new File(nombreFichero));
        while (entrada.hasNextLine()) {
            String línea = entrada.nextLine();
            cantidad++;
        }
        entrada.close();
        return cantidad;
    }

}
