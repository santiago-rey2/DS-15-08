package e3;

import e3.behaviors.pistolero;
import e3.behaviors.pistolero2;
import e3.behaviors.DS_15_08;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {
    Gunslinger g1 = new Gunslinger("Moñeco");
    Gunslinger g2 = new Gunslinger("ESnorlax");
    pistolero p = new pistolero();
    pistolero2 p1 = new pistolero2();
    DS_15_08 prueba = new DS_15_08();
    Gunfight b = new Gunfight();
    List<String> list = new ArrayList<>();

    @Test
    void gunFigthTest(){
        int i = 0;
        g1.setBehavior(p);
        g2.setBehavior(p);
        list = b.duel(g1,g2);
        while (i<list.size()){
            System.out.println(list.get(i));
            i++;
        }
        assertEquals(g1.getName(),"Moñeco");
        assertEquals(g2.getName(),"ESnorlax");
        //En este caaso aplicamos un behavior donde ambos jugadores ejecutan
        // el mismo procedimiento es el mismo por lo que podemos observar si las acciones de ambos son las mismas
        assertEquals(g1.getRivalActions(),g2.getRivalActions());
        assertEquals(g1.getRivalsLoads(),g2.getReloads());
        assertEquals(g2.getRivalsLoads(),g1.getReloads());
        assertEquals(list.get(i-1),"EMPATE \n");
    }
    @Test
    void gunFigthTest2(){
        int i = 0;
        g1.setBehavior(p);
        g2.setBehavior(p1);
        list = b.duel(g1,g2);
        while (i<list.size()){
            System.out.println(list.get(i));
            i++;
        }
        assertEquals(g1.getRivalsLoads(),g2.getReloads());
        assertEquals(g2.getRivalsLoads(),g1.getReloads());
        assertEquals(list.get(i-1),"Winner :Moñeco\n");
    }
    @Test
    void gunFigthTest3(){
        int i = 0;
        g1.setBehavior(p1);
        g2.setBehavior(prueba);
        list = b.duel(g1,g2);
        while (i<list.size()){
            System.out.println(list.get(i));
            i++;
        }
        assertEquals(g1.getRivalsLoads(),g2.getReloads());
        assertEquals(g2.getRivalsLoads(),g1.getReloads());
        assertEquals(list.get(i-1),"Winner :ESnorlax\n");
    }

}