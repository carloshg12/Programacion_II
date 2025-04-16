package Practicas.Practica3.Ejercicio3_Falta; // Indica aquí el nombre del paquete que utilizas.

public interface ColaTrabajos {
    void insertar(TrabajoImpresora unTrabajo);
    TrabajoImpresora extraerPrimero();
    TrabajoImpresora consultarPrimero();
    int getTalla();
    boolean esVacía();
    // ATENCIÓN: Descomenta estas líneas para el ejercicio 4:
    // void cancelar(String idUsuario);
    // void adelantar(int idTrabajo);
}
