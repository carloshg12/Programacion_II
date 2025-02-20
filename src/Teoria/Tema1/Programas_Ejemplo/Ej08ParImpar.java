package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej08ParImpar {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un número entero: ");
        int n = entrada.nextInt();
        System.out.println("Es " + (n % 2 == 0 ? "par" : "impar"));
    }

}
