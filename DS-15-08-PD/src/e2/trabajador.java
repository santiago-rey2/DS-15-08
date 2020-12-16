package e2;

public class trabajador extends equipo{
    private final String nombre;
    private int numHoras;
    private final int costo;

    public trabajador(String nombre, int numHoras, int costo) {
        this.nombre = nombre;
        this.numHoras = numHoras;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }
    public int getNumHoras() {
        return numHoras;
    }
    public int getCosto() {
        return costo;
    }
}
