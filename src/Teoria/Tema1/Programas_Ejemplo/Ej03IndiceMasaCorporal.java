package Teoria.Tema1.Programas_Ejemplo;

import java.util.Scanner;

public class Ej03IndiceMasaCorporal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce la altura (en metros): ");
        double altura = entrada.nextDouble();
        System.out.print("Introduce el peso (en kilos): ");
        double peso = entrada.nextDouble();  // Utiliza la coma (y no el punto) como separador de la parte decimal
        double imc = peso / (altura * altura);
        System.out.println("El IMC es " + imc);
    }

}
