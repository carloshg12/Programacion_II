package Examenes.Control1;

import java.util.Arrays;

public class RepetidosVector {

    //Y ahora que se use ese metodo para q pasado una cadena de vectores me devuelva a como
    //resultado un nuevo vector que contenga todos los repetidos, inicialmente debe contar el n´umero de
    //repetidos del vector dado para poder crear el vector resultante con el tama˜no adecuado.
    public static void main(String[] args) {
        // Vector de prueba
        String[] palabras = {"hola", "programar", "abc", "teclado", "elefante"};
        // Extraer palabras con caracteres repetidos
        String[] repetidos = extraerRepetidos(palabras);
        // Imprimir resultado
        System.out.println(Arrays.toString(repetidos));
    }

    // Método que verifica si una cadena tiene caracteres repetidos
    public static boolean hayRepetidos(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = i + 1; j < cadena.length(); j++) {
                if (cadena.charAt(i) == cadena.charAt(j)) {
                    return true; // Si hay repetidos, devuelve true
                }
            }
        }
        return false; // Si no hay repetidos, devuelve false
    }

    // Método que extrae todas las cadenas con caracteres repetidos
    public static String[] extraerRepetidos(String[] vector) {
        // Contar cuántos elementos tienen caracteres repetidos
        int contador = 0;
        for (String palabra : vector) {
            if (hayRepetidos(palabra)) {
                contador++;
            }
        }

        // Crear un nuevo array con el tamaño exacto
        String[] repetidos = new String[contador];

        // Rellenar el nuevo array con las palabras que tienen caracteres repetidos
        int index = 0;
        for (String palabra : vector) {
            if (hayRepetidos(palabra)) {
                repetidos[index++] = palabra;
            }
        }

        return repetidos;
    }
}
