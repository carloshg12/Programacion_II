package Practica1.Ejercicio1;

import java.util.Scanner;

public class EnteroFactorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero entero");
        int numero = sc.nextInt();

        long resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        System.out.println(resultado);

    }
}
