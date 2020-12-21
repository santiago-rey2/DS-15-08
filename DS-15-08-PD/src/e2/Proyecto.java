package e2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private String nombre;
    private List<ElementosEquipos> trabajadores = new ArrayList<>();

    public Proyecto(String s){
        this.nombre = s;
    }
    public void addWorkers(ElementosEquipos e){
        trabajadores.add(e);
    }
    public void removeWorkers(ElementosEquipos e){
        trabajadores.remove(e);
    }


}
