package Practicas.Practica3.Ejercicio3; // Indica aquí el nombre del paquete que utilizas.

public interface ColaTrabajos {
    void insertar(TrabajoImpresora unTrabajo);
    TrabajoImpresora extraerPrimero();
    TrabajoImpresora consultarPrimero();
    int getTalla();
    boolean esVacía();
}
