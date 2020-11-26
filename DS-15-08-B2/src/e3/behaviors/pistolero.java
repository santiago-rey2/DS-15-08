package e3.behaviors;

import e3.Behavior;
import e3.GunsLingerAction;
import e3.Gunslinger;

import java.util.ArrayList;
import java.util.List;

public class pistolero implements Behavior {

    @Override
    public GunsLingerAction action(Gunslinger g) {
        int last = g.getRivalActions().size();
         if( g.getRivalActions().size() > 0)
            last = g.getRivalActions().size() -1;
         else
            last = g.getRivalActions().size();

        if(g.getReloads() == 0 && g.getRivalActions().isEmpty()){
            return GunsLingerAction.RELOAD;
        }else if(g.getReloads() != 0 && g.getRivalActions().get(last) == GunsLingerAction.RELOAD ){
            return GunsLingerAction.PROTECT;
        }else if(g.getReloads() > 0 && g.getReloads() < 5 && g.getRivalActions().get(last) == GunsLingerAction.SHOOT ){
            return GunsLingerAction.SHOOT;
        }else if(g.getReloads() == 5){
            return GunsLingerAction.MACHINE_GUN;
        }
        return GunsLingerAction.RELOAD;
    }
}
