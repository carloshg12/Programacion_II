package Practicas.Practica1.Ejercicio21;

public class Contiene {

    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3, 4, 5};
        int[] vector2 = {2, 3, 4};
        int[] vector3 = {2, 6};
        
        System.out.println(contiene(vector1, 3)); // true
        System.out.println(contiene(vector1, 6)); // false
        
        System.out.println(contiene(vector1, vector2)); // true
        System.out.println(contiene(vector1, vector3)); // false
    }

    public static boolean contiene(int[] numeros, int valor) {
        for (int num : numeros) {
            if (num == valor) {
                return true;
            }
        }
        return false;
    }

    public static boolean contiene(int[] numeros, int[] valores) {
        for (int valor : valores) {
            if (!contiene(numeros, valor)) {
                return false;
            }
        }
        return true;
    }
}
