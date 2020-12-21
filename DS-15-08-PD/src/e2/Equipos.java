package e2;

import java.util.ArrayList;
import java.util.List;

public class Equipos extends ElementosEquipos {

    private List<ElementosEquipos> trabajadores = new ArrayList<>();

    //constructor de un equipo que necesita un nombre
    public Equipos(String nombre) {
        super(nombre);
    }
    //Método de introducir empleados al equipo o en su defecto nuevos subequipos
    public void addTrabajador(ElementosEquipos p){
        if(!trabajadores.contains(p)){
            trabajadores.add(p);
        }else{
            throw new IllegalArgumentException("El trabajador ya pertenece aal equipo");
        }
    }
    //Método de eliminar empleados al equipo o en su defecto nuevos subequipos
    public void deleteTrabajador(ElementosEquipos p){
        if(p!= null && trabajadores.contains(p)){
            trabajadores.remove(p);
        }else{
            throw new IllegalArgumentException("El trabajador no pertenece al equipo o ya ha sido eliminado con anterioridad");
        }
    }
    //Podemos tambien obtener todos los trabajadores de un equipo
    public ElementosEquipos getTrabjador(int i){
        if(i < trabajadores.size()){
            return trabajadores.get(i);
        }else{
            throw new ArrayIndexOutOfBoundsException("No tenemos tantos trabajadores");
        }

    }
    //Sobreescribimos los metodos abstractos de la insterfaz

    //Calculamos las horas totales del equipo
    @Override
    public float numHoras(){
         float n = 0;
         for(ElementosEquipos t : trabajadores){
             n+= t.numHoras();
         }
         return n;
    }
    //Calculamos el coste total del equipo
    @Override
    public float coste(){
        float n = 0;
        for(ElementosEquipos t : trabajadores){
            n += t.coste() * t.numHoras();
        }
        return n;
    }
}
