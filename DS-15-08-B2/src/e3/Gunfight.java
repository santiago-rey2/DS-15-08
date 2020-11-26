package e3;


import java.util.ArrayList;
import java.util.List;

public class Gunfight {

    private final List<String> batalla = new ArrayList<>();
    private final StringBuilder aux = new StringBuilder();

    public List<String> duel(Gunslinger g1,Gunslinger g2){
        int i = 0;
        boolean estavivo1 = true,estavivo2 = true;
        GunsLingerAction j1,j2;

        while(i < 50 && estavivo1 && estavivo2){

            aux.append("Round ").append(i).append("\n");
            aux.append(g1.getName()).append(" :");
            j1 = g1.action();
            aux.append(j1).append("\n");
            aux.append(g2.getName()).append(" :");
            j2 = g2.action();
            aux.append(j2).append("\n");

            g1.rivalAction(j2);
            g2.rivalAction(j1);

            batalla.add(aux.toString());
            aux.delete(0,aux.length());

            if(j1 == GunsLingerAction.SHOOT && j2 == GunsLingerAction.RELOAD ){
                estavivo2 = false;
                aux.append("The duel has ended \n");
                batalla.add(aux.toString());
                aux.delete(0,aux.length());
                aux.append("Winner :").append(g1.getName()).append("\n");
            }else if(j2 == GunsLingerAction.SHOOT && j1 == GunsLingerAction.RELOAD ){
                estavivo1 = false;
                aux.append("The duel has ended \n");
                batalla.add(aux.toString());
                aux.delete(0,aux.length());
                aux.append("Winner :").append(g2.getName()).append("\n");
            }else if(j1 == GunsLingerAction.SHOOT && j2 == GunsLingerAction.SHOOT){
                estavivo1 = false;
                estavivo2 = false;
                aux.append("EMPATE \n");
            }else if(j1 == GunsLingerAction.MACHINE_GUN && j2 == GunsLingerAction.MACHINE_GUN){
                estavivo1 = false;
                estavivo2 = false;
                aux.append("EMPATE \n");
            }else{
                aux.append("The duel continue \n");
            }

            batalla.add(aux.toString());
            aux.delete(0,aux.length());
            i++;
        }
        return batalla;
    }
}
