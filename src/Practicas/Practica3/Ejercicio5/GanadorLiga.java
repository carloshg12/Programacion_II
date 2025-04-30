package Practicas.Practica3.Ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GanadorLiga {
    public static void main(String[] args) {
        String nombreFichero = "src/Practicas/Practica3/Ejercicio5/liga2023-2024.txt";
        Diccionario puntuaciones = new Diccionario();
        
        try (Scanner scanner = new Scanner(new File(nombreFichero))) {
            while (scanner.hasNext()) {
                String equipoLocal = scanner.next();
                int golesLocal = scanner.nextInt();
                String equipoVisitante = scanner.next();
                int golesVisitante = scanner.nextInt();
                
                // Calcular puntos para cada equipo
                if (golesLocal > golesVisitante) {
                    puntuaciones.añadir(equipoLocal, 3);
                    puntuaciones.añadir(equipoVisitante, 0);
                } else if (golesLocal < golesVisitante) {
                    puntuaciones.añadir(equipoLocal, 0);
                    puntuaciones.añadir(equipoVisitante, 3);
                } else { // empate
                    puntuaciones.añadir(equipoLocal, 1);
                    puntuaciones.añadir(equipoVisitante, 1);
                }
            }
            
            String ganador = puntuaciones.cadenaConMayorCantidad();
            int puntos = puntuaciones.cantidad(ganador);
            
            System.out.printf("El ganador de la liga es %s con %d puntos.%n", ganador, puntos);
            
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + nombreFichero);
        }
    }
}