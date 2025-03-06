package Practicas.Practica1.Ejercicio29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Alquimia {

    // Método estático para crear la matriz de combinaciones (del ejercicio anterior)
    public static int[][] crearMatrizCombinaciones(String[] elementos, String nombreArchivo) {
        int n = elementos.length;
        int[][] matrizCombinaciones = new int[n][n]; // Matriz de N x N

        // Inicializar la matriz con -1 (no combinables)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizCombinaciones[i][j] = -1;
            }
        }

        // Mapa para obtener el índice de un elemento a partir de su nombre
        HashMap<String, Integer> indiceElementos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indiceElementos.put(elementos[i], i);
        }

        // Leer el archivo de combinaciones
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(" "); // Dividir la línea en partes

                if (partes.length == 3) { // Cada línea debe tener 3 elementos
                    String elemento1 = partes[0];
                    String elemento2 = partes[1];
                    String resultado = partes[2];

                    // Obtener los índices de los elementos
                    int i = indiceElementos.get(elemento1);
                    int j = indiceElementos.get(elemento2);
                    int k = indiceElementos.get(resultado);

                    // Asignar el resultado en la matriz (simétrica)
                    matrizCombinaciones[i][j] = k;
                    matrizCombinaciones[j][i] = k;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo abrir el archivo " + nombreArchivo);
        }

        return matrizCombinaciones;
    }

    // Método estático para contar elementos con múltiples combinaciones
    public static int multiplesCombinaciones(int[][] matrizCombinaciones) {
        // Mapa para almacenar cuántas combinaciones generan cada elemento
        HashMap<Integer, Integer> contadorCombinaciones = new HashMap<>();

        // Recorrer la matriz de combinaciones
        for (int i = 0; i < matrizCombinaciones.length; i++) {
            for (int j = 0; j < matrizCombinaciones[i].length; j++) {
                int resultado = matrizCombinaciones[i][j];

                // Si hay una combinación válida
                if (resultado != -1) {
                    // Incrementar el contador para el elemento resultante
                    contadorCombinaciones.put(resultado, contadorCombinaciones.getOrDefault(resultado, 0) + 1);
                }
            }
        }

        // Contar cuántos elementos tienen más de una combinación
        int contadorMultiples = 0;
        for (int count : contadorCombinaciones.values()) {
            if (count > 1) {
                contadorMultiples++;
            }
        }

        return contadorMultiples;
    }

    // Método principal para probar los métodos
    public static void main(String[] args) {
        // Ejemplo de vector de elementos
        String[] elementos = {"agua", "aire", "fuego", "tierra", "lava", "piedra", "arena", "desierto", "cristal", "reloj_de_arena"};

        // Nombre del archivo de combinaciones
        String nombreArchivo = "datos/combinaciones.txt";

        // Crear la matriz de combinaciones
        int[][] matrizCombinaciones = crearMatrizCombinaciones(elementos, nombreArchivo);

        // Contar elementos con múltiples combinaciones
        int multiples = multiplesCombinaciones(matrizCombinaciones);

        // Mostrar el resultado
        System.out.println("Cantidad de elementos con múltiples combinaciones: " + multiples);
    }
}