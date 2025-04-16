package Teoria.Tema3.Programas_Ejemplo;

public interface Conjunto {

	boolean esVacío();

	int cardinalidad();

	void insertar(int elemento);

	boolean contiene(int elemento);

	void borrar(int elemento);

	void borrar();

}
