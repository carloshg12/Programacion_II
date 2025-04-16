package Practicas.Practica3.Ejercicio4_Falta; // Indica aquí el nombre del paquete que utilizas.

import Practicas.Practica3.Ejercicio3_Falta.TrabajoImpresora;

public interface ColaTrabajos {
    void insertar(TrabajoImpresora unTrabajo);
    TrabajoImpresora extraerPrimero();
    TrabajoImpresora consultarPrimero();
    int getTalla();
    boolean esVacía();
    void cancelar(String idUsuario);
    void adelantar(int idTrabajo);
}
