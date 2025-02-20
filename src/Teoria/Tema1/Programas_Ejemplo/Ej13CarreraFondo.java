package Teoria.Tema1.Programas_Ejemplo;

import java.util.Arrays;

public class Ej13CarreraFondo {

    public static void main(String[] args) {
        // Ejemplo de programa principal (vector de alturas concreto)
        int[] alturas = {1000, 1000, 950, 1025, 1050, 1100, 975, 1025, 1075, 1125, 1175, 1250, 1200};

        int[] desniveles = calcularDesniveles(alturas);
        System.out.println("Desniveles: " + Arrays.toString(desniveles));
        System.out.println("Nº tramos de subida: " + cantidadTramosSubida(desniveles));
    }

    // Devuelve el vector de desniveles correspondiente al vector de alturas dado
    private static int[] calcularDesniveles(int[] alturas) {
        int[] desniveles = new int[alturas.length - 1];
        for (int i = 0; i < desniveles.length; i++)
            desniveles[i] = alturas[i + 1] - alturas[i];
        return desniveles;
    }

    // Devuelve la cantidad de tramos de subida que hay en el vector de desniveles
    private static int cantidadTramosSubida(int[] desniveles) {
        int tramos = 0, seguidos = 0;
        for (int valor : desniveles)
            if (valor > 0) seguidos++;
            else {
                if (seguidos > 0) tramos++;
                seguidos = 0;
            }
        if (seguidos > 0) tramos++;
        return tramos;
    }

}
