package Practicas.Practica1.Ejercicio17;

public class HayRepetidos {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 3};
        System.out.println(hayRepetidos(numeros));
    }

    public static boolean hayRepetidos(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}