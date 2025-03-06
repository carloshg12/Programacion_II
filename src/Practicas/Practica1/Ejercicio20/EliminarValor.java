package Practicas.Practica1.Ejercicio20;

public class EliminarValor {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 3, 5, 3};
        int valor = 3;
        int[] resultado = eliminarValor(numeros, valor);
        
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    public static int[] eliminarValor(int[] numeros, int valor) {
        int contador = 0;
        for (int num : numeros) {
            if (num != valor) {
                contador++;
            }
        }

        int[] resultado = new int[contador];
        int index = 0;
        for (int num : numeros) {
            if (num != valor) {
                resultado[index++] = num;
            }
        }
        
        return resultado;
    }
}