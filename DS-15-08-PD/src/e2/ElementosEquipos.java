package e2;

public abstract class ElementosEquipos {

    private String nombre;

    public ElementosEquipos(String p){
        this.nombre = p;
    }

    public String getNombre() {
        return nombre;
    }
    public abstract float numHoras();
    public abstract float coste();

}
