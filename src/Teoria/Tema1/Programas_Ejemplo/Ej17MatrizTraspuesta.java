package Teoria.Tema1.Programas_Ejemplo;


import java.util.Arrays;

public class Ej17MatrizTraspuesta {

    public static void main(String[] args) {
        // Ejemplo de programa principal (matriz con valores concretos)
        double[][] m = {{10, 20, 30},
                        {40, 50, 60}};
        double[][] t = obtenerTraspuesta(m);
        System.out.println("Traspuesta: " + Arrays.deepToString(t));
    }

    private static double[][] obtenerTraspuesta(double[][] matriz) {
        // Dimensiones de la matriz traspuesta
        int filas = matriz[0].length;  // Nº columnas de matriz
        int columnas = matriz.length;  // Nº filas de matriz
        double[][] traspuesta = new double[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                traspuesta[i][j] = matriz[j][i];
        return traspuesta;
    }

}
