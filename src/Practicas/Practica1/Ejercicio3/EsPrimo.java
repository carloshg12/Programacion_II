package Practicas.Practica1.Ejercicio3;

import java.util.Scanner;

public class EsPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int numero = sc.nextInt();

        if (esPrimo(numero)) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }
        if (numero == 2) {
            return true; // 2 es el único número par primo
        }
        if (numero % 2 == 0) {
            return false; // Si es par y mayor que 2, no es primo
        }

        // Verificar divisores desde 3 hasta la raíz cuadrada del número
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false; // Si es divisible, no es primo
            }
        }

        return true; // Si no se encontraron divisores, es primo
    }
}
