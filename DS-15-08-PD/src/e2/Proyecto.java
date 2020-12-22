package e2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private String nombre;
    private Equipos trabajadores = new Equipos(nombre);

    public Proyecto(String s){
        this.nombre = s;
    }

    public void addWorkers(ElementosEquipos e){
        trabajadores.addWorker(e);
        e.actulizeWorkedHours(nombre,0);
    }
    public void removeWorkers(ElementosEquipos e){
        trabajadores.removeWorker(e);
    }
    public String getWorkerName() {
        return trabajadores.getWorkers(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public Equipos getTrabajadores() {
        return trabajadores;
    }

    public float getCoste(){
        return trabajadores.coste(nombre);
    }
}
