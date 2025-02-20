package Teoria.Tema1.Programas_Ejemplo;


public class Ej11Maximos {

    public static void main(String[] args) {
        // Ejemplo de programa principal
        System.out.println(max(200, 150));
        System.out.println(max(200, 150, 250));
        System.out.println(max("ABC", "XYZ"));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int max(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    private static String max(String s1, String s2) {
        return s1.compareTo(s2) > 0 ? s1 : s2;
    }

}
