package e1;

import java.util.*;

public class Batalla {

    private ArrayList<Heroes> ejercitoheroes = new ArrayList<>();
    private ArrayList<Bestias> ejercitobestias = new ArrayList<>();
    private Dado d1 = new Dado();
    private Dado d2 = new DadoBestias();

    public void addHero(Heroes h){
        this.ejercitoheroes.add(h);
    }
    public void addBeast(Bestias b){
        this.ejercitobestias.add(b);
    }

    public List<String> Battle(){

        List<String> battle = new ArrayList<>();
        int i,menor,k=0;
        StringBuilder juego = new StringBuilder();
        if(ejercitoheroes.size()< ejercitobestias.size()){
            menor = ejercitoheroes.size();
        }else{
            menor = ejercitobestias.size();
        }
        while (ejercitobestias.size()!=0 && ejercitoheroes.size()!=0){
            juego.delete(0,juego.length());
            juego.append("Turn " + (k+1) + "\n");
            i=0;
            while(i < menor){
                juego.append("Fight between " + ejercitoheroes.get(i).getNombre());
                juego.append(" (Energy=" + ejercitoheroes.get(i).getVida() + ")");
                juego.append(" and " + ejercitobestias.get(i).getNombre());
                juego.append(" (Energy=" + ejercitobestias.get(i).getVida() + ") \n");

                ejercitoheroes.get(i).ataque(d1,ejercitobestias.get(i));
                ejercitobestias.get(i).ataque(d2,ejercitoheroes.get(i));

                if(ejercitoheroes.get(i).getVida() < 0) {
                    juego.append(ejercitoheroes.get(i).getNombre() + " dies\n");
                    ejercitoheroes.remove(i);
                }
                if(ejercitobestias.get(i).getVida() < 0){
                    juego.append( ejercitobestias.get(i).getNombre() + " dies\n");
                    ejercitobestias.remove(i);
                }

                if(ejercitoheroes.size()< ejercitobestias.size()){
                    menor = ejercitoheroes.size();
                }else{
                    menor = ejercitobestias.size();
                }

                if(ejercitobestias.size()!=0){
                    if(ejercitoheroes.size()!=0) {

                    }else{
                        juego.append("BEAST WINS\n");
                    }

                }else{
                    juego.append("HEROES WINS\n");
                }
                i++;

            }
            battle.add(juego.toString());
            k++;
        }
        return  battle;
    }

}
