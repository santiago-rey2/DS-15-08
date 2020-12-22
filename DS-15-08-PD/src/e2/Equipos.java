package e2;

import java.util.ArrayList;
import java.util.List;

public class Equipos extends ElementosEquipos {

    private List<ElementosEquipos> trabajadores = new ArrayList<>();

    //constructor de un equipo que necesita un nombre
    public Equipos(String nombre) {
        super(nombre);
    }
    public List<ElementosEquipos> getTeamWorkers(){
        return trabajadores;
    }

    //Calculamos las horas totales del equipo
    @Override
    public float numHoras(String s){
         float n = 0;
         for(ElementosEquipos t : trabajadores){
             n+= t.numHoras(s);
         }
         return n;
    }
    //Calculamos el coste total del equipo
    @Override
    public float coste(String keymap){
        float n = 0;
        for(ElementosEquipos t : trabajadores){
            n += t.coste(keymap);
        }
        return n;
    }

    @Override
    public void actulizeWorkedHours(String s,float h){
        int i = 0;
        while (i<trabajadores.size()){
            trabajadores.get(i).actulizeWorkedHours(s,h);
            i++;
        }
    }

    public void addWorker(ElementosEquipos e) {
        if(!trabajadores.contains(e)){
            trabajadores.add(e);
        }else{
            throw new IllegalArgumentException("El trabajador ya pertenece al equipo");
        }
    }


    public void removeWorker(ElementosEquipos e) {
        if(e!= null && trabajadores.contains(e)){
            trabajadores.remove(e);
        }else{
            throw new IllegalArgumentException("El trabajador no pertenece al equipo o ya ha sido eliminado con anterioridad");
        }
    }

    @Override
    public String getWorkers(String keymap) {
        String aux ="";
        for(ElementosEquipos e : trabajadores){
            if(e.getClass()==Equipos.class){
                aux= aux +e.getNombre()+": "+e.numHoras(keymap)+" hours, "+e.coste(keymap)+" €\n";
                aux +=  e.getWorkers(keymap);
            }else{
                aux+= e.getNombre()+": "+e.numHoras(keymap)+" hours, "+e.coste(keymap)+" €\n";
            }

        }
        return aux;
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
