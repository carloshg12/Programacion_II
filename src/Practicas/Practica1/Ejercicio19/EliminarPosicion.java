package Practicas.Practica1.Ejercicio19;

public class EliminarPosicion {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int[] resultado = eliminarPosicion(numeros, 2); // Debería eliminar el número 3
        
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    public static int[] eliminarPosicion(int[] numeros, int posicion) {
        if (posicion < 0 || posicion >= numeros.length) {
            return numeros; // Si la posición no es válida, devolver el mismo vector
        }
        
        int[] nuevoVector = new int[numeros.length - 1];
        int index = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (i != posicion) {
                nuevoVector[index++] = numeros[i];
            }
        }
        
        return nuevoVector;
    }
}
