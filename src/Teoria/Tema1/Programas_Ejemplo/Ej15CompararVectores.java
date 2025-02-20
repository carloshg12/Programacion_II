package Teoria.Tema1.Programas_Ejemplo;

import java.util.Arrays;

public class Ej15CompararVectores {

    public static void main(String[] args) {
        int[] v1 = {10, 20, 30, 40, 50};
        int[] v2 = {10, 20, 30, 40, 50};
        System.out.println("¿v1 == v2? " + (v1 == v2));
        System.out.println("¿v1.equals(v2)? " + v1.equals(v2));
        System.out.println("¿iguales(v1, v2)? " + iguales(v1, v2));
        boolean sonIguales = Arrays.equals(v1, v2);
        System.out.println("¿Arrays.equals(v1, v2)? " + sonIguales);
    }

    private static boolean iguales(int[] v1, int[] v2) {
        if (v1.length != v2.length)
            return false;
        else {
            for (int i = 0; i < v1.length; i++)
                if (v1[i] != v2[i])
                    return false;
            return true;
        }
    }

}
