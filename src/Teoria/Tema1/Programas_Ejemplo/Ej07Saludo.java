package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej07Saludo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("¡Hola, " + nombre + "!");
    }

}
