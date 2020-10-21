package e4;

public class TrafficLights {

    private final String nombre;
    private Estados luces;
    private Active estado;
    private int time;
    private boolean blink= false;

    public TrafficLights(String s,Estados e,Active a,int t){
       this.nombre = s;
       this.luces = e;
       this.estado =a;
       this.time = t;
    }
    public void changeLight(){
        if(!blink){
            if (luces.getNombre().equals(Estados.GREEN.getNombre()) && luces.getTiempo() < time){
               this.luces = Estados.AMBER;
                resetTime();
            }
            if (luces.getNombre().equals(Estados.AMBER.getNombre()) && luces.getTiempo() < time){
                this.luces = Estados.RED;
                changeActive();
                resetTime();
            }
            if (luces.getNombre().equals(Estados.RED.getNombre()) && luces.getTiempo() < time){
                this.luces = Estados.GREEN;
                resetTime();
            }
        }

    }
    public void changeActive(){
        if(this.getEstado().equals(Active.ON)){
            this.estado = Active.OFF;
        }else if(this.getEstado().equals(Active.OFF)){
            this.estado = Active.ON;
        }

    }
    public void setBlinkingAmber(){
        this.luces = Estados.AMBER;
        this.blink = true;
        resetTime();
    }
    public void resetTime(){
        this.time = 0;
    }
    public void updateTime(){
        this.time++;
    }

    public String getNombre() {
        return nombre;
    }

    public Estados getLuces() {
        return luces;
    }

    public Active getEstado() {
        return estado;
    }

    public int getTime() {
        return time;
    }
}
