package e1;

import java.util.Random;

public class DadoTrucadoBestias extends Dado {

    private int semilla;
    Random r = new Random(semilla);

    public DadoTrucadoBestias(int s){
        this.semilla = s;
    }
    @Override
    public int Ataque(){
        return r.nextInt(91);
    }
}
