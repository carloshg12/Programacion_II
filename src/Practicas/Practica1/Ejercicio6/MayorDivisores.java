package Practicas.Practica1.Ejercicio6;

import java.util.Scanner;

public class MayorDivisores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();

        int numeroConMasDivisores = 1; // Almacena el número con más divisores
        int maxDivisores = 1; // Almacena la cantidad máxima de divisores encontrados

        for (int i = 1; i <= n; i++) {
            int divisores = contarDivisores(i);
            if (divisores > maxDivisores) {
                maxDivisores = divisores; // Actualizar la cantidad máxima de divisores
                numeroConMasDivisores = i; // Actualizar el número con más divisores
            }
        }

        System.out.println("El número con más divisores es " + numeroConMasDivisores +
                " (" + maxDivisores + " divisores)");
    }

    public static int contarDivisores(int numero) {
        if (numero == 1) {
            return 1;
        }

        int contador = 2; // Todos los números mayores que 1 tienen al menos 2 divisores: 1 y sí mismo
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                if (i == numero / i) {
                    contador++; // Si es un cuadrado perfecto, contar solo una vez
                } else {
                    contador += 2; // Contar ambos divisores (i y numero/i)
                }
            }
        }

        return contador;
    }
}
