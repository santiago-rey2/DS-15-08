package e1;

import java.util.Random;

public class DadoTrucado extends  Dado{

    private int semilla;
    Random r = new Random(semilla);

    public DadoTrucado(int s){
        this.semilla = s;
    }
    @Override
    public int Ataque(){

        return Math.max(r.nextInt(101),r.nextInt(101));
    }


}
