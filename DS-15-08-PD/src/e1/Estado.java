package e1;

public interface Estado {
    void cambiarEstado(Termostato t,Estado e);
    void putOnOff(Termostato t);
}
