package Practicas.Practica2.Ejercicio2;

import Practicas.Practica2.Ejercicio1.Punto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Restaurante {

    private String nombre;
    private Punto posicion;
    private int valoracion;

    public Restaurante(String nombre, Punto posicion, int valoracion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Punto getPosicion() {
        return posicion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public double distancia (Punto p) {
        return posicion.distancia(p);
    }

    public static Restaurante[] leeRestaurantes(String nombreFichero) throws FileNotFoundException, FileNotFoundException {
        Scanner sc = new Scanner(new File(nombreFichero));
        sc.useLocale(Locale.US); // Para usar punto como separador decimal

        // Leer número de restaurantes
        int numRestaurantes = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        Restaurante[] restaurantes = new Restaurante[numRestaurantes];

        // Leer cada restaurante
        for (int i = 0; i < numRestaurantes; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int valoracion = sc.nextInt();
            String nombre = sc.nextLine().trim(); // Lee el resto de la línea como nombre

            Punto posicion = new Punto(x, y);
            restaurantes[i] = new Restaurante(nombre, posicion, valoracion);
        }

        sc.close();
        return restaurantes;
    }
}
