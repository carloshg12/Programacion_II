package Practicas.Practica2.Ejercicio4;

import Practicas.Practica2.Ejercicio1.Punto;
import Practicas.Practica2.Ejercicio2.Restaurante;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestauranteMejorValorado {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero de restaurantes: ");
        String nombreFichero = teclado.next();
        Restaurante[] restaurantes = Restaurante.leeRestaurantes(nombreFichero);

        System.out.println("Indique su posición actual");
        System.out.print("Coordenada X: ");
        double x = teclado.nextDouble();
        System.out.print("Coordenada Y: ");
        double y = teclado.nextDouble();
        
        System.out.print("Introduce la distancia máxima a caminar: ");
        double distanciaMaxima = teclado.nextDouble();

        Punto posicionActual = new Punto(x, y);
        Restaurante restaurante = restauranteMejorValorado(restaurantes, posicionActual, distanciaMaxima);
        
        if (restaurante != null) {
            System.out.print("El restaurante mejor valorado dentro de su rango es " + restaurante.getNombre());
            System.out.print(", situado en el punto " + restaurante.getPosicion());
            System.out.println(", con una valoración de " + restaurante.getValoracion() + " estrellas");
        } else {
            System.out.println("No hay restaurantes dentro del rango especificado");
        }
    }

    /**
     * Encuentra el restaurante mejor valorado dentro de un radio determinado
     * @param v Array de restaurantes
     * @param p Posición actual del usuario
     * @param d Distancia máxima a caminar
     * @return Restaurante mejor valorado dentro del radio o null si no hay ninguno
     */
    public static Restaurante restauranteMejorValorado(Restaurante[] v, Punto p, double d) {
        Restaurante mejorRestaurante = null;
        int mejorValoracion = -1;
        
        for (Restaurante restaurante : v) {
            double distancia = restaurante.distancia(p);
            if (distancia <= d) {
                if (mejorRestaurante == null || restaurante.getValoracion() > mejorValoracion) {
                    mejorRestaurante = restaurante;
                    mejorValoracion = restaurante.getValoracion();
                }
            }
        }
        
        return mejorRestaurante;
    }
}