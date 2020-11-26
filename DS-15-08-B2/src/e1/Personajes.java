package e1;

public abstract class Personajes {

    private int vida;
    private int armadura;
    private  String nombre;

    public Personajes(String nombre,int armadura,int vida){
        this.nombre = nombre;
        this.armadura = armadura;
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public int getArmadura() {
        return armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVida(int a){this.vida = a;}

}
