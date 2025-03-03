package Practicas.Practica1.Ejercicio14;

public class BuscarUltimaPosicion {

    // Método estático para encontrar la última posición de un número en un vector
    public static int ultimaPosicion(int[] vector, int numero) {
        // Recorremos el vector desde el final hacia el principio
        for (int i = vector.length - 1; i >= 0; i--) {
            if (vector[i] == numero) {
                return i; // Devolvemos la posición si encontramos el número
            }
        }
        return -1; // Si no encontramos el número, devolvemos -1
    }

    // Método principal para probar el método ultimaPosicion
    public static void main(String[] args) {
        int[] vector = {10, 20, 30, 40, 50, 30, 20};
        int numero = 30;

        int posicion = ultimaPosicion(vector, numero);

        if (posicion >= 0) {
            System.out.println("El numero " + numero + " se encuentra en la posicion " + posicion);
        } else {
            System.out.println("El numero " + numero + " no se encuentra en el vector.");
        }
    }
}