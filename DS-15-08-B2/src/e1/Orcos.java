package e1;

public class Orcos extends Bestias {

    public Orcos(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }

    @Override
    public void ataque(Dado d,Heroes h){
        double narmor =h.getArmadura() * 0.9 ;
        int dan = d.Tirada() - (int)narmor;
        if(dan > 0 && h.getVida() > 0){
            h.setVida(h.getVida()-dan);
        }
    }
}
