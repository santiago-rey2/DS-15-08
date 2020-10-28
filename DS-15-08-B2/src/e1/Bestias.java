package e1;

public abstract class Bestias extends Personajes {

    public Bestias(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    public Bestias(Personajes p){
        super(p);
    }

}
