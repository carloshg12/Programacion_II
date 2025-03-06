package Practicas.Practica1.Ejercicio23;

import Practicas.Practica1.Ejercicio16.OlasDeFrio;

public class MasOlasDeFrio {

    // Método estático para encontrar el año más reciente con más olas de frío
    public static int masOlasDeFrio(double[][] matrizTemperaturas, int n) {
        int maxOlas = -1; // Inicializamos el máximo número de olas de frío
        int añoMasReciente = -1; // Inicializamos el año más reciente con más olas de frío

        // Recorremos la matriz de temperaturas
        for (int i = 0; i < matrizTemperaturas.length; i++) {
            // Contamos las olas de frío para el año actual (fila i)
            int olasDeFrio = OlasDeFrio.contarOlasDeFrio(matrizTemperaturas[i], n);

            // Si el número de olas de frío es mayor que el máximo actual
            if (olasDeFrio > maxOlas) {
                maxOlas = olasDeFrio; // Actualizamos el máximo
                añoMasReciente = 1900 + i; // Calculamos el año (1900 + índice de la fila)
            }
            // Si el número de olas de frío es igual al máximo actual, actualizamos el año más reciente
            else if (olasDeFrio == maxOlas) {
                añoMasReciente = 1900 + i;
            }
        }

        // Si no se encontraron olas de frío, devolvemos -1
        return maxOlas > 0 ? añoMasReciente : -1;
    }

    // Método principal para probar el método masOlasDeFrio
    public static void main(String[] args) {
        // Ejemplo de matriz de temperaturas (cada fila representa un año desde 1900)
        double[][] matrizTemperaturas = {
            {5.0, -1.0, -2.0, -3.0, 4.0, -5.0, -6.0, -7.0, -8.0, 10.0}, // 1900
            {1.0, -2.0, -3.0, -4.0, 5.0, -6.0, -7.0, -8.0, -9.0, 10.0}, // 1901
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},         // 1902 (sin olas de frío)
            {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0} // 1903
        };

        int n = 2; // Número mínimo de días consecutivos para considerar una ola de frío

        int añoMasReciente = masOlasDeFrio(matrizTemperaturas, n);

        if (añoMasReciente > 0) {
            System.out.println("El año más reciente con más olas de frío es: " + añoMasReciente);
        } else {
            System.out.println("No se encontraron olas de frío en ningún año.");
        }
    }
}