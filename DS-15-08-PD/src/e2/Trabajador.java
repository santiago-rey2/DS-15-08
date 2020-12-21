package e2;

public class Trabajador extends ElementosEquipos{

    private float numHoras;
    private final float costo;

    //Constructor publico de un trabajor que tiene un numero fijo de coste por hora
    //y un numhoras trabajadas en un proyecto variable.
    public Trabajador(String nombre, int numHoras, int costo) {
        super(nombre);
        this.numHoras = numHoras;
        this.costo = costo;
    }

    //Redefinimos los metodos abstractos del interfaz
    //Devolvemos el numero de horas trabajadas
    @Override
    public float numHoras(){
        return numHoras;
    }
    //Devolvemos el coste po hora de  un trabajador
    @Override
    public float coste(){
        return costo;
    }
    //Como el numero de horas es varibale necesitamos un metodo que nosn permita
    //ir añadiendo horas
    public void setNumHoras(int h){
        this.numHoras +=h;
    }

}
