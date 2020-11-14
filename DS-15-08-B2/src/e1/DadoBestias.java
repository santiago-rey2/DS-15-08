package e1;

import java.util.Random;

public class DadoBestias extends Dado{

    private Random r = new Random();

    @Override
    public int Ataque(){
        return r.nextInt(91);
    }

}
