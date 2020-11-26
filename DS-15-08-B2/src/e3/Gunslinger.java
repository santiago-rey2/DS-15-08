package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {

    private Behavior decider;
    private List<GunsLingerAction> rivalactions = new ArrayList<>();
    private int rival,reload;
    private String nombre;

    public Gunslinger(String nom){
        this.nombre = nom;
    }
    public String getName(){
        return nombre;
    }

    public GunsLingerAction action(){
        GunsLingerAction aux = decider.action(this);
        if(aux == GunsLingerAction.RELOAD)
            reload++;
        if(aux == GunsLingerAction.SHOOT)
            reload--;
        if(aux == GunsLingerAction.MACHINE_GUN)
            reload = reload - 5;
        return aux;
    }

    public int getReloads(){
        return reload;
    }

    public void rivalAction(GunsLingerAction action ){
        rivalactions.add(action);
        if(action.equals(GunsLingerAction.RELOAD))
            rival++;
    }

    public List<GunsLingerAction> getRivalActions(){
        return rivalactions;
    }

    public int getRivalsLoads(){
        return rival;
    }

    public void setBehavior(Behavior behavior){
        this.decider = behavior;
    }
}
