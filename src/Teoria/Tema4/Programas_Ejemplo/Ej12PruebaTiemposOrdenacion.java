package Teoria.Tema4.Programas_Ejemplo;

import java.util.Arrays;
import java.util.Random;

public class Ej12PruebaTiemposOrdenacion {
    public static void main(String[] args) {
        int SIZE = 1000000;
        int STEP = 50;

        int vector[] = creaVector(SIZE, SIZE*STEP);
        // System.out.println("Vector desordenado: " + Arrays.toString(vector));

        System.out.println("Comienza la ordenación...");
        long inicio = System.currentTimeMillis();
        Ej10OrdenarFusion.ordenarFusión(vector); // Método de ordenación a utilizar
        long fin = System.currentTimeMillis();

        // System.out.println("Vector ordenado " + Arrays.toString(vector));
        System.out.println("Tiempo empleado: " + (fin - inicio) + " ms.");
    }

    public static int[] creaVector(int size, int maxValue) {
        Random rnd = new Random(0); // Para generar siempre la misma secuencia
        int[] v = new int[size];
        for (int i = 0; i < v.length; i++) {
            v[i] = rnd.nextInt(maxValue);
        }
        return v;
    }

    public static int[] creaVectorOrdenado(int size, int step) {
        Random rnd = new Random(0); // Para generar siempre la misma secuencia
        int[] v = new int[size];
        v[0] = 1;
        for (int i = 1; i < v.length; i++) {
            v[i] = v[i - 1] + rnd.nextInt(step);
            if (v[i] < v[i - 1])
                throw new RuntimeException("Posible desbordamiento de los enteros.");
        }
        return v;
    }

}
