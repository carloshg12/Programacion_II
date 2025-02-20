package Teoria.Tema1.Programas_Ejemplo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ej19CrearFicheroRaices {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Cuántas raíces cuadradas quieres obtener? ");
        int cantidad = entrada.nextInt();
        System.out.print("¿En qué fichero quieres almacenar los resultados? ");
        String nombreFichero = entrada.next();
        crearFicheroRaícesCuadradas(cantidad, nombreFichero);
    }

    // Crea un fichero con las raíces cuadradas de los números de 1 a n
    private static void crearFicheroRaícesCuadradas(int n, String nombreFichero)
            throws FileNotFoundException {
        Formatter salida = new Formatter(new File(nombreFichero));
        for (int i = 1; i <= n; i++)
            salida.format("Raíz cuadrada de %d = %.3f %n", i, Math.sqrt(i));
        salida.close();
    }

}
