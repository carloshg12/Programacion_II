package Teoria.Tema4.Programas_Ejemplo;

import java.util.Arrays;
import java.util.Random;

public class Ej11PruebaTiemposBusqueda {
    public static void main(String[] args) {
        int SIZE = 1000000;
        int STEP = 50;

        int[] ordenado = creaVectorOrdenado(SIZE, STEP);
        //System.out.println("Vector ordenado:" + Arrays.toString(ordenado));

        int vector[] = creaVector(SIZE, ordenado[ordenado.length - 1]+1);
        //System.out.println("Valores a buscar: " + Arrays.toString(vector));

        long inicio = System.currentTimeMillis();
        int encontrados = 0;
        for (int i: vector)
            if (Ej06BusquedaBinaria.búsquedaBinaria(ordenado, i)>=0) // Método de búsqueda a utilizar
                encontrados++;
        long fin = System.currentTimeMillis();
        System.out.println("Buscados " + vector.length + " elementos. Encontrados " + encontrados);
        System.out.println("Tiempo empleado: " + (fin - inicio) + " ms.");
    }

    public static int[] creaVector(int size, int max) {
        Random rnd = new Random(0); // Para generar siempre la misma secuencia
        int[] v = new int[size];
        for (int i = 0; i < v.length; i++) {
            v[i] = rnd.nextInt(max);
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
