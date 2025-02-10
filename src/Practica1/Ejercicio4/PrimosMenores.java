package Practica1.Ejercicio4;

import Practica1.Ejercicio3.EsPrimo;

import java.util.Scanner;

public class PrimosMenores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int n = sc.nextInt();

        System.out.print("Los números primos menores que " + n + " son: ");
        for (int i = 2; i < n; i++) { // Comenzamos desde 2, ya que 1 no es primo
            if (EsPrimo.esPrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
