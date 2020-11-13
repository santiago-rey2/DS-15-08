package e1;

public abstract class Heroes extends Personajes {

    public Heroes(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }

    public void ataque(Dado d,Bestias b){
        int t = d.Trucado(1) - b.getArmadura();
        if(t > 0 && b.getVida() > 0 ){
            b.Attack(b.getVida() - t);
        }
    }
}
