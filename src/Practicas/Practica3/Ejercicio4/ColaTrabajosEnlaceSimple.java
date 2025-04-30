package Practicas.Practica3.Ejercicio4;

import Practicas.Practica3.Ejercicio3.TrabajoImpresora;
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

    public void cancelar(String idUsuario) {
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.trabajo.getIdUsuario().equals(idUsuario)) {
                // Eliminar este nodo
                if (actual == primero) {
                    primero = primero.siguiente;
                    if (primero == null) {
                        ultimo = null;
                    }
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual == ultimo) {
                        ultimo = anterior;
                    }
                }
                talla--;
            } else {
                anterior = actual;
            }
            actual = actual.siguiente;
        }
    }

    /**
     * Mueve el trabajo con el ID especificado al frente de la cola
     * @param idTrabajo Identificador del trabajo a adelantar
     */
    public void adelantar(int idTrabajo) {
        if (esVacía() || primero.trabajo.getIdTrabajo() == idTrabajo) {
            return; // No hay nada que hacer
        }

        Nodo anterior = null;
        Nodo actual = primero;

        // Buscar el nodo con el idTrabajo
        while (actual != null && actual.trabajo.getIdTrabajo() != idTrabajo) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) { // Si encontramos el trabajo
            // Desconectar el nodo de su posición actual
            anterior.siguiente = actual.siguiente;

            // Si era el último, actualizar referencia
            if (actual == ultimo) {
                ultimo = anterior;
            }

            // Mover al frente
            actual.siguiente = primero;
            primero = actual;
        }
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