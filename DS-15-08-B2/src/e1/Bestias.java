package e1;

public abstract class Bestias extends Personajes {

    public Bestias(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    public void ataque(Dado d,Heroes h){
        int t = d.Tirada() - h.getArmadura();
        if(t > 0 && h.getVida() > 0){
            h.setVida(h.getVida()-t);
        }
    }
}
