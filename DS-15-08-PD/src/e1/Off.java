package e1;


public class Off implements Estado{
    private static final Off instancia = new Off();
    private Off(){}
    public static Off getInstancia(){return instancia;}

    @Override
    public void cambiarEstado(Termostato t,Estado e) {
        if(e == Manual.getInstancia()){
            t.setEstado(Manual.getInstancia());
            t.registrarDatos("Se activa el modo Manual.");
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
        StringBuilder aux = new StringBuilder();
        t.setOnoff(false);
        aux.append(t.getActualtemperature());
        aux.append(" Modo Off ");
        if(t.getOnOff()){
            aux.append("- Calefacción encendida.");
        }else{
            aux.append("- Calefacción apagada.");
        }
        t.registrarDatos(aux.toString());
    }
}
