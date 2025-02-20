package Teoria.Tema1.Programas_Ejemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ej20CrearFicheroMorosos {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Nombre del fichero de entrada? ");
        String nombreFicheroEntrada = entrada.next();
        System.out.print("¿Nombre del fichero de salida? ");
        String nombreFicheroSalida = entrada.next();
        crearFicheroMorosos(nombreFicheroEntrada, nombreFicheroSalida);
    }

    private static void crearFicheroMorosos(String nombreFicheroEntrada,
                                            String nombreFicheroSalida)
            throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(nombreFicheroEntrada));
        Formatter salida = new Formatter(new File(nombreFicheroSalida));
        while (entrada.hasNext()) {
            String dni = entrada.next();
            double saldo = entrada.nextDouble();
            String nombre = entrada.nextLine().trim();  // Sin espacios iniciales ni finales
            if (saldo < 0) salida.format("%s %10.2f %s%n", dni, saldo, nombre);
        }
        salida.close();
        entrada.close();
    }

}
