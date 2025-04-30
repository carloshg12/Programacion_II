package Practicas.Practica3.Ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalabraMasFrecuente {
    public static void main(String[] args) {
        String nombreFichero = "src/Practicas/Practica3/Ejercicio5/AlicesAdventuresInWonderland.txt";
        Diccionario contadorPalabras = new Diccionario();

        try (Scanner scanner = new Scanner(new File(nombreFichero))) {
            // Leer el archivo palabra por palabra
            while (scanner.hasNext()) {
                String palabra = scanner.next();
                contadorPalabras.añadir(palabra, 1);
            }

            // Obtener y mostrar resultados
            String palabraMasFrecuente = contadorPalabras.cadenaConMayorCantidad();
            int frecuencia = contadorPalabras.cantidad(palabraMasFrecuente);

            System.out.printf("La palabra más frecuente en %s es «%s» con %d apariciones.%n",
                    nombreFichero, palabraMasFrecuente, frecuencia);

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo encontrar el archivo " + nombreFichero);
            System.out.println("Asegúrese de que el archivo está en el mismo directorio que el programa.");
        }
    }
}