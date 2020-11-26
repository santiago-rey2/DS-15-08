package e1;

public class Elfos extends Heroes{

    public Elfos(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    @Override
    public void ataque(Dado d,Bestias b){
        int dan = d.Tirada() - b.getArmadura();
        if(b.getClass().equals(Orcos.class)){
            dan += 10;
        }
        if(dan > 0 && b.getVida() > 0){
            b.setVida(b.getVida() - dan);
        }
    }
}
