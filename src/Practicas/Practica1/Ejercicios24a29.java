package Practicas.Practica1; // Indica aquí el nombre del paquete que estás utilizando

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.*;

public class Ejercicios24a29 {

    public static void main(String[] args) throws FileNotFoundException {
        String[] elementos10 = {"tierra", "fuego", "lava", "aire", "piedra", "agua", "arena", "desierto", "cristal", "reloj_de_arena"};
        String nombre10 = "datos/alquimia10.txt";
        int[][] matriz10 = leerMatrizResultado("datos/matriz10.bin");

        String[] elementos380 = leerElementos("datos/elementos380.txt");
        String nombre380 = "datos/alquimia380.txt";
        int[][] matriz380 = leerMatrizResultado("datos/matriz380.bin");

        System.out.println("*** PROBANDO CON LOS ARCHIVOS DE 10 ELEMENTOS ***");
        prueba(elementos10, nombre10, matriz10, new String[]{null, "desierto", "reloj_de_arena", null},
                new String[]{"arena"},
                2, "arena", 1);

        System.out.println("\n******************************\n");

        System.out.println("*** PROBANDO CON LOS ARCHIVOS DE 380 ELEMENTOS ***");
        prueba(elementos380, nombre380, matriz380, new String[]{"viento", "desierto", "reloj_de_arena", null},
                new String[]{"agua", "aire", "árbol", "arboleda", "arena", "ciudad", "continente", "cuchillo", "escarabajo", "libro", "país", "rascacielos", "rueda", "tierra", "transistor", "tumba"},
                154,"fuego", 0);
    }

    public static void prueba(String[] elementos, String nFichComb, int[][] matRes,
                              String[] elemEsperados, String[] combConsigoEsperado,
                              int nTerminalesEsperados, String másCombinableEsperado,
                              int nMúltiplesCombEsperado) throws FileNotFoundException {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("CREANDO LA MATRIZ DE COMBINACIONES");
        int[][] m = crearMatrizCombinaciones(elementos, nFichComb);
        if (Arrays.deepEquals(m, matRes))
            System.out.println(ANSI_GREEN + "La matriz construida es correcta");
        else
            System.out.println(ANSI_RED + "La matriz obtenida no coincide con la esperada");
        System.out.print(ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO El MÉTODO ELEMENTO_GENERADO");
        String[][] combo = {{"aire", "aire"}, {"arena", "arena"}, {"arena", "cristal"}, {"aire", "xyz012"}};
        for (int i = 0; i < elemEsperados.length; i++) {
            String elem1 = combo[i][0];
            String elem2 = combo[i][1];
            String elementoObtenido = elementoGenerado(m, elementos, elem1, elem2);
            System.out.format("Al combinar %s y %s se produce %s", elem1, elem2, elementoObtenido);
            if (elementoObtenido == elemEsperados[i] || (elementoObtenido != null && elementoObtenido.equals(elemEsperados[i])))
                System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
            else
                System.out.println(" --> " + ANSI_RED + "Error. Se esperaba: " + elemEsperados[i] + ANSI_RESET);
        }
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO COMBINABLES_CONSIGO");
        String[] resCombConsigo = combinablesConsigo(m, elementos);
        System.out.format("Se obtiene(n) %d elemento(s) combinable(s) consigo: %s%n ", resCombConsigo.length, Arrays.toString(resCombConsigo));
        if (Arrays.equals(resCombConsigo, combConsigoEsperado))
            System.out.println("\t--> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println("\t--> " + ANSI_RED + "Error. Se esperaba: " + Arrays.toString(combConsigoEsperado) + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO CONTAR_TERMINALES");
        int nTerminales = contarTerminales(m);
        System.out.format("Se obtienen %d elementos terminales", nTerminales);
        if (nTerminales == nTerminalesEsperados)
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaban: " + nTerminalesEsperados + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO ELEMENTO_MÁS_COMBINABLE");
        String másCombinable = elementoMásCombinable(m, elementos);
        System.out.format("Se obtiene %s como elemento más combinable", másCombinable);
        if (másCombinable.equals(másCombinableEsperado))
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaba: " + másCombinableEsperado + ANSI_RESET);
        /* ----------------------------- */
        System.out.println("PROBANDO EL MÉTODO MÚLTIPLES_COMBINACIONES");
        int nMúltiplesComb = múltiplesCombinaciones(m);
        System.out.format("%d elemento(s) se puede(n) obtener con múltiples combinaciones", nMúltiplesComb);
        if (nMúltiplesComb == nMúltiplesCombEsperado)
            System.out.println(" --> " + ANSI_GREEN + "OK" + ANSI_RESET);
        else
            System.out.println(" --> " + ANSI_RED + "Error. Se esperaban: " + nMúltiplesCombEsperado + ANSI_RESET);

    }

    public static String[] leerElementos(String nFich) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(nFich));
        int nElem = entrada.nextInt();
        String[] vector = new String[nElem]; // Al comienzo del fichero se indica la cantidad de elementos
        for (int i = 0; i < nElem; i++)
            vector[i] = entrada.next();
        entrada.close();
        return vector;
    }

    public static int[][] leerMatrizResultado(String nFich) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nFich));
            int[][] m = (int[][]) in.readObject();
            in.close();
            return m;
        } catch (Exception e) {
            System.out.println("Algo ha ido mal al leer el fichero --> " + e.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public static int[][] crearMatrizCombinaciones(String[] elementos, String nFich) throws FileNotFoundException {
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
        try (Scanner scanner = new Scanner(new File(nFich))) {
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
            System.err.println("Error: No se pudo abrir el archivo " + nFich);
        }

        return matrizCombinaciones;
    }

    public static String elementoGenerado(int[][] m, String[] elementos, String e1, String e2) {
        // Mapa para obtener el índice de un elemento a partir de su nombre
        HashMap<String, Integer> indiceElementos = new HashMap<>();
        for (int i = 0; i < elementos.length; i++) {
            indiceElementos.put(elementos[i], i);
        }

        // Obtener los índices de los elementos
        Integer i = indiceElementos.get(e1);
        Integer j = indiceElementos.get(e2);

        // Verificar si los elementos existen en el vector
        if (i == null || j == null) {
            return null; // Si alguno de los elementos no existe, devolver null
        }

        // Obtener el índice del resultado de la combinación
        int k = m[i][j];

        // Si k es -1, los elementos no son combinables
        if (k == -1) {
            return null;
        }

        // Devolver el nombre del elemento resultante
        return elementos[k];
    }

    public static String[] combinablesConsigo(int[][] m, String[] elementos) {
        List<String> elementosCombinables = new ArrayList<>();

        // Recorrer la diagonal principal de la matriz
        for (int i = 0; i < elementos.length; i++) {
            // Verificar si el elemento puede combinarse consigo mismo
            if (m[i][i] != -1) {
                elementosCombinables.add(elementos[i]); // Añadir el elemento a la lista
            }
        }

        // Convertir la lista a un array de Strings
        return elementosCombinables.toArray(new String[0]);
    }

    public static int contarTerminales(int[][] m) {
        int contadorTerminales = 0;

        // Recorrer cada fila de la matriz
        for (int i = 0; i < m.length; i++) {
            boolean esTerminal = true; // Suponemos que el elemento es terminal

            // Recorrer cada columna de la fila
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != -1) {
                    esTerminal = false; // Si hay una combinación, no es terminal
                    break;
                }
            }

            // Si el elemento es terminal, incrementar el contador
            if (esTerminal) {
                contadorTerminales++;
            }
        }

        return contadorTerminales;
    }

    public static String elementoMásCombinable(int[][] m, String[] elementos) {
        int maxCombinaciones = -1; // Inicializar el máximo número de combinaciones
        String elementoMasCombinable = null; // Inicializar el elemento más combinable

        // Recorrer cada fila de la matriz
        for (int i = 0; i < m.length; i++) {
            int contadorCombinaciones = 0; // Contador de combinaciones para el elemento actual

            // Recorrer cada columna de la fila
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != -1) {
                    contadorCombinaciones++; // Incrementar el contador si hay una combinación
                }
            }

            // Si el elemento actual tiene más combinaciones que el máximo actual
            if (contadorCombinaciones > maxCombinaciones) {
                maxCombinaciones = contadorCombinaciones; // Actualizar el máximo
                elementoMasCombinable = elementos[i]; // Actualizar el elemento más combinable
            }
        }

        return elementoMasCombinable;
    }
    public static int múltiplesCombinaciones(int[][] m) {
        // Mapa para almacenar cuántas combinaciones generan cada elemento
        HashMap<Integer, Integer> contadorCombinaciones = new HashMap<>();

        // Recorrer la matriz de combinaciones
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int resultado = m[i][j];

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
}
