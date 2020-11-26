package e1;

public class Hobbits extends Heroes {
    public Hobbits(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    @Override
    public void ataque(Dado d,Bestias b){
        int at = d.Tirada()-b.getArmadura();
        if(b.getClass().equals(Trasgos.class)){
            at -= 5;
        }
        if(at > 0 && b.getVida() > 0){
            b.setVida(b.getVida()- at);
        }
    }
}
