package Practicas.Practica1.Ejercicio12;

import java.util.Scanner;

public class ContarPalabras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();

        System.out.println("La cadena \"" + cadena + "\" tiene " + contarPalabras(cadena) + " palabras.");
    }

    public static int contarPalabras(String cadena) {
        int numeroPalabras = 0;
        boolean enPalabra = false;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {  // Encuentra un carácter no espacio
                if (!enPalabra) {           // Si no estábamos en una palabra
                    numeroPalabras++;       // Nueva palabra detectada
                    enPalabra = true;       // Ahora estamos dentro de una palabra
                }
            } else {                        // Si es un espacio
                enPalabra = false;          // Salimos de la palabra
            }
        }

        return numeroPalabras;
    }
}
