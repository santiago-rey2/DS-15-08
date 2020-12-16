package e3.behaviors;

import e3.Behavior;
import e3.GunsLingerAction;
import e3.Gunslinger;

public class DS_15_08 implements Behavior {

    public DS_15_08(){}

    @Override
    public GunsLingerAction action(Gunslinger g) {
        int last;
        if( g.getRivalActions().size() > 0)
            last = g.getRivalActions().size() -1;
        else
            last = g.getRivalActions().size();

        if(g.getReloads()==0 && g.getRivalsLoads()== 0){
            return GunsLingerAction.RELOAD;
        }else if(g.getRivalsLoads() == 0 && g.getReloads() > 0 && g.getRivalActions().get(last).equals(GunsLingerAction.PROTECT)){
            return GunsLingerAction.SHOOT;
        }else if(g.getRivalsLoads() == 0 ){
            return GunsLingerAction.RELOAD;
        }else if(g.getReloads() == 5){
            return GunsLingerAction.MACHINE_GUN;
        }else if(g.getRivalsLoads() < 4 ){
            return GunsLingerAction.PROTECT;
        }else if(g.getRivalActions().get(last).equals(GunsLingerAction.SHOOT)){
            return GunsLingerAction.SHOOT;
        }
        return GunsLingerAction.RELOAD;
    }
}
