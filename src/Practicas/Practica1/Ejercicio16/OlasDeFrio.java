package Practicas.Practica1.Ejercicio16;

public class OlasDeFrio {

    // Método estático para contar las olas de frío
    public static int contarOlasDeFrio(double[] temperaturas, int n) {
        int contadorOlas = 0; // Contador de olas de frío
        int diasConsecutivos = 0; // Contador de días consecutivos con temperatura < 0

        // Recorremos el vector de temperaturas
        for (double temp : temperaturas) {
            if (temp < 0) {
                diasConsecutivos++; // Incrementamos el contador de días consecutivos
            } else {
                // Si la temperatura no es menor a 0, verificamos si hubo una ola de frío
                if (diasConsecutivos > n) {
                    contadorOlas++; // Incrementamos el contador de olas de frío
                }
                diasConsecutivos = 0; // Reiniciamos el contador de días consecutivos
            }
        }

        // Verificamos si hay una ola de frío al final del vector
        if (diasConsecutivos > n) {
            contadorOlas++;
        }

        return contadorOlas; // Devolvemos el número de olas de frío
    }

    // Método principal para probar el método contarOlasDeFrio
    public static void main(String[] args) {
        double[] temperaturas = {5.0, -1.0, -2.0, -3.0, 4.0, -5.0, -6.0, -7.0, -8.0, 10.0};
        int n = 2; // Número mínimo de días consecutivos para considerar una ola de frío

        int olasDeFrio = contarOlasDeFrio(temperaturas, n);
        System.out.println("Cantidad de olas de frio: " + olasDeFrio);
    }
}