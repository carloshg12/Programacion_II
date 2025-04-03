package Practicas.Practica2.Ejercicio8;

import Practicas.Practica2.Ejercicio6.Fecha;

public class Tarea {

    private Fecha fecha;
    private String descripcion;

    public Tarea(Fecha fecha, String descripcion){
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return fecha.toString() + ": " + descripcion;
    }
}
