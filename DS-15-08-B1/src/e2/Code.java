package e2;

public class Code {

    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */
    public static boolean isKeypadValid (char [][] keypad ) {
        int numFilas,i=0,numCol,orden=2;

        if(keypad == null)
            return false;

        if(keypad[0][0] !='1')
            return false;

        numFilas = keypad.length;
        numCol= keypad[i].length;

        //Bucle donde comprobamos que la matric es estrictamente rectangular en caso contrario decuelve falso
        while(i<numFilas){
            if(keypad[i]==null)
                return false;
            if(numCol != keypad[i].length)
                return false;
            i++;
        }
        if(numCol > 1 && keypad[0][1] =='2'){
            orden = 0; //Si orden es 0 entonces el orden del keypad es por filas
        }else if(numFilas > 1 && keypad[1][0] =='2'){
            orden = 1; //Si orden es 1 entonces el orden del keypad es por columnas
        }else if(numCol == 1 && numFilas == 1){
            return true;
        }
        //Comprobacion de contenido de orden por filas
        if(orden == 0){
          return Code.recorrerFilas(keypad,numCol,numFilas);
        }
        //Bucle de comprobacion contenido ordenado por columnas
        if(orden == 1) {
            return recorrerColumnas(keypad,numCol,numFilas);
        }

        return false;
    }
    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */
    public static boolean areMovementsValid ( String [] movements ) {
        int i = 0,k;
        if(movements == null)
            return false;
        while (i < movements.length){
            if(movements[i] == null){
                return false;
            }
            k=0;
            while(k<movements[i].length()){
                if(movements[i].charAt(k) != 'U' && movements[i].charAt(k) != 'D' && movements[i].charAt(k) != 'L' && movements[i].charAt(k) != 'R' )
                    return false;
                k++;
            }
            i++;

        }

        return true;
    }
    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each
    number of the key.
     * @return Resulting code.
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode (char [][] keypad , String [] movements ) {
        StringBuilder aux = new StringBuilder();
        int i=0,k,f=0,c=0,maxF,maxC;
        maxF = keypad.length;
        maxC = keypad[0].length;
        while(i<movements.length){
            k=0;
            while (k<movements[i].length()){

                if(movements[i].charAt(k)=='U')
                    if(f!=0)
                        f--;
                if(movements[i].charAt(k)=='D')
                    if(f<maxF-1)
                        f++;
                if(movements[i].charAt(k)=='L')
                    if(c!=0)
                        c--;
                if(movements[i].charAt(k)=='R')
                    if(c<maxC-1)
                        c++;
                k++;
            }
            aux.append(keypad[f][c]);
            i++;
        }
        return aux.toString();
    }
    //metodo privado para recorrer el keypad por filas
    private static boolean recorrerFilas(char [][] keypad,int numCol,int numFilas){

        int i=0,k,cont=0,comprletras=10;
        while(i<numFilas){
            k=0;
            while(k<numCol){
                if(cont < 9 && Character.getNumericValue(keypad[i][k]) != cont+1 ){
                    return false;
                }else if(cont == 9){
                    if(Character.getNumericValue(keypad[i][k]) != 0)
                        return false;
                }else if(cont > 9 && Character.getNumericValue(keypad[i][k]) != comprletras ){
                    return false;
                }else if(Character.getNumericValue(keypad[i][k]) == comprletras){
                    if(comprletras < 35){
                        comprletras++;
                    }
                }
                k++;
                cont++;
            }
            i++;
        }
        return true;
    }
    //Metodo privado para recorrer el keypad por columnas
    private static boolean recorrerColumnas(char [][] keypad,int numCol,int numFilas) {
        int k=0,i,cont=0,comprletras=10;
        while(k<numCol){
            i=0;
            while(i<numFilas){
                if(cont < 9 && Character.getNumericValue(keypad[i][k]) != cont+1 ){
                    return false;
                }else if(cont == 9){
                    if(Character.getNumericValue(keypad[i][k]) != 0)
                        return false;
                }else if(cont > 9 && Character.getNumericValue(keypad[i][k]) != comprletras ){
                    return false;
                }else if(Character.getNumericValue(keypad[i][k]) == comprletras){
                    if(comprletras < 35){
                        comprletras++;
                    }
                }
                i++;
                cont++;
            }
            k++;
        }
        return true;
    }

}