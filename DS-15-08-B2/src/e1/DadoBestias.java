package e1;

import java.util.Random;

public class DadoBestias extends Dado{

    private Random r = new Random();

    @Override
    public int Ataque(){
        return r.nextInt(91);
    }

    @Override
    public int Trucado(int semilla){

        r = new Random(semilla);
        return r.nextInt(91);

    }
}
