package Practicas.Practica1.Ejercicio11;

public class Ejercicio11 {

    public static void main(String[] args) {
        // Pruebas del método encaja
        prueba("r.j.", "verde", false);
        prueba("r.j.", "rojo", true);
        prueba("r.j.", "reja", true);
        prueba("r.j.", "reza", false);
        prueba("r.j.", "rrjj", false);
        prueba("r.j.", "puja", false);
    }

    // Método para verificar si una cadena encaja en un patrón
    public static boolean encaja(String patron, String cadena) {
        // Verificar que la cadena y el patrón tengan la misma longitud
        if (patron.length() != cadena.length()) {
            return false;
        }

        // Comparar cada carácter del patrón con el de la cadena
        for (int i = 0; i < patron.length(); i++) {
            char p = patron.charAt(i); // Carácter del patrón
            char c = cadena.charAt(i); // Carácter de la cadena

            if (p == '.') {
                // Si el patrón tiene '.', la cadena debe tener una vocal
                if (!esVocal(c)) {
                    return false;
                }
            } else {
                // Si el patrón tiene un carácter distinto de '.', debe coincidir con el de la cadena
                if (p != c) {
                    return false;
                }
            }
        }

        // Si todas las comparaciones son válidas, la cadena encaja en el patrón
        return true;
    }

    // Método para verificar si un carácter es una vocal
    public static boolean esVocal(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }

    // Método para probar el método encaja
    public static void prueba(String patron, String cadena, boolean esperado) {
        boolean resultado = encaja(patron, cadena);
        System.out.format("Prueba con %s y %s --> %s: ", patron, cadena, resultado);
        if (resultado == esperado) {
            System.out.println("ok");
        } else {
            System.out.format("error (se esperaba %s)%n", esperado);
        }
    }
}
