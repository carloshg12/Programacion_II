package Practicas.Practica2.Ejercicio6;

import java.util.Scanner;

public class LeerFecha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Fecha fecha = null;
        do {
            System.out.format("Introduce una fecha (año entre %d y %d):%n", Fecha.PRIMER_AÑO, Fecha.ÚLTIMO_AÑO);
            System.out.print("  Día: ");  int día = teclado.nextInt();
            System.out.print("  Mes: ");  int mes = teclado.nextInt();
            System.out.print("  Año: ");  int año = teclado.nextInt();
            try {
                fecha = new Fecha(día, mes, año);

                Fecha fechaActual = Fecha.hoy();
                int comparacion = fecha.compareTo(fechaActual);

                if (comparacion < 0) {
                    System.out.println("La fecha introducida es ANTERIOR a la fecha actual");
                } else if (comparacion > 0) {
                    System.out.println("La fecha introducida es POSTERIOR a la fecha actual");
                } else {
                    System.out.println("La fecha introducida es IGUAL a la fecha actual");
                }

            } catch (ExcepcionFechaNoValida e) {
                System.out.println("Los valores no representan una fecha. Inténtalo de nuevo\n");
            }
        } while (fecha == null);

        System.out.println("\nLa fecha leída es " + fecha);
    }
}
