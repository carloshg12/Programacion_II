package Practicas.Practica3.Ejercicio1.LinkedList;

import Practicas.Practica2.Ejercicio1.Punto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LineaPoligonal {
    private List<Punto> puntos;

    // Constructor
    public LineaPoligonal() {
        puntos = new LinkedList<>();
    }

    // Añadir punto al final
    public void añadir(Punto punto) {
        puntos.add(new Punto(punto.getX(), punto.getY()));
    }

    // Quitar punto por posición
    public void quitar(int posicion) {
        if (posicion >= 0 && posicion < puntos.size()) {
            puntos.remove(posicion);
        }
    }

    // Quitar punto por valor (primera ocurrencia)
    public void quitar(Punto punto) {
        for (int i = 0; i < puntos.size(); i++) {
            if (puntos.get(i).equals(punto)) {
                puntos.remove(i);
                return;
            }
        }
    }

    // Trasladar todos los puntos
    public void trasladar(double desplazamientoX, double desplazamientoY) {
        for (int i = 0; i < puntos.size(); i++) {
            Punto p = puntos.get(i);
            puntos.set(i, p.desplazar(desplazamientoX, desplazamientoY));
        }
    }

    // Calcular longitud total
    public double longitud() {
        if (puntos.size() < 2) {
            return 0.0;
        }
        
        double total = 0.0;
        for (int i = 0; i < puntos.size() - 1; i++) {
            total += puntos.get(i).distancia(puntos.get(i + 1));
        }
        return total;
    }

    // Representación como String
    @Override
    public String toString() {
        if (puntos.isEmpty()) {
            return "";
        }
        
        String resultado = puntos.get(0).toString();
        for (int i = 1; i < puntos.size(); i++) {
            resultado += "--" + puntos.get(i).toString();
        }
        return resultado;
    }

    // Comparación de igualdad
    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) return true;
        if (otroObjeto == null || getClass() != otroObjeto.getClass()) return false;
        
        LineaPoligonal otraLinea = (LineaPoligonal) otroObjeto;
        return puntos.equals(otraLinea.puntos);
    }
}