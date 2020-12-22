package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    Trabajador t1 = new Trabajador("Juan",20);
    Trabajador t2 = new Trabajador("Pepe",40);
    Trabajador t3 = new Trabajador("Wolf",1);
    Trabajador t4 = new Trabajador("Moñeco",200);
    Trabajador t5 = new Trabajador("Luis",130);
    Trabajador t6 = new Trabajador("Lulu",60);
    Trabajador t7 = new Trabajador("Oscar",60);
    Trabajador t8 = new Trabajador("Santi",60);
    Trabajador t9 = new Trabajador("Juanra",60);
    Trabajador t10 = new Trabajador("Juancar",60);
    Equipos    e1 = new Equipos("Team Comunismo");
    Equipos    e2 = new Equipos("Team Counter");
    Equipos    e3 = new Equipos("Team ApruebaDS");
    Equipos    e4 = new Equipos("Team Equipos");
    Proyecto   p1 = new Proyecto("Hombre");
    Proyecto   p2 = new Proyecto("Saalvemonos");

    @Test
    public void ProyectoTest(){
        e1.addWorker(t1);
        e1.addWorker(t2);
        e1.addWorker(t3);
        e2.addWorker(t4);
        e2.addWorker(t5);
        e2.addWorker(t6);
        e3.addWorker(t7);
        e3.addWorker(t8);
        e3.addWorker(t9);
        e4.addWorker(e3);
        p1.addWorkers(e1);
        p1.addWorkers(e2);
        p1.addWorkers(e4);
        assertThrows(new IllegalArgumentException().getClass(),()->p1.addWorkers(e4));
        p1.addWorkers(t10);
        e1.actulizeWorkedHours("Hombre",10);
        t1.actulizeWorkedHours("Hombre",50);
        System.out.println(p1.getWorkerName());
        assertEquals("Team Comunismo: 70.0 hours, 54100.0 €\nJuan: 50.0 hours, 1000.0 €\nPepe: 10.0 hours, 400.0 €\nWolf: 10.0 hours, 10.0 €\nTeam Counter: 0.0 hours, 0.0 €\nMoñeco: 0.0 hours, 0.0 €\nLuis: 0.0 hours, 0.0 €\nLulu: 0.0 hours, 0.0 €\nTeam Equipos: 0.0 hours, 0.0 €\nTeam ApruebaDS: 0.0 hours, 0.0 €\nOscar: 0.0 hours, 0.0 €\nSanti: 0.0 hours, 0.0 €\nJuanra: 0.0 hours, 0.0 €\nJuancar: 0.0 hours, 0.0 €\n",p1.getWorkerName());
        p1.removeWorkers(t10);
        System.out.println(p1.getWorkerName());
        assertEquals("Team Comunismo: 70.0 hours, 54100.0 €\nJuan: 50.0 hours, 1000.0 €\nPepe: 10.0 hours, 400.0 €\nWolf: 10.0 hours, 10.0 €\nTeam Counter: 0.0 hours, 0.0 €\nMoñeco: 0.0 hours, 0.0 €\nLuis: 0.0 hours, 0.0 €\nLulu: 0.0 hours, 0.0 €\nTeam Equipos: 0.0 hours, 0.0 €\nTeam ApruebaDS: 0.0 hours, 0.0 €\nOscar: 0.0 hours, 0.0 €\nSanti: 0.0 hours, 0.0 €\nJuanra: 0.0 hours, 0.0 €\n",p1.getWorkerName());
        assertEquals(p1.getNombre(),"Hombre");
        System.out.println(e1.getCoWorkers(p1));
        System.out.println(t1.getCoWorkers(p1));
    }
    @Test
    public void EquiposTest(){
        e1.addWorker(t1);
        e1.addWorker(t2);
        e1.addWorker(t3);
        System.out.println(e1.getTeamWorkers().get(0).getNombre());
        System.out.println(e1.getTeamWorkers().get(1).getNombre());
        System.out.println(e1.getTeamWorkers().get(2).getNombre());
        e3.addWorker(t7);
        e3.addWorker(t8);
        e3.addWorker(t9);
        e4.addWorker(e3);
        assertThrows(new IllegalArgumentException().getClass(),()->e3.addWorker(t7));
        assertEquals(e1.getTeamWorkers().get(0).getNombre(),"Juan");
        assertEquals(e1.getTeamWorkers().get(1).getNombre(),"Pepe");
        assertEquals(e1.getTeamWorkers().get(2).getNombre(),"Wolf");

    }
    @Test
    public void TrabajadoresTest(){
        assertNull(t1.getWorkers("Hombre"));
    }

}