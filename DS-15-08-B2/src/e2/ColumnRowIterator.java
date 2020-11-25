package e2;

import java.util.Iterator;

public class ColumnRowIterator implements Iterator<Integer> {

    private final Matrix matrix;
    private int fil=0,col=0;

    public ColumnRowIterator(Matrix m){
        this.matrix = m;
    }

    @Override
    public boolean hasNext() {
        return matrix.getnumberofColumns() > col ;
    }

    @Override
    public Integer next() {
        int aux;
        if(hasNext()){
            if(matrix.getnumberofRows()-1 > fil){
                aux =  matrix.getValor(fil,col);
                fil++;
            }else if(matrix.getnumberofColumns()>col){
                aux =  matrix.getValor(fil,col);
                col++;
                fil = 0;
            }else return null;
            return aux;
        }else return null;
    }

    @Override
    public void remove() {
        throw new IllegalCallerException("");
    }
}
