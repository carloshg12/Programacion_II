package Practicas.Practica1.Ejercicio2;

import java.util.Scanner;

public class DobleFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();

        long resultado = calcularDobleFactorial(n);

        System.out.println(n + "!! = " + resultado);
    }

    public static long calcularDobleFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long resultado = 1;
        int inicio = (n % 2 == 0) ? 2 : 1;

        for (int i = inicio; i <= n; i += 2) {
            resultado *= i;
        }

        return resultado;
    }
}