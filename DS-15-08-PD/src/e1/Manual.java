package e1;

public class Manual implements Estado {
    private static final Manual instancia = new Manual();
    private Manual(){}
    public static Manual getInstancia(){return instancia;}
    private StringBuilder aux = new StringBuilder();
    @Override
    public void cambiarEstado(Termostato t,Estado e) {

        if(e == Off.getInstancia()){
            t.setEstado(Off.getInstancia());
            t.registrarDatos("Se activa el modo Off.");
        }else if(e == Program.getInstancia()){
            t.setEstado(Program.getInstancia());
            t.registrarDatos("Se activa el modo Program a "+t.getProgramtemp()+" grados.");
        }else if(e == Timer.getInstancia()){
            t.setEstado(Timer.getInstancia());
            t.setTime(0);
            t.registrarDatos("Se activa el modo Timer " + t.getTimer() + " minutos.");
        }
        t.getEstado().putOnOff(t);
    }

    @Override
    public void putOnOff(Termostato t) {
        t.setOnoff(true);
        aux.append(t.getActualtemperature());
        aux.append(" Modo Manual ");
        if(t.getOnOff()){
            aux.append("- Calefacción encendida.");
        }else{
            aux.append("- Calefacción apagada.");
        }
        t.registrarDatos(aux.toString());
    }
}
