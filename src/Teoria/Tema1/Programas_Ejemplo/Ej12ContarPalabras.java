package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej12ContarPalabras {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce una frase (cadena vacía para acabar): ");
        String frase = entrada.nextLine();
        while (frase.length() > 0) {
            System.out.println("Nº de palabras de \"" + frase + "\" = " + contarPalabras(frase));
            System.out.print("Introduce otra frase (cadena vacía para acabar): ");
            frase = entrada.nextLine();
        }

    }

    // Devuelve la cantidad de palabras de la cadena dada
    private static int contarPalabras(String cadena) {
        int cantidad = 0;
        char anterior = ' ';
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ' && anterior == ' ')  // Inicio de palabra
                cantidad++;
            anterior = cadena.charAt(i);
        }
        return cantidad;
    }

}


// Puedes tratar de implementar las otras versiones vistas en Python
