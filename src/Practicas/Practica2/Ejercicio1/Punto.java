package Practicas.Practica2.Ejercicio1;
import java.util.Locale;

public class Punto {
    private double x;
    private double y;

    // Constructor con coordenadas
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor sin parámetros (punto en origen)
    public Punto() {
        this(0.0, 0.0);
    }

    // Getter para coordenada x
    public double getX() {
        return x;
    }

    // Getter para coordenada y
    public double getY() {
        return y;
    }

    // Metodo para desplazar el punto sin modificar el original
    public Punto desplazar(double desplazamientoX, double desplazamientoY) {
        return new Punto(this.x + desplazamientoX, this.y + desplazamientoY);
    }

    // Metodo para calcular distancia entre puntos
    public double distancia(Punto otroPunto) {
        double diffX = otroPunto.getX() - this.x;
        double diffY = otroPunto.getY() - this.y;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }

    // Representación en String del punto
    @Override
    public String toString() {
        return String.format(Locale.US, "(%.2f, %.2f)", x, y);
    }

    // Metodo para comparar igualdad de puntos
    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) return true;
        if (otroObjeto == null || getClass() != otroObjeto.getClass()) return false;

        Punto otroPunto = (Punto) otroObjeto;
        return Double.compare(otroPunto.x, x) == 0 &&
                Double.compare(otroPunto.y, y) == 0;
    }
}