package e2;


import java.util.List;

public abstract class ElementosEquipos {

    private String nombre;

    public ElementosEquipos(String p){
        this.nombre = p;
    }

    public String getNombre() {
        return nombre;
    }
    public abstract float numHoras(String s);
    public abstract float coste(String s);
    public abstract void  actulizeWorkedHours(String s,float h);
    public abstract String getWorkers(String keymap);
    public abstract String getCoWorkers(Proyecto p);

}
