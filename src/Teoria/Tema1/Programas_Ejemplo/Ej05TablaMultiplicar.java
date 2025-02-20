package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej05TablaMultiplicar {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int número = entrada.nextInt();
        System.out.println("Tabla del " + número);
        for (int i = 1; i <= 10; i++)
            System.out.println(número + " x " + i + " = " + número * i);
    }

}
