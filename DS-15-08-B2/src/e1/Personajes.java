package e1;

import java.util.Objects;

public class Personajes {

    private int vida;
    private int armadura;
    private  String nombre;

    public Personajes(String nombre,int armadura,int vida){
        this.nombre = nombre;
        this.armadura = armadura;
        this.vida = vida;
    }

    public Personajes(Personajes p) {
        this.nombre = p.getNombre();
        this.armadura = p.getArmadura();
        this.vida = p.getVida();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personajes)) return false;
        Personajes that = (Personajes) o;
        return getVida() == that.getVida();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVida());
    }
}
