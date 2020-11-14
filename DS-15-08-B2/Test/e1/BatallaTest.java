package e1;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BatallaTest {
    Dado her = new DadoTrucado(1);
    Dado hernt = new Dado();
    Dado bes = new DadoTrucadoBestias(1);
    Dado besnt = new DadoBestias();


    public Humanos h1 = new Humanos("Lazaro",35,200);
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
        while(juego.size()>i){
            System.out.println(juego.get(i));
            i++;
        }
        assertEquals(juego.get(i-1),"HEROES WINS\n");
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