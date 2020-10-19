package e1;

public class StringUtilities {

    /**
     * Checks if a given string is a valid c of two others . That is , it contains
     * all characters of the other two and order of all characters in the individual
     * strings is preserved .
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @param c Mix of the two other Strings
     * @return true if the c is valid , false otherwise
     */
    public static boolean isValidMix ( String a, String b, String c) {

         boolean resultado = false;
         int i = 0,j = 0,k = 0,total;
         while(i < c.length()){
                if(j<a.length() &&  a.charAt(j) == c.charAt(i)){
                   j++;
                }
                if(k<b.length() && b.charAt(k) == c.charAt(i)){
                    k++;
                }
                i++;
         }
         total = a.length() + b.length();
         if(j == a.length() && k == b.length() && total == c.length()) resultado = true;

        return resultado;
    }
    /**
     * Generates a random valid mix for two Strings
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two.
     */
    public static String generateRandomValidMix ( String a, String b) {
        int j=0,k=0,t,total;
        StringBuilder aux  = new StringBuilder();
        total = a.length() + b.length();

        while(aux.length() < total){
            t = (int)( Math.random() * 2);
            if(t == 0 && j < a.length()){
                aux.append(a.charAt(j));
                j++;
            }
            if(t == 1 && k < b.length()){
                aux.append(b.charAt(k));
                k++;
            }
        }
        return aux.toString();
    }

}
