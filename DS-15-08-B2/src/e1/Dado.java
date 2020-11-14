package e1;

 import java.util.Random;

public class Dado {

    private Random r = new Random();

    public int Ataque(){
        return Math.max(r.nextInt(101),r.nextInt(101));
    }

}
