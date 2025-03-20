package Examenes.Control1;

public class Repetidos {

    //Escribe un método hayrepetidos el cual dada una cadena te devuelva true si hay repito dos o false si no
    public static void main(String[] args) {
        // Ejemplos de prueba
        System.out.println(hayRepetidos("hola"));       // true (la 'o' y la 'l' no se repiten)
        System.out.println(hayRepetidos("programar"));  // true (la 'r' aparece más de una vez)
        System.out.println(hayRepetidos("abc"));        // false (todos los caracteres son únicos)
    }

    public static boolean hayRepetidos(String cadena) {
        // Convertir la cadena a un array de caracteres
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = i + 1; j < cadena.length(); j++) {
                if (cadena.charAt(i) == cadena.charAt(j)) {
                    return true; // Hay un caracter repetido
                }
            }
        }
        return false; // No hay caracteres repetidos
    }
}
