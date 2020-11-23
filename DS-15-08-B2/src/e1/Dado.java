package e1;

 import java.util.Random;

public class Dado {

    private Random r ;
    public Dado(int semilla){
        r = new Random(semilla);
    }
    public Dado(){
        r = new Random();
    }

    public int Ataque(){
        return Math.max(r.nextInt(101),r.nextInt(101));
    }

}
