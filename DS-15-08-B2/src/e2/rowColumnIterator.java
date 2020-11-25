package e2;

import javax.naming.AuthenticationException;
import java.util.Iterator;

public class rowColumnIterator implements Iterator<Integer> {

    private final Matrix matrix;
    private int fil=0,col=0;


    public rowColumnIterator(Matrix m){
        this.matrix = m;
    }

    @Override
    public boolean hasNext() {
//        System.out.println("Columnas matriz "+ matrix.getnumberofColumns());
//        System.out.println("Filas matriz "+matrix.getnumberofRows());
//        System.out.println("Filas it "+fil);
//        System.out.println("Columnas it "+col);

        return matrix.getnumberofRows() > fil;
    }

    @Override
    public Integer next() {
        int aux;
        if(hasNext()){
            if(matrix.getnumberofColumns()-1 > col){
                aux = matrix.getValor(fil,col);
                col++;
            }else if(matrix.getnumberofRows() > fil){
                aux = matrix.getValor(fil,col);
                fil++;
                col = 0;
            }else return null;
            return aux;
        }else return null;
    }

    @Override
    public void remove() {
        throw new IllegalCallerException("");
    }
}
