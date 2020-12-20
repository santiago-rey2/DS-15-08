package e1;

public class Timer implements Estado{


    private static final Timer instancia = new Timer();
    private Timer(){}
    public static Timer getInstancia(){return instancia;}

    @Override
    public void cambiarEstado(Termostato t,Estado e) {
        if(e == Manual.getInstancia()){
            t.setEstado(Manual.getInstancia());
            t.registrarDatos("Se activa el modo Manual.");
        }else if(e == Off.getInstancia()){
            t.setEstado(Off.getInstancia());
            t.registrarDatos("Se activa el modo Off.");
        }else{
            throw new UnsupportedOperationException("No permitido del cambio de Timer a Program");
        }
        t.getEstado().putOnOff(t);
    }

    @Override
    public void putOnOff(Termostato t) {
        StringBuilder aux = new StringBuilder();
        if(t.getTime()>=t.getTimer()){
            t.setOnoff(false);
            t.registrarDatos("Se desactiva el modo Timer.");
        }else{
            t.setOnoff(true);
        }
        aux.append(t.getActualtemperature());
        aux.append(" Modo Timer ");
        aux.append(" (faltan ").append((t.getTimer()-t.getTime())).append(" minutos) ");
        if(t.getOnOff()){
            aux.append("- Calefacción encendida.");
        }else{
            aux.append("- Calefacción apagada.");
        }
        if((t.getTimer()-t.getTime()) > 0){
            t.registrarDatos(aux.toString());
        }else{
            t.setEstado(Off.getInstancia());
        }
    }
}
