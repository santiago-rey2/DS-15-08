package e2;

import java.util.ArrayList;

public class SubEquipo extends equipo {
    private final String nombre;
    private int numHoras;
    private int costo;
    private ArrayList<trabajador> trabajadores = new ArrayList<>();

    public SubEquipo(String nombre, int numHoras, int costo) {
        this.nombre = nombre;
        this.numHoras = numHoras;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }
    public int getNumHoras() {
        return numHoras;
        //numHoras del subequipo es el total de horas de los empleados
    }
    public int getCosto() {
        return costo;
        //costo del subequipo es el total del costo de los empleados
    }
}
