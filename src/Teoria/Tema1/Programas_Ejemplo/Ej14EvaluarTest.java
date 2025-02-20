package Teoria.Tema1.Programas_Ejemplo;


import java.util.Arrays;

public class Ej14EvaluarTest {

    public static void main(String[] args) {
        // Ejemplo de programa principal (con unos valores concretos)
        String plantilla = "cbbaabcdcc";
        String[] exámenes = {
                "cbababcd",
                "cbababcd**",
                "a*a*a*aaaa",
                "*bbbbbbbbb",
                "cbba*bcdcc",
                "exit"
        };

        for (String examen : exámenes) {
            System.out.println("Plantilla: " + plantilla);
            System.out.println("Respuesta: " + examen);
            System.out.println("Resultado: " + Arrays.toString(evaluarTest(plantilla, examen)));
            System.out.println();
        }
    }

    // Adaptación del ejercicio 17 de la práctica 4 de Programación I
    private static int[] evaluarTest(String plantilla, String respuestas) {
        if (plantilla.length() != respuestas.length())
            return null;
        int bien = 0, mal = 0, sinResponder = 0;
        for (int i = 0; i < respuestas.length(); i++) {
            if (respuestas.charAt(i) == '*')
                sinResponder++;
            else if (respuestas.charAt(i) == plantilla.charAt(i))
                bien++;
            else
                mal++;
        }
        return new int[]{bien, mal, sinResponder};
    }

}
