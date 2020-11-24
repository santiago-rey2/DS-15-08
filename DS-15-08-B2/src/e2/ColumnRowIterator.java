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
        return matrix.getnumberofColumns() < col && matrix.getnumberofRows() < fil;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            if(matrix.getnumberofRows() > fil){
                fil++;
                return  matrix.getValor(fil,col);
            }else if(matrix.getnumberofColumns()>col){
                col++;
                fil = 0;
                return  matrix.getValor(fil,col);
            }else return null;
        }else return null;
    }

    @Override
    public void remove() {

    }
}
