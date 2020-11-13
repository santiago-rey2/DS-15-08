package e1;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BatallaTest {
    public Humanos h1 = new Humanos("Lazaro",20,200);
    public Hobbits h2 = new Hobbits("Malecum",15,150);
    public Elfos h3 = new Elfos("Edd",35,150);

    public Orcos b1 = new Orcos("Finals",40,300);
    public Trasgos b2 = new Trasgos("Terry",35,400);

    public Batalla battle = new Batalla();

    @Test
    void BattleTest(){
        List<String> juego;
        int i = 0;
        battle.addBeast(b1);
        battle.addBeast(b2);
        battle.addHero(h1);
        battle.addHero(h2);
        battle.addHero(h3);
        juego = battle.Battle();
        while(juego.size()>i){
            System.out.println(juego.get(i));
            i++;
        }
        assertEquals(juego.get(i-1),"Turn 8\n" + "Fight between Lazaro (Energy=200) and Terry (Energy=53) \n" + "Terry dies\n" + "HEROES WINS\n");
    }
}