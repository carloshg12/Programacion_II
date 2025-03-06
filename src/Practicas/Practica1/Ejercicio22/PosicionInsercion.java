package Practicas.Practica1.Ejercicio22;

public class PosicionInsercion {

    // Método estático para encontrar la posición de inserción
    public static int posicionInsercion(int[] vector, int valor) {
        // Recorremos el vector
        for (int i = 0; i < vector.length; i++) {
            // Si encontramos un elemento mayor o igual al valor, devolvemos su posición
            if (vector[i] >= valor) {
                return i;
            }
        }
        // Si no encontramos ningún elemento mayor o igual, devolvemos la posición al final del vector
        return vector.length;
    }

    // Método principal para probar el método posicionInsercion
    public static void main(String[] args) {
        int[] vector = {1, 3, 5, 7, 9}; // Vector ordenado
        int valor = 6; // Valor a insertar

        int posicion = posicionInsercion(vector, valor);
        System.out.println("El valor " + valor + " deberia insertarse en la posicion " + posicion);
    }
}