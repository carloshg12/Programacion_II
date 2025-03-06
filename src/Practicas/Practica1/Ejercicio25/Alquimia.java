package Practicas.Practica1.Ejercicio25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

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

    // Método estático para obtener el elemento generado al combinar dos elementos
    public static String elementoGenerado(int[][] matrizCombinaciones, String[] elementos, String elemento1, String elemento2) {
        // Mapa para obtener el índice de un elemento a partir de su nombre
        HashMap<String, Integer> indiceElementos = new HashMap<>();
        for (int i = 0; i < elementos.length; i++) {
            indiceElementos.put(elementos[i], i);
        }

        // Obtener los índices de los elementos
        Integer i = indiceElementos.get(elemento1);
        Integer j = indiceElementos.get(elemento2);

        // Verificar si los elementos existen en el vector
        if (i == null || j == null) {
            return null; // Si alguno de los elementos no existe, devolver null
        }

        // Obtener el índice del resultado de la combinación
        int k = matrizCombinaciones[i][j];

        // Si k es -1, los elementos no son combinables
        if (k == -1) {
            return null;
        }

        // Devolver el nombre del elemento resultante
        return elementos[k];
    }

    // Método principal para probar los métodos
    public static void main(String[] args) {
        // Ejemplo de vector de elementos
        String[] elementos = {"agua", "aire", "fuego", "tierra", "lava", "piedra", "arena", "desierto", "cristal", "reloj_de_arena"};

        // Nombre del archivo de combinaciones
        String nombreArchivo = "datos/combinaciones.txt";

        // Crear la matriz de combinaciones
        int[][] matrizCombinaciones = crearMatrizCombinaciones(elementos, nombreArchivo);

        // Probar el método elementoGenerado
        String resultado1 = elementoGenerado(matrizCombinaciones, elementos, "tierra", "fuego");
        String resultado2 = elementoGenerado(matrizCombinaciones, elementos, "agua", "aire");
        String resultado3 = elementoGenerado(matrizCombinaciones, elementos, "lava", "aire");

        // Mostrar resultados
        System.out.println("Combinación de tierra y fuego: " + (resultado1 != null ? resultado1 : "No combinable"));
        System.out.println("Combinación de agua y aire: " + (resultado2 != null ? resultado2 : "No combinable"));
        System.out.println("Combinación de lava y aire: " + (resultado3 != null ? resultado3 : "No combinable"));
    }
}