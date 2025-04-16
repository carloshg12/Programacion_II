package Teoria.Tema3.Programas_Ejemplo;

import java.util.LinkedList;
import java.util.List;

public class Ej02ListasJava {

	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<Integer>(); // Probar también ArrayList

		long cantidad = 200000;
		for (int i = 1; i <= cantidad; i++) {
			lista.add(i);
		}

		System.out.println("Recorriendo posiciones");
		long inicio = System.currentTimeMillis();
		long suma = 0;
		for (int i = 0; i < lista.size(); i++) {
			int dato = lista.get(i);
			suma += dato;
		}
		long fin = System.currentTimeMillis();
		System.out.println("La suma vale: " + suma);
		System.out.println("Tiempo empleado (ms): " + (fin - inicio));

		System.out.println("Recorriendo elementos");
		inicio = System.currentTimeMillis();
		suma = 0;
		for (int dato : lista)
			suma += dato;
		fin = System.currentTimeMillis();
		System.out.println("La suma vale: " + suma);
		System.out.println("Tiempo empleado (ms): " + (fin - inicio));
	}

}
