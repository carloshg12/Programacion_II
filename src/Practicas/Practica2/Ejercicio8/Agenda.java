package Practicas.Practica2.Ejercicio8;

import Practicas.Practica2.Ejercicio6.Fecha;

public class Agenda {

    private Tarea[] tareas;
    private int cantidad;

    public Agenda() {
        tareas = new Tarea[0];
        cantidad = 0;
    }

    private int posicionInsercion(Tarea tarea) {
        for (int i = 0; i < cantidad; i++) {
            if (tarea.getFecha().compareTo(tareas[i].getFecha()) < 0) {
                return i;
            }
        }
        return cantidad;
    }

    public void añadir(Tarea tarea){

        Tarea[] nuevoArray = new Tarea[cantidad + 1];
        int posicion = posicionInsercion(tarea);

        for (int i = 0; i < posicion; i++) {
            nuevoArray[i] = tareas[i];
        }

        // Insertar la nueva tarea
        nuevoArray[posicion] = tarea;

        // Copiar elementos después de la posición de inserción
        for (int i = posicion; i < cantidad; i++) {
            nuevoArray[i + 1] = tareas[i];
        }

        tareas = nuevoArray;
        cantidad++;
    }

    public int cantidad() {
        return cantidad;
    }

    public Tarea[] consultar(Fecha fecha){

        int contador=0;

        for (Tarea t: tareas){
            if (t.getFecha().equals(fecha)){
                contador++;
            }
        }

        Tarea[] nuevoArray = new Tarea[contador];
        int contador2=0;
        for (Tarea t: tareas){
            if (t.getFecha().equals(fecha)){
                nuevoArray[contador2++] = t;
            }
        }
        return nuevoArray;
    }

    public void borrarPasadas(Fecha fecha){

        int contador=0;

        for (Tarea t: tareas){
            if (t.getFecha().compareTo(fecha) >= 0 ){
                contador ++;
            }
        }

        Tarea[] nuevoArray = new Tarea[contador];
        int contador2=0;
        for (Tarea t: tareas){
            if (t.getFecha().compareTo(fecha) >= 0 ){
                nuevoArray[contador2++] = t;
            }
        }

        tareas = nuevoArray;
        cantidad= contador2;
    }

    public void borrar(){
        Fecha hoy = Fecha.hoy();
        borrarPasadas(hoy);
    }

    @Override
    public String toString() {
        if (cantidad == 0) {
            return "";
        }

        String resultado = "";
        for (int i = 0; i < cantidad; i++) {
            resultado += tareas[i].toString();
            if (i < cantidad - 1) {
                resultado += "\n";
            }
        }
        return resultado;
    }
}
