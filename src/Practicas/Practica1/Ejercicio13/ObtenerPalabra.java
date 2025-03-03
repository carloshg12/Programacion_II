package Practicas.Practica1.Ejercicio13;

import java.util.Scanner;

public class ObtenerPalabra {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();

        System.out.println("Introduce un número:");
        int numero = sc.nextInt();

        String palabra = obtenerPalabra(cadena, numero);
        if (palabra == null) {
            System.out.println("El número no es válido.");
        } else {
            System.out.println("La palabra obtenida es: " + palabra);
        }
    }

    public static String obtenerPalabra(String cadena, int numero) {
        int numeroPalabras = 0;
        int inicioPalabra = -1;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {  // Si es un carácter no espacio
                if (inicioPalabra == -1) {  // Detectar el inicio de una nueva palabra
                    inicioPalabra = i;
                    numeroPalabras++;
                    if (numeroPalabras == numero) {  // Si llegamos a la palabra deseada
                        // Encontrar el final de la palabra
                        int finPalabra = i;
                        while (finPalabra < cadena.length() && cadena.charAt(finPalabra) != ' ') {
                            finPalabra++;
                        }
                        return cadena.substring(inicioPalabra, finPalabra);
                    }
                }
            } else {  // Si encontramos un espacio
                inicioPalabra = -1;  // Reiniciar el inicio de palabra
            }
        }

        return null;  // Si el número es inválido
    }
}
