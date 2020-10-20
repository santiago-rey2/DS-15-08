package e3;

public class Clock {

    private int hour;
    private int minute;
    private int second;
    private Period periods;

    public enum Period{
        AM("AM"),
        PM("PM");
        private final String nombre;

        Period(String s){
            this.nombre = s;
        }
        public String getFormat(){
            return this.nombre;
        }
    }

    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour.
     */
    public Clock ( String s) {
        int h,m,se;
        boolean cmp = true;
        if(s.length() != 8 && s.length() != 11)
            throw new IllegalArgumentException("Invalid Format");
        if(s.charAt(2) !=':' && s.charAt(5) != ':')
            throw new IllegalArgumentException("Invalid Format");

        try {
            h = Integer.parseInt(s.substring(0,2));
            m = Integer.parseInt(s.substring(3,5));
            se= Integer.parseInt(s.substring(6,8));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Incorrect Number");
        }

        if(h < 24 && h >= 0 ){
            this.hour = h;
        }else{
            throw new IllegalArgumentException("Not Correct Hour");
        }

        if(m <= 60 && m >= 0 ){
            this.minute = m;
        }else{
            throw new IllegalArgumentException("Not Correct Minutes");
        }

        if(se <= 60 && se >= 0 ){
            this.second = se;
        }else{
            throw new IllegalArgumentException("Not Correct Seconds");
        }
        if(s.length() == 8){
            if(h > 12){
                this.periods = Period.PM;
            }else{
                this.periods = Period.AM;
            }
        }
        if(s.length() == 11){
            if(s.charAt(8) == ' '){
                if(s.substring(9,11).equals(Period.AM.getFormat())){
                    cmp = false;
                    this.periods = Period.AM;
                }
                if(s.substring(9,11).equals(Period.PM.getFormat())){
                    cmp = false;
                    this.periods = Period.PM;
                }
                if(cmp)
                    throw new IllegalArgumentException("Invalid Period");
            }
        }
    }

    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour.
     */
    public Clock (int hours , int minutes , int seconds ) {
        if(hours < 24 && hours > 0){
            this.hour = hours;
            if(hours > 12){
                this.periods = Period.PM;
            }else{
                this.periods = Period.AM;
            }
        }
        if(minutes < 60 && minutes > 0)
            this.minute = minutes;
        if(seconds < 60 && seconds > 0 )
            this.second = seconds;
    }
    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour.
     */
    public Clock (int hours , int minutes , int seconds , Period period ) {
        if(hours <= 12 && hours > 0)
            this.hour = hours;
        if(minutes <= 60 && minutes >= 0)
            this.minute = minutes;
        if(seconds <= 60 && seconds >= 0 )
            this.second = seconds;
        this.periods = period;


    }
    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */
    public int getHours24 () {
        if(hour >12){
            return hour;
        }else if(periods.equals(Period.PM)){
            if(hour == 12 ){
                return hour;
            }
            return ( hour + 12 );
        }else{
            if(hour == 12){
                return 0;
            }
            return hour;
        }
    }
    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */
    public int getHours12 () {

        if(hour > 12){
            return (hour -12);
        }else {
            return hour;
        }

    }
    /**
     * Returns the minutes of the clock
     * @return the minutes
     */
    public int getMinutes () {
        return minute;
    }
    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds () {
        return second;
    }
    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */
    public Period getPeriod () {
        return periods;
    }
    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */

    public String printHour24 () {
        StringBuilder aux = new StringBuilder();
        int hTmp = this.getHours24();

        aux.append(String.format("%02d",hTmp));
        aux.append(":");
        aux.append(String.format("%02d",getMinutes()));
        aux.append(":");
        aux.append(String.format("%02d",getSeconds()));
        return aux.toString();
    }
/**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour12 () {
        StringBuilder aux = new StringBuilder();
        int hTmp = this.getHours12();
        aux.append(String.format("%02d",hTmp));
        aux.append(":");
        aux.append(String.format("%02d",getMinutes()));
        aux.append(":");
        aux.append(String.format("%02d",getSeconds()));
        aux.append(" ");
        aux.append(getPeriod().getFormat());
        return aux.toString();
    }
    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param obj The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     *
     */
    @Override
    public boolean equals ( Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clock other = (Clock) obj;

        return this.getHours24() == other.getHours24() && this.getMinutes() == other.getMinutes() && this.getSeconds() == other.getSeconds();

    }
    /**
     * Returns a integer that is a hash code representation of the clock using
     * the "hash 31" algorithm .
     * Clocks that are equals must have the same hash code.
     * @return the hash code
     */

    @Override
    public int hashCode () {

        return 31 * (getHours24() + getMinutes() + getSeconds());
    }

}
