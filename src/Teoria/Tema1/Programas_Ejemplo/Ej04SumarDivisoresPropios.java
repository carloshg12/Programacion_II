package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej04SumarDivisoresPropios {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int número = entrada.nextInt();

        // Sumar los divisores propios del número
        int sumaDivisores = 0;
        int candidatoDivisor = 1;
        while (candidatoDivisor <= número / 2) {
            if (número % candidatoDivisor == 0)  // Divisor
                sumaDivisores += candidatoDivisor;
            candidatoDivisor += 1;
        }

        System.out.println("La suma de los divisores propios de " + número + " es " + sumaDivisores);
    }

}
