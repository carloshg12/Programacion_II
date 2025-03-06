package Practicas.Practica1.Ejercicio26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // Método estático para obtener los elementos que pueden ser combinados consigo mismos
    public static String[] combinablesConsigo(int[][] matrizCombinaciones, String[] elementos) {
        List<String> elementosCombinables = new ArrayList<>();

        // Recorrer la diagonal principal de la matriz
        for (int i = 0; i < elementos.length; i++) {
            // Verificar si el elemento puede combinarse consigo mismo
            if (matrizCombinaciones[i][i] != -1) {
                elementosCombinables.add(elementos[i]); // Añadir el elemento a la lista
            }
        }

        // Convertir la lista a un array de Strings
        return elementosCombinables.toArray(new String[0]);
    }

    // Método principal para probar los métodos
    public static void main(String[] args) {
        // Ejemplo de vector de elementos
        String[] elementos = {"agua", "aire", "fuego", "tierra", "lava", "piedra", "arena", "desierto", "cristal", "reloj_de_arena"};

        // Nombre del archivo de combinaciones
        String nombreArchivo = "datos/combinaciones.txt";

        // Crear la matriz de combinaciones
        int[][] matrizCombinaciones = crearMatrizCombinaciones(elementos, nombreArchivo);

        // Obtener los elementos que pueden ser combinados consigo mismos
        String[] combinables = combinablesConsigo(matrizCombinaciones, elementos);

        // Mostrar los elementos combinables consigo mismos
        System.out.println("Elementos que pueden ser combinados consigo mismos:");
        for (String elemento : combinables) {
            System.out.println(elemento);
        }
    }
}