package e4;

public enum Estados {

    GREEN("GREEN",15),
    RED("RED",20),
    AMBER("AMBER",5);

    private final String nombre;
    private final int tiempo;

    Estados(String s, int t){
        this.nombre = s;
        this.tiempo = t;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempo;
    }
}
