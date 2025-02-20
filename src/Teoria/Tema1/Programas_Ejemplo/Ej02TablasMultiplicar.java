package Teoria.Tema1.Programas_Ejemplo;

public class Ej02TablasMultiplicar {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nTabla del " + i);
            for (int j = 1; j <= 10; j++)
                System.out.println(i + " x " + j + " = " + i * j);
        }
    }

}
