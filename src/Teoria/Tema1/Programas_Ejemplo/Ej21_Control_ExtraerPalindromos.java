package Teoria.Tema1.Programas_Ejemplo;

import java.util.Arrays;

public class Ej21_Control_ExtraerPalindromos {

    public static void main(String[] args) {
        String[] vector = {"aviva", "no", "radar", "soy", "palindromo", "rallar"};
        String[] palíndromos = extraerPalíndromos(vector);
        System.out.println(Arrays.toString(palíndromos));
    }

    // Devuelve true cuando la cadena s es un palíndromo y false cuando no lo es
    private static boolean esPalíndromo(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

    // Devuelve un vector con las cadenas del vector dado que son palíndromos
    // (Versión pedida en la descripción del ejercicio)
    private static String[] extraerPalíndromos(String[] v) {
        // Contar palíndromos
        int cantidad = 0;
        for (int i = 0; i < v.length; ++i)
            if (esPalíndromo(v[i]))
                cantidad++;

        String[] palíndromos = new String[cantidad];
        int pos = 0;
        for (String s : v)
            if (esPalíndromo(s))
                palíndromos[pos++] = s;

        return palíndromos;
    }

    // Devuelve un vector con las cadenas del vector dado que son palíndromos
    // (Otra versión)
    private static String[] extraerPalíndromosV2(String[] v) {
        String[] aux = new String[v.length];
        int pos = 0;
        for (String s : v)
            if (esPalíndromo(s))
                aux[pos++] = s;

        String[] palíndromos = new String[pos];
        for (int i = 0; i < palíndromos.length; i++)
            palíndromos[i] = aux[i];
        return palíndromos;
    }

    // Devuelve un vector con las cadenas del vector dado que son palíndromos
    // (Otra versión más, menos eficiente)
    private static String[] extraerPalíndromosV3(String[] v) {
        String[] palíndromos = new String[0];

        for (String s : v)
            if (esPalíndromo(s)) {
                // Redimensionar vector
                String[] aux = new String[palíndromos.length + 1];
                for (int i = 0; i < palíndromos.length; i++)
                    aux[i] = palíndromos[i];
                aux[aux.length - 1] = s;
                palíndromos = aux;
            }

        return palíndromos;
    }

}
