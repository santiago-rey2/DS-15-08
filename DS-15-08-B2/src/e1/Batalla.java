package e1;

import java.util.*;

public class Batalla {

    private final ArrayList<Heroes> ejercitoheroes = new ArrayList<>();
    private final ArrayList<Bestias> ejercitobestias = new ArrayList<>();

    public void addHero(Heroes h){
        this.ejercitoheroes.add(h);
    }
    public void addBeast(Bestias b){
        this.ejercitobestias.add(b);
    }

    public List<String> Battle(Dado d2,Dado d1){

        List<String> battle = new ArrayList<>();
        int i,menor,k=0;
        StringBuilder juego = new StringBuilder();

        menor = Math.min(ejercitoheroes.size(), ejercitobestias.size());
        while (ejercitobestias.size()!=0 && ejercitoheroes.size()!=0){
            juego.append("Turn ").append(k + 1).append("\n");
            i=0;
            while(i < menor){
                juego.append("Fight between ").append(ejercitoheroes.get(i).getNombre());
                juego.append(" (Energy=").append(ejercitoheroes.get(i).getVida()).append(")");
                juego.append(" and ").append(ejercitobestias.get(i).getNombre());
                juego.append(" (Energy=").append(ejercitobestias.get(i).getVida()).append(") \n");

                ejercitoheroes.get(i).ataque(d1,ejercitobestias.get(i));

                if(ejercitobestias.get(i).getVida() <= 0){
                    juego.append(ejercitobestias.get(i).getNombre()).append(" dies\n");
                    ejercitobestias.remove(i);
                }else{
                    ejercitobestias.get(i).ataque(d2,ejercitoheroes.get(i));
                }

                if(ejercitoheroes.get(i).getVida() <= 0) {
                    juego.append(ejercitoheroes.get(i).getNombre()).append(" dies\n");
                    ejercitoheroes.remove(i);
                }

                menor = Math.min(ejercitoheroes.size(), ejercitobestias.size());
                i++;
            }
            battle.add(juego.toString());
            juego.delete(0,juego.length());

            if(ejercitobestias.size()==0){
                battle.add("HEROES WINS\n");

            }else if(ejercitoheroes.size()==0) {
                battle.add("BEAST WINS\n");
            }
            k++;
        }
        return  battle;
    }

}
