package e1;

 import java.util.Random;

public class Dado {

    private final Random r ;
    public Dado(int semilla){
        r = new Random(semilla);
    }
    public Dado(){
        r = new Random();
    }

    public int Tirada(){
        return Math.max(r.nextInt(101),r.nextInt(101));
    }

}
