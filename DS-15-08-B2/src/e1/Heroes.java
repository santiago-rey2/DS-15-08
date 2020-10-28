package e1;

public abstract class Heroes extends Personajes {

    public Heroes(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    public Heroes(Personajes p){
        super(p);
    }
}
