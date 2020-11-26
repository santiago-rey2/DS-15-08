package e3.behaviors;

import e3.Behavior;
import e3.GunsLingerAction;
import e3.Gunslinger;

public class pistolero2 implements Behavior {

    @Override
    public GunsLingerAction action(Gunslinger g) {
        int last = g.getRivalActions().size();
        if( g.getRivalActions().size() > 0)
            last = g.getRivalActions().size() -1;
        else
            last = g.getRivalActions().size();

        if(g.getReloads() == 0 && g.getRivalActions().isEmpty()){
            return GunsLingerAction.RELOAD;
        }else if(g.getReloads() != 0 ){
            return GunsLingerAction.SHOOT;
        }
        return GunsLingerAction.RELOAD;
    }
}
