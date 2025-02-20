package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej09ContarDigitos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un número: ");

        // Calcular la cantidad de dígitos del número dado
        int número = entrada.nextInt();
        int n = Math.abs(número);
        int dígitos = 0;
        do {
            dígitos++;
            n /= 10;
        } while (n > 0);

        System.out.println("Nº dígitos de " + número + " = " + dígitos);

    }

}
