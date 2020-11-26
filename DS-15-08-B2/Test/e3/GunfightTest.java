package e3;

import e3.behaviors.pistolero;
import e3.behaviors.pistolero2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {
    Gunslinger g1 = new Gunslinger("Moñeco");
    Gunslinger g2 = new Gunslinger("ESnorlax");
    pistolero p = new pistolero();
    pistolero2 p1 = new pistolero2();
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
        assertEquals(g1.getRivalsLoads(),g2.getReloads());
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
        assertEquals(list.get(i-1),"Winner :Moñeco\n");
    }
    @Test
    void gunFigthTest3(){
        int i = 0;
        g1.setBehavior(p1);
        g2.setBehavior(p);
        list = b.duel(g1,g2);
        while (i<list.size()){
            System.out.println(list.get(i));
            i++;
        }
        assertEquals(g1.getRivalsLoads(),g2.getReloads());
        assertEquals(list.get(i-1),"Winner :ESnorlax\n");
    }

}