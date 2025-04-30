package Practicas.Practica3.Ejercicio4; // Indica aquí el nombre del paquete que utilizas.

import Practicas.Practica3.Ejercicio3.TrabajoImpresora;

public interface ColaTrabajos {
    void insertar(TrabajoImpresora unTrabajo);
    TrabajoImpresora extraerPrimero();
    TrabajoImpresora consultarPrimero();
    int getTalla();
    boolean esVacía();
    void cancelar(String idUsuario);
    void adelantar(int idTrabajo);
}
