package Practicas.Practica3.Ejercicio2;

public class ListaCadenasEnlaceSimple implements ListaCadenas{

    private static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo primero;
    private int talla;

    public ListaCadenasEnlaceSimple() {
        primero = null;
        talla = 0;
    }

    @Override
    public boolean add(String s) {
        Nodo nuevo = new Nodo(s);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        talla++;
        return true;
    }

    @Override
    public void add(int i, String s) {
        if (i < 0 || i > talla) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }

        Nodo nuevo = new Nodo(s);
        if (i == 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else {
            Nodo anterior = obtenerNodo(i - 1);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
        talla++;
    }

    @Override
    public void clear() {
        primero = null;
        talla = 0;
    }

    @Override
    public String get(int i) {
        if (i < 0 || i >= talla) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }
        return obtenerNodo(i).dato;
    }

    @Override
    public int indexOf(String s) {
        Nodo actual = primero;
        int indice = 0;
        while (actual != null) {
            if (actual.dato.equals(s)) {
                return indice;
            }
            actual = actual.siguiente;
            indice++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String s) {
        Nodo actual = primero;
        int indice = 0;
        int ultimoIndice = -1;
        while (actual != null) {
            if (actual.dato.equals(s)) {
                ultimoIndice = indice;
            }
            actual = actual.siguiente;
            indice++;
        }
        return ultimoIndice;
    }

    @Override
    public boolean isEmpty() {
        return talla == 0;
    }

    @Override
    public String remove(int i) {
        if (i < 0 || i >= talla) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }

        String dato;
        if (i == 0) {
            dato = primero.dato;
            primero = primero.siguiente;
        } else {
            Nodo anterior = obtenerNodo(i - 1);
            dato = anterior.siguiente.dato;
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        talla--;
        return dato;
    }

    @Override
    public boolean remove(String s) {
        if (primero == null) {
            return false;
        }

        if (primero.dato.equals(s)) {
            primero = primero.siguiente;
            talla--;
            return true;
        }

        Nodo actual = primero;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(s)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            talla--;
            return true;
        }
        return false;
    }

    @Override
    public String set(int i, String s) {
        if (i < 0 || i >= talla) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + i);
        }

        Nodo nodo = obtenerNodo(i);
        String anterior = nodo.dato;
        nodo.dato = s;
        return anterior;
    }

    @Override
    public int size() {
        return talla;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    // Metodo auxiliar para obtener el nodo en una posición específica
    private Nodo obtenerNodo(int indice) {
        Nodo actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }
}