package Practicas.Practica1.Ejercicio5;

import Practicas.Practica1.Ejercicio3.EsPrimo;

import java.util.Scanner;

public class Primorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();
        long primorial = 1;

        System.out.print("El primorial de " + n + " es: ");
        for (int i = 2; i <= n; i++) {
            if (EsPrimo.esPrimo(i)) {
                primorial *= i;
            }
        }
        System.out.println(n + "# = " + primorial); // Imprimir el resultado final

    }
}
