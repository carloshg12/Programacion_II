package Teoria.Tema1.Ejercicios_Clase;

public class Ej09For {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Tabla del " + i);
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}
	}

}
