package e1;

public class Elfos extends Heroes{

    public Elfos(String nombre,int armadura,int vida){
        super(nombre,armadura,vida);
    }
    @Override
    public void ataque(Dado d,Bestias b){
        int dan = d.Trucado(1) - b.getArmadura();
        if(b.getClass().equals(Orcos.class)){
            dan += 10;
        }
        if(dan > 0 && b.getVida() > 0){
            b.Attack(b.getVida() - dan);
        }
    }
}
