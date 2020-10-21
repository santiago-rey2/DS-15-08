package e4;

public class TrafficJunction {

    private TrafficLights north;
    private TrafficLights south;
    private TrafficLights east;
    private TrafficLights west;
    private boolean parpadeo;

    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west. The north traffic light has just started its green cycle .
     */
    public TrafficJunction () {

        //Inicializamos los semaforos con el norte verde y el resto en rojo
        north = new TrafficLights("NORTH",Estados.GREEN,Active.ON,0);
        south = new TrafficLights("SOUTH",Estados.RED,Active.OFF,0);
        east = new TrafficLights("EAST",Estados.RED,Active.OFF,0);
        west = new TrafficLights("WEST",Estados.RED,Active.OFF,0);
    }
    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy () {
        north.updateTime();
        south.updateTime();
        east.updateTime();
        west.updateTime();

        if (north.getEstado().equals(Active.ON)){
            north.changeLight();
            if(north.getLuces().equals(Estados.RED))
                south.changeActive();
        }
        if (south.getEstado().equals(Active.ON)){
            south.changeLight();
            if(south.getLuces().equals(Estados.RED))
                east.changeActive();
        }
        if (east.getEstado().equals(Active.ON)){
            east.changeLight();
            if(east.getLuces().equals(Estados.RED))
                west.changeActive();
        }
        if (west.getEstado().equals(Active.ON)){
            west.changeLight();
            if(west.getLuces().equals(Estados.RED))
                north.changeActive();
        }

    }
    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction ( boolean active ) {
        parpadeo = active;
        if(parpadeo){
            north.setBlinkingAmber();
            south.setBlinkingAmber();
            east.setBlinkingAmber();
            west.setBlinkingAmber();
        }else{
            north = new TrafficLights("NORTH",Estados.GREEN,Active.ON,0);
            south = new TrafficLights("SOUTH",Estados.RED,Active.OFF,0);
            east = new TrafficLights("EAST",Estados.RED,Active.OFF,0);
            west = new TrafficLights("WEST",Estados.RED,Active.OFF,0);
        }


    }
    /**
     * Returns a String with the state of the traffic lights .
     * The format for each traffic light is the following :
     * - For red colors : "[ name: RED ]"
     * - For green colors : "[ name: GREEN counter ]"
     * - For yellow colors with blink at OFF: "[ name: YELLOW OFF counter ]
     * - For yellow colors with blink at ON: "[ name: YELLOW ON]
     * Examples :
     * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST: RED ][ WEST: RED]
     * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST: RED ][ WEST: RED]
     * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST: AMBER ON ][ WEST: AMBER ON]
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () {
        StringBuilder aux = new StringBuilder();
        //Añadimos los datos de North
        aux.append("[");
        aux.append(north.getNombre());
        aux.append(": ");
        aux.append(north.getLuces().getNombre());
        if(north.getLuces().equals(Estados.GREEN)){
            aux.append(" ");
            aux.append(north.getTime());
        }
        if(north.getLuces().equals(Estados.AMBER)){
            if(parpadeo){
                aux.append(" ");
                aux.append("ON");
            }else{
                aux.append(" ");
                aux.append("OFF");
                aux.append(" ");
                aux.append(north.getTime());
            }

        }

        aux.append("]");
        //Añadimos los datos de south
        aux.append("[");
        aux.append(south.getNombre());
        aux.append(": ");
        aux.append(south.getLuces().getNombre());
        if(south.getLuces().equals(Estados.GREEN)){
            aux.append(" ");
            aux.append(south.getTime());
        }
        if(south.getLuces().equals(Estados.AMBER)){
            if(parpadeo){
                aux.append(" ");
                aux.append("ON");
            }else{
                aux.append(" ");
                aux.append("OFF");
                aux.append(" ");
                aux.append(south.getTime());
            }

        }
        aux.append("]");
        //Añadimos los datos de east
        aux.append("[");
        aux.append(east.getNombre());
        aux.append(": ");
        aux.append(east.getLuces().getNombre());
        if(east.getLuces().equals(Estados.GREEN)){
            aux.append(" ");
            aux.append(east.getTime());
        }
        if(east.getLuces().equals(Estados.AMBER)){
            if(parpadeo){
                aux.append(" ");
                aux.append("ON");
            }else{
                aux.append(" ");
                aux.append("OFF");
                aux.append(" ");
                aux.append(east.getTime());
            }

        }
        aux.append("]");
        //Añadimos los datos de west
        aux.append("[");
        aux.append(west.getNombre());
        aux.append(": ");
        aux.append(west.getLuces().getNombre());
        if(west.getLuces().equals(Estados.GREEN)){
            aux.append(" ");
            aux.append(west.getTime());
        }
        if(west.getLuces().equals(Estados.AMBER)){
            if(parpadeo){
                aux.append(" ");
                aux.append("ON");
            }else{
                aux.append(" ");
                aux.append("OFF");
                aux.append(" ");
                aux.append(west.getTime());
            }

        }
        aux.append("]");

        return aux.toString();


    }
}