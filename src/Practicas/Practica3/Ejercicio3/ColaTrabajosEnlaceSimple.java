package Practicas.Practica3.Ejercicio3;

import java.util.NoSuchElementException;

public class ColaTrabajosEnlaceSimple implements ColaTrabajos {
    private static class Nodo {
        TrabajoImpresora trabajo;
        Nodo siguiente;

        Nodo(TrabajoImpresora trabajo) {
            this.trabajo = trabajo;
            this.siguiente = null;
        }
    }

    private Nodo primero;
    private Nodo ultimo;
    private int talla;

    public ColaTrabajosEnlaceSimple() {
        primero = null;
        ultimo = null;
        talla = 0;
    }

    @Override
    public void insertar(TrabajoImpresora t) {
        Nodo nuevo = new Nodo(t);
        if (esVacía()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        talla++;
    }


    @Override
    public TrabajoImpresora extraerPrimero() {
        if (esVacía()) {
            throw new NoSuchElementException("La cola está vacía");
        }

        TrabajoImpresora trabajo = primero.trabajo;
        primero = primero.siguiente;
        talla--;

        if (esVacía()) {
            ultimo = null;
        }

        return trabajo;
    }

    @Override
    public TrabajoImpresora consultarPrimero() {
        if (esVacía()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return primero.trabajo;
    }

    @Override
    public int getTalla() {
        return talla;
    }

    @Override
    public boolean esVacía() {
        return talla == 0;
    }

    @Override
    public String toString() {
        if (esVacía()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.trabajo.toString());
            if (actual.siguiente != null) {
                sb.append(" -> ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}