package e1;

import java.util.ArrayList;
import java.util.List;

public class Termostato {

     private Estado estado;
     private float actualtemperature;
     private float time;
     private final float timer;
     private final float programtemp;//Las variables time y timer sinvolizan timepo transcurrido y el de espera respectivamente dado en minutos
     private boolean onoff;
     private final ArrayList<String> registro = new ArrayList<>();

     /*Vamos a crear una instancia del termostato con el constructor que sera un termostato
     * estandar con unos vaalores por defecto que sera estar apago al principio definimos un tiempo
     * para el timer de 15 min y una temperatura para el program de 25 grados por defecto
     * pero estos parametros podran ser variados conm unas funcionas especificas en caso de que
     * el usuario quiera cambiar alguno de los mismos*/
     public Termostato(){
         this.timer = 15;
         this.time = 0;
         this.actualtemperature = 20;
         this.programtemp = 20;
         this.estado = Off.getInstancia();
         this.estado.putOnOff(this);
     }

     /*Este método es utilzado para la actulizacion periodica de los valores internos del termostato */
     public void newTemperature(float currenttemperature){
         this.actualtemperature = currenttemperature;
         this.time += 5; //Cada vez que actualizamos la informacion pasan 5 minutos de tiempo
         this.estado.putOnOff(this);
     }
     public List<String> screenInfo(){
        return registro;
     }
     public void changeMode(Estado newestate){
         this.estado.cambiarEstado(this,newestate);
     }

     public Estado getEstado(){
         return estado;
     }
     public float getTime(){
         return time;
     }
     public float getTimer(){
         return timer;
     }
     public float getActualtemperature(){
         return actualtemperature;
     }
     public float getProgramtemp(){
         return programtemp;
     }
     public boolean getOnOff(){
         return onoff;
     }
     public void setEstado(Estado e){
         this.estado = e;
     }
     public void setTime(float t){
         this.time = t;
     }
     public void setOnoff(boolean b){
         this.onoff = b;
     }
     public void registrarDatos(String s){
         registro.add(s);
     }

}
