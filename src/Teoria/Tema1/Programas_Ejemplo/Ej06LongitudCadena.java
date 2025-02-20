package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej06LongitudCadena {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra = entrada.next();
        System.out.println("Número de caracteres: " + palabra.length());
    }

}
