package Practicas.Practica3.Ejercicio4_Falta; // Indica aquí el nombre del paquete que utilizas.

import Practicas.Practica3.Ejercicio3_Falta.TrabajoImpresora;

public class ColaTrabajosPrueba {
    /*public static void main(String[] args) {
        ColaTrabajos c = new ColaTrabajosEnlaceSimple();

        System.out.println("La cola inicialmente está vacía:\n  " + c);
        comprueba(c, "[]");

        c.insertar(new TrabajoImpresora(1, "Bill"));
        c.insertar(new TrabajoImpresora(2, "Jeff"));
        c.insertar(new TrabajoImpresora(3, "Mark"));
        c.insertar(new TrabajoImpresora(4, "Larry"));
        c.insertar(new TrabajoImpresora(5, "Sergey"));
        c.insertar(new TrabajoImpresora(6, "Jeff"));
        System.out.println("Añadimos 6 trabajos y la cola queda así:\n  " + c);

        comprueba(c, "[1/Bill -> 2/Jeff -> 3/Mark -> 4/Larry -> 5/Sergey -> 6/Jeff]");

        TrabajoImpresora extraído = c.extraerPrimero();
        System.out.println("Extraemos el primero: \n  " + extraído);
        if (extraído.toString().equals("1/Bill")) {
            System.out.println("  (ok)");
        } else {
            System.out.println("  *** Detectado error: Se esperaba «1/Bill» pero se ha obtenido «" + extraído + "»");
        }
        System.out.println(" y la cola queda así:\n  " + c);
        comprueba(c, "[2/Jeff -> 3/Mark -> 4/Larry -> 5/Sergey -> 6/Jeff]");

        TrabajoImpresora consultado = c.consultarPrimero();
        System.out.println("Consultamos el primero: \n  " + consultado);
        if (consultado.toString().equals("2/Jeff")) {
            System.out.println("  (ok)");
        } else {
            System.out.println("  *** Detectado error: Se esperaba «2/Jeff» pero se ha obtenido «" + consultado + "»");
        }
        System.out.println("y la cola queda así:\n  " + c);
        comprueba(c, "[2/Jeff -> 3/Mark -> 4/Larry -> 5/Sergey -> 6/Jeff]");

        // Probamos los nuevos métodos del ejercicio 4:
        c.cancelar("Jeff");
        System.out.println("Eliminamos los trabajos de Jeff y la cola queda así:\n  " + c);
        comprueba(c, "[3/Mark -> 4/Larry -> 5/Sergey]");

        c.insertar(new TrabajoImpresora(7, "Warren"));
        System.out.println("Añadimos 1 trabajo y la cola queda así:\n  " + c);
        comprueba(c, "[3/Mark -> 4/Larry -> 5/Sergey -> 7/Warren]");

        c.cancelar("Manuel");
        System.out.println("Cancelamos los inexistentes trabajos de Manuel y la cola queda así:\n  " + c );
        comprueba(c, "[3/Mark -> 4/Larry -> 5/Sergey -> 7/Warren]");

        c.cancelar("Warren");
        c.cancelar("Larry");
        c.cancelar("Mark");
        System.out.println("Cancelamos los trabajos de Warren, Larry y Mark y la cola queda así:\n  " + c);
        comprueba(c, "[5/Sergey]");

        c.cancelar("Sergey");
        System.out.println("Cancelamos los trabajos de Sergey y la cola queda así:\n  " + c);
        comprueba(c, "[]");

        c.insertar(new TrabajoImpresora(8, "Elon"));
        c.insertar(new TrabajoImpresora(9, "Bernard"));
        c.insertar(new TrabajoImpresora(10, "Amancio"));
        System.out.println("Después de cancelar, añadimos 3 trabajos y la cola queda así:\n  " + c);
        comprueba(c, "[8/Elon -> 9/Bernard -> 10/Amancio]");

        c.adelantar(8);
        System.out.println("Adelantamos el trabajo 8 y la cola queda así:\n  " + c);
        comprueba(c, "[8/Elon -> 9/Bernard -> 10/Amancio]");

        c.adelantar(50);
        System.out.println("Adelantamos el inexistente trabajo 50 y la cola queda así:\n  " + c);
        comprueba(c, "[8/Elon -> 9/Bernard -> 10/Amancio]");

        c.adelantar(9);
        System.out.println("Adelantamos el trabajo 9 y la cola queda así:\n  " + c);
        comprueba(c, "[9/Bernard -> 8/Elon -> 10/Amancio]");

        c.adelantar(10);
        System.out.println("Adelantamos el trabajo 10 y la cola queda así:\n  " + c);
        comprueba(c, "[10/Amancio -> 9/Bernard -> 8/Elon]");

        c.insertar(new TrabajoImpresora(11, "Sandra"));
        System.out.println("Después de adelantar, añadimos 1 trabajo y la cola queda así:\n  " + c);
        comprueba(c, "[10/Amancio -> 9/Bernard -> 8/Elon -> 11/Sandra]");
    }

        public static void comprueba(ColaTrabajos cola, String valorCorrecto) {
        if (cola.toString().equals(valorCorrecto)) {
            System.out.println("  (ok)\n");
        } else {
            System.out.println("  *** Detectado error: Se esperaba " + valorCorrecto
                    + " pero se ha obtenido " + cola + "\n");
        }
    }
*/
}
