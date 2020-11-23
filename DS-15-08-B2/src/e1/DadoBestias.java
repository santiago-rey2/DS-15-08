package e1;

import java.util.Random;

public class DadoBestias extends Dado{

    private Random r;

    public DadoBestias(int semilla){
        r = new Random(semilla);
    }
    public DadoBestias(){
        r = new Random();
    }

    @Override
    public int Ataque(){
        return r.nextInt(91);
    }

}
