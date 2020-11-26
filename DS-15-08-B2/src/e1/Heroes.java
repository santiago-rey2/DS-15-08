package e1;

public abstract class Heroes extends Personajes {

    public Heroes(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }

    public void ataque(Dado d,Bestias b){
        int t = d.Tirada() - b.getArmadura();
        if(t > 0 && b.getVida() > 0 ){
            b.setVida(b.getVida() - t);
        }
    }
}
