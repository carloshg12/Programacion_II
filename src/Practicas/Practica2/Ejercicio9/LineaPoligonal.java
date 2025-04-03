package Practicas.Practica2.Ejercicio9;

import Practicas.Practica2.Ejercicio1.Punto;
import Practicas.Practica2.Ejercicio6.Fecha;

public class LineaPoligonal {

    private Punto[] puntos;
    private int cantidad;
    private static final int TALLA_INICIAL = 8;

    // Constructor sin parámetros
    public LineaPoligonal() {
        puntos = new Punto[TALLA_INICIAL];
        cantidad = 0;
    }

    public void añadir(Punto punto){
        if (cantidad == puntos.length){
            Punto[] aux = new Punto[puntos.length * 2];

            for (int i = 0; i < cantidad; i++) {
                aux[i] = puntos[i];
            }
            puntos = aux;
        }
        puntos[cantidad] = new Punto(punto.getX(), punto.getY());
        cantidad++;
    }

    public void quitar(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return;
        }

        for (int i = posicion; i < cantidad - 1; i++) {
            puntos[i] = puntos[i + 1];
        }
        puntos[cantidad - 1] = null;
        cantidad--;
    }

    public void quitar(Punto punto) {
        for (int i = 0; i < cantidad; i++) {
            if (puntos[i].equals(punto)) {
                quitar(i);
                return;
            }
        }
    }

    public void trasladar(double desplazamientoX, double desplazamientoY) {
        for (int i = 0; i < cantidad; i++) {
            puntos[i] = puntos[i].desplazar(desplazamientoX, desplazamientoY);
        }
    }

    public double longitud() {
        if (cantidad < 2) {
            return 0.0;
        }

        double total = 0.0;
        for (int i = 0; i < cantidad - 1; i++) {
            total += puntos[i].distancia(puntos[i + 1]);
        }
        return total;
    }

    @Override
    public String toString() {
        if (cantidad == 0) {
            return "";
        }

        String resultado = puntos[0].toString();
        for (int i = 1; i < cantidad; i++) {
            resultado += "--" + puntos[i].toString();
        }
        return resultado;
    }


    //Revisar
    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) return true;
        if ((!(otroObjeto instanceof Punto))) return false;

        LineaPoligonal otraLinea = (LineaPoligonal) otroObjeto;
        if (cantidad != otraLinea.cantidad) return false;

        for (int i = 0; i < cantidad; i++) {
            if (!puntos[i].equals(otraLinea.puntos[i])) {
                return false;
            }
        }
        return true;
    }
}