package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {
    Termostato termostato = new Termostato();
    @Test
    void termostatoTest(){
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.changeMode(Manual.getInstancia());
        assertEquals(termostato.getEstado(),Manual.getInstancia());
        assertTrue(termostato.getOnOff());
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        termostato.newTemperature(19);
        termostato.changeMode(Program.getInstancia());
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(19.3f);
        assertTrue(termostato.getOnOff());
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(19.5f);
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(19.7f);
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(19.9f);
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(20.4f);
        assertFalse(termostato.getOnOff());
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        termostato.changeMode(Timer.getInstancia());
        assertEquals(termostato.getEstado(),Timer.getInstancia());
        assertTrue(termostato.getOnOff());
        termostato.newTemperature(20);
        termostato.newTemperature(21);
        termostato.newTemperature(20);
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.newTemperature(19.7f);
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.newTemperature(19.3f);
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.newTemperature(18.8f);
        termostato.changeMode(Manual.getInstancia());
        assertEquals(termostato.getEstado(),Manual.getInstancia());
        assertTrue(termostato.getOnOff());
        termostato.changeMode(Off.getInstancia());
        assertEquals(termostato.getEstado(),Off.getInstancia());
        assertFalse(termostato.getOnOff());
        termostato.changeMode(Timer.getInstancia());
        assertThrows(new UnsupportedOperationException().getClass(),() -> termostato.changeMode(Timer.getInstancia()));
        assertThrows(new UnsupportedOperationException().getClass(),() -> termostato.changeMode(Program.getInstancia()));
        termostato.changeMode(Off.getInstancia());
        termostato.screenInfo();

    }
}