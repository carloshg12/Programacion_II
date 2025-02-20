package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej10MostrarAbundantes {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int límite = entrada.nextInt();

        mostrarAbundantesMenores(límite);
    }

    // Devuelve la suma de los divisores propios del número n
    private static int sumarDivisoresPropios(int n) {
        int suma = 0;
        for (int divisor = 1; divisor <= n / 2; divisor++)
            if (n % divisor == 0)
                suma += divisor;
        return suma;
    }

    // Devuelve true si n es un número abundante y false si no lo es
    private static boolean esAbundante(int n) {
        return n < sumarDivisoresPropios(n);
    }

    // Muestra todos los números abundantes menores que n
    private static void mostrarAbundantesMenores(int n) {
        System.out.print("Números abundantes menores que " + n + ": ");
        for (int número = 1; número < n; número++)
            if (esAbundante(número))
                System.out.print(número + " ");
        System.out.println();
    }

}
