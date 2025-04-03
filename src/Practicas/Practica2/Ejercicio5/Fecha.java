package Practicas.Practica2.Ejercicio5;

import java.util.Calendar;

public class Fecha {

    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia,int mes,int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha(Fecha otraFecha) {
        this(otraFecha.dia, otraFecha.mes, otraFecha.año);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

    @Override
    public boolean equals(Object otroObjeto){
        if (this == otroObjeto){
            return true;
        } else if (!(otroObjeto instanceof Fecha)) {
            return false;
        }else {
            Fecha otraFecha = (Fecha) otroObjeto;
            return this.dia == otraFecha.dia
                    && this.mes == otraFecha.mes
                    && this.año == otraFecha.año;

        }
    }

    public int compareTo(Fecha otraFecha) {
        if (año != otraFecha.año) {
            return año - otraFecha.año;
        }
        if (mes != otraFecha.mes) {
            return mes - otraFecha.mes;
        }
        return dia - otraFecha.dia;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public static boolean esBisiesto(int año){
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public static int diasMes(int mes, int año) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(año) ? 29 : 28;
            default:
                return -1; // Mes inválido
        }
    }

    public static Fecha hoy() {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR);
        return new Fecha(dia, mes, año);
    }

    public Fecha diaSiguiente(){

        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoAño = año;

        int diasMes = diasMes(mes,año);

        if (nuevoDia > diasMes){
            nuevoDia = 1;
            nuevoMes ++;
        }

        if (nuevoMes > 12){
            nuevoMes = 1;
            nuevoAño ++;
        }

        return new Fecha(nuevoDia, nuevoMes, nuevoAño);

    }
}
