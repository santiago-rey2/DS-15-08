package e1;

 import java.util.Random;

public class Dado {

    private Random r = new Random();

    public int Ataque(){
        return r.nextInt(101);
    }
    public int Trucado(int semilla){
         r = new Random(semilla);
        return r.nextInt(101);
    }

}
