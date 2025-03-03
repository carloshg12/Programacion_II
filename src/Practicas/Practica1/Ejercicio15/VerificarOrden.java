package Practicas.Practica1.Ejercicio15;

public class VerificarOrden {

    // Método estático para verificar si un vector de cadenas está ordenado
    public static boolean estaOrdenado(String[] vector) {
        // Recorremos el vector desde el primer elemento hasta el penúltimo
        for (int i = 0; i < vector.length - 1; i++) {
            // Comparamos el elemento actual con el siguiente
            if (vector[i].compareTo(vector[i + 1]) > 0) {
                return false; // Si no está en orden, devolvemos false
            }
        }
        return true; // Si todo está en orden, devolvemos true
    }

    // Método principal para probar el método estaOrdenado
    public static void main(String[] args) {
        String[] vector1 = {"apple", "banana", "cherry"};
        String[] vector2 = {"apple", "cherry", "banana"};

        System.out.println("Vector 1 está ordenado: " + estaOrdenado(vector1)); // true
        System.out.println("Vector 2 está ordenado: " + estaOrdenado(vector2)); // false
    }
}