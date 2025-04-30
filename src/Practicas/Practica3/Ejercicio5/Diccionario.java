package Practicas.Practica3.Ejercicio5;

public class Diccionario {
    private static class Nodo {
        String cadena;
        int cantidad;
        Nodo siguiente;
        
        Nodo(String cadena, int cantidad) {
            this.cadena = cadena;
            this.cantidad = cantidad;
            this.siguiente = null;
        }
        
        @Override
        public String toString() {
            return cadena + "-->" + cantidad;
        }
    }
    
    private Nodo primero;
    
    public Diccionario() {
        primero = null;
    }
    
    public void añadir(String unaCadena, int unaCantidad) {
        if (primero == null || unaCadena.compareTo(primero.cadena) < 0) {
            // Insertar al principio
            Nodo nuevo = new Nodo(unaCadena, unaCantidad);
            nuevo.siguiente = primero;
            primero = nuevo;
        } else if (unaCadena.equals(primero.cadena)) {
            // Actualizar cantidad del primer nodo
            primero.cantidad += unaCantidad;
        } else {
            // Buscar posición de inserción
            Nodo actual = primero;
            while (actual.siguiente != null && 
                   unaCadena.compareTo(actual.siguiente.cadena) > 0) {
                actual = actual.siguiente;
            }
            
            if (actual.siguiente != null && unaCadena.equals(actual.siguiente.cadena)) {
                // Actualizar cantidad del nodo existente
                actual.siguiente.cantidad += unaCantidad;
            } else {
                // Insertar nuevo nodo
                Nodo nuevo = new Nodo(unaCadena, unaCantidad);
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }
        }
    }
    
    public String cadenaConMayorCantidad() {
        if (primero == null) {
            return null;
        }
        
        Nodo mayor = primero;
        Nodo actual = primero.siguiente;
        
        while (actual != null) {
            if (actual.cantidad > mayor.cantidad) {
                mayor = actual;
            }
            actual = actual.siguiente;
        }
        
        return mayor.cadena;
    }
    
    public int cantidad(String unaCadena) {
        Nodo actual = primero;
        while (actual != null) {
            if (unaCadena.equals(actual.cadena)) {
                return actual.cantidad;
            }
            actual = actual.siguiente;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        if (primero == null) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder("{");
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.toString());
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("}");
        return sb.toString();
    }
}