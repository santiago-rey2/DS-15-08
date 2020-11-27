package e1;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BatallaTest {

    Dado her = new Dado(1);
    Dado hernt = new Dado();
    Dado bes = new DadoBestias(1);
    Dado besnt = new DadoBestias();


    public Humanos h1 = new Humanos("Lazaro",60,200);
    public Hobbits h2 = new Hobbits("Malecum",15,100);
    public Elfos h3 = new Elfos("Edd",35,150);

    public Orcos b1 = new Orcos("Finals",40,300);
    public Trasgos b2 = new Trasgos("Terry",35,400);
    public Orcos b3 = new Orcos("Mikael",5,500);


    public Batalla battle = new Batalla();

    @Test
    void BattleTest(){
        System.out.println("Test Batalla Dado Trucado Ganan Heroes\n");
        List<String> juego;
        int i = 0;
        battle.addBeast(b1);
        battle.addBeast(b2);
        battle.addHero(h1);
        battle.addHero(h2);
        battle.addHero(h3);
        battle.addBeast(b3);
        juego = battle.Battle(bes,her);
        assertEquals(her.Tirada(),52);
        assertEquals(bes.Tirada(),16);
        while(juego.size()>i){
            System.out.println(juego.get(i));
            i++;
        }
        assertEquals(juego.get(0),"Turn 1\n" +
                "Fight between Lazaro (Energy=200) and Finals (Energy=300) \n" +
                "Fight between Malecum (Energy=100) and Terry (Energy=400) \n" +
                "Fight between Edd (Energy=150) and Mikael (Energy=500) \n");
        assertEquals(juego.get(1),"Turn 2\n" +
                "Fight between Lazaro (Energy=200) and Finals (Energy=243) \n" +
                "Fight between Malecum (Energy=76) and Terry (Energy=399) \n" +
                "Fight between Edd (Energy=96) and Mikael (Energy=418) \n");
        assertEquals(juego.get(2),"Turn 3\n" +
                "Fight between Lazaro (Energy=200) and Finals (Energy=243) \n" +
                "Fight between Malecum (Energy=1) and Terry (Energy=389) \n" +
                "Malecum dies\n");
        assertEquals(juego.get(3),"Turn 4\n" +
                "Fight between Lazaro (Energy=200) and Finals (Energy=202) \n" +
                "Fight between Edd (Energy=51) and Terry (Energy=386) \n");
        assertEquals(juego.get(4),"Turn 5\n" +
                "Fight between Lazaro (Energy=167) and Finals (Energy=202) \n" +
                "Fight between Edd (Energy=24) and Terry (Energy=366) \n" +
                "Edd dies\n");
        assertEquals(juego.get(5),"Turn 6\n" +
                "Fight between Lazaro (Energy=139) and Finals (Energy=171) \n");
        assertEquals(juego.get(6),"Turn 7\n" +
                "Fight between Lazaro (Energy=139) and Finals (Energy=140) \n");
        assertEquals(juego.get(7),"Turn 8\n" +
                "Fight between Lazaro (Energy=139) and Finals (Energy=124) \n");
        assertEquals(juego.get(8),"Turn 9\n" +
                "Fight between Lazaro (Energy=139) and Finals (Energy=116) \n");
        assertEquals(juego.get(9),"Turn 10\n" +
                "Fight between Lazaro (Energy=139) and Finals (Energy=96) \n");
        assertEquals(juego.get(10),"Turn 11\n" +
                "Fight between Lazaro (Energy=109) and Finals (Energy=86) \n");
        assertEquals(juego.get(11),"Turn 12\n" +
                "Fight between Lazaro (Energy=107) and Finals (Energy=48) \n");
        assertEquals(juego.get(12),"Turn 13\n" +
                "Fight between Lazaro (Energy=105) and Finals (Energy=5) \n" +
                "Finals dies\n");
        assertEquals(juego.get(13),"Turn 14\n" +
                "Fight between Lazaro (Energy=105) and Terry (Energy=313) \n");
        assertEquals(juego.get(14),"Turn 15\n" +
                "Fight between Lazaro (Energy=105) and Terry (Energy=265) \n");
        assertEquals(juego.get(15),"Turn 16\n" +
                "Fight between Lazaro (Energy=105) and Terry (Energy=238) \n");
        assertEquals(juego.get(16),"Turn 17\n" +
                "Fight between Lazaro (Energy=105) and Terry (Energy=178) \n");
        assertEquals(juego.get(17),"Turn 18\n" +
                "Fight between Lazaro (Energy=105) and Terry (Energy=144) \n");
        assertEquals(juego.get(18),"Turn 19\n" +
                "Fight between Lazaro (Energy=85) and Terry (Energy=94) \n");
        assertEquals(juego.get(19),"Turn 20\n" +
                "Fight between Lazaro (Energy=85) and Terry (Energy=41) \n");
        assertEquals(juego.get(20),"Turn 21\n" +
                "Fight between Lazaro (Energy=85) and Terry (Energy=10) \n" +
                "Terry dies\n");
        assertEquals(juego.get(21),"Turn 22\n" +
                "Fight between Lazaro (Energy=85) and Mikael (Energy=349) \n");
        assertEquals(juego.get(22),"Turn 23\n" +
                "Fight between Lazaro (Energy=56) and Mikael (Energy=267) \n");
        assertEquals(juego.get(23),"Turn 24\n" +
                "Fight between Lazaro (Energy=56) and Mikael (Energy=183) \n");
        assertEquals(juego.get(24),"Turn 25\n" +
                "Fight between Lazaro (Energy=56) and Mikael (Energy=157) \n");
        assertEquals(juego.get(25),"Turn 26\n" +
                "Fight between Lazaro (Energy=56) and Mikael (Energy=89) \n");
        assertEquals(juego.get(26),"Turn 27\n" +
                "Fight between Lazaro (Energy=56) and Mikael (Energy=70) \n");
        assertEquals(juego.get(27),"Turn 28\n" +
                "Fight between Lazaro (Energy=20) and Mikael (Energy=4) \n" +
                "Mikael dies\n");
        assertEquals(juego.get(28),"HEROES WINS\n");
    }
    @Test
    void BattleTest2(){
        System.out.println("Test Batalla Dado Trucado Ganan Bestias\n");
        List<String> juego;
        int i = 0;
        battle.addBeast(b1);
        battle.addBeast(b2);
        battle.addBeast(b3);
        battle.addHero(h1);
        juego = battle.Battle(bes,her);
        while(juego.size()>i){
            System.out.println(juego.get(i));
            i++;
        }
        assertEquals(juego.get(i-1),"BEAST WINS\n");
    }
    @Test
    void BattleTest3(){
        System.out.println("Test Batalla Dado Aleatorio\n");
        List<String> juego;
        int i = 0;
        battle.addBeast(b1);
        battle.addBeast(b2);
        battle.addHero(h1);
        battle.addHero(h2);
        battle.addHero(h3);
        battle.addBeast(b3);
        juego = battle.Battle(besnt,hernt);
        while(juego.size()>i){
            System.out.println(juego.get(i));
            i++;
        }

    }
}