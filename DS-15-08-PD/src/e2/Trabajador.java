package e2;

import java.util.HashMap;
import java.util.List;

public class Trabajador extends ElementosEquipos{

    private final float costo;
    private HashMap<String,Float> numHorasWorked = new HashMap<String,Float>();

    //Constructor publico de un trabajor que tiene un numero fijo de coste por hora
    //y un numhoras trabajadas en un proyecto variable.
    public Trabajador(String nombre, int costo) {
        super(nombre);
        this.costo = costo;
    }

    //Redefinimos los metodos abstractos del interfaz
    //Devolvemos el numero de horas trabajadas
    @Override
    public float numHoras(String keymap){
        return numHorasWorked.get(keymap);
    }
    //Devolvemos el coste po hora de  un trabajador
    @Override
    public float coste(String keymap){
        return costo * numHorasWorked.get(keymap);
    }
    //Actualizamos las horas trabajadas por un obrero en un projecto
    @Override
    public void actulizeWorkedHours(String s,float h){
        if(numHorasWorked.containsKey(s)){
            numHorasWorked.put(s,h);
        }else{
            numHorasWorked.put(s,h);
        }
    }

    @Override
    public String getWorkers(String s) {
        return null;
    }

    @Override
    public String getCoWorkers(Proyecto p) {
        String aux="";
        String keymap = p.getNombre();
        int i = 0;
        while(i < p.getTrabajadores().getTeamWorkers().size()){
            if(p.getTrabajadores().getTeamWorkers().get(i).getClass() == Equipos.class){
                aux += p.getTrabajadores().getTeamWorkers().get(i).getWorkers(keymap);
            }
            i++;
        }
        return aux;
    }
}
