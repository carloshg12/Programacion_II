package Teoria.Tema3.Programas_Ejemplo;


public class Ej03PilaStringPruebas {

	public static void main(String[] args) {

		String[] nombres = { "Toni", "Begoña", "José" };

		PilaString pila = new PilaStringNodos();

		for (int i = 0; i < nombres.length; i++)
			pila.apilar(nombres[i]);

		while (!pila.esVacía())
			System.out.println(pila.desapilar());
	}

}
