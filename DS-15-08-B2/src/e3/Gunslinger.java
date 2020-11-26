package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {

    private Behavior decider;
    private final List<GunsLingerAction> rivalactions = new ArrayList<>();
    private int rival,reload;
    private final String nombre;

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
        return aux;
    }

    public int getReloads(){
        return reload;
    }

    public void rivalAction(GunsLingerAction action ){
        rivalactions.add(action);
        if(action.equals(GunsLingerAction.RELOAD))
            rival++;
        if(action.equals(GunsLingerAction.SHOOT))
            rival--;
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
