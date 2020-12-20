package e1;


public class Program implements Estado{
    private static final Program instancia = new Program();
    private Program(){}
    public static Program getInstancia(){return instancia;}

    @Override
    public void cambiarEstado(Termostato t,Estado e){
        if(e == Manual.getInstancia()){
            t.setEstado(Manual.getInstancia());
            t.registrarDatos("Se activa el modo Manual.");
        }else if(e == Off.getInstancia()){
            t.setEstado(Off.getInstancia());
            t.registrarDatos("Se activa el modo Off.");
        }else{
            throw new UnsupportedOperationException("No permitido del cambio de Program a Timer");
        }
        t.getEstado().putOnOff(t);
    }

    @Override
    public void putOnOff(Termostato t){
        StringBuilder aux = new StringBuilder();
        if(t.getActualtemperature()< t.getProgramtemp()){
            t.setOnoff(true);
        }else{
            t.setOnoff(false);
        }
        aux.append(t.getActualtemperature());
        aux.append(" Modo Program ");
        aux.append(" (a ").append(t.getProgramtemp()).append(" grados) ");
        if(t.getOnOff()){
            aux.append("- Calefacción encendida.");
        }else{
            aux.append("- Calefacción apagada.");
        }
        t.registrarDatos(aux.toString());
    }
}
