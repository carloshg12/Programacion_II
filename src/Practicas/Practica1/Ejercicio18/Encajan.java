package Practicas.Practica1.Ejercicio18;

import Practicas.Practica1.Ejercicio11.Ejercicio11;

public class Encajan {

    public static void main(String[] args) {
        String[] cadenas = {"rojo", "reja", "reza", "verde", "rrjj", "puja"};
        String[] resultado = encajan("r.j.", cadenas);
        
        for (String cadena : resultado) {
            System.out.println(cadena);
        }
    }

    public static String[] encajan(String patron, String[] cadenas) {
        int contador = 0;
        for (String cadena : cadenas) {
            if (Ejercicio11.encaja(patron, cadena)) {
                contador++;
            }
        }

        String[] resultado = new String[contador];
        int index = 0;
        for (String cadena : cadenas) {
            if (Ejercicio11.encaja(patron, cadena)) {
                resultado[index++] = cadena;
            }
        }
        
        return resultado;
    }
}
