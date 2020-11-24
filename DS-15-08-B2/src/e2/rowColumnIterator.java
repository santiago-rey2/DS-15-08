package e2;

import java.util.Iterator;

public class rowColumnIterator implements Iterator<Integer> {

    private final Matrix matrix;
    private int fil=0,col=0;


    public rowColumnIterator(Matrix m){
        this.matrix = m;
    }

    @Override
    public boolean hasNext() {
        return matrix.getnumberofColumns() < col && matrix.getnumberofRows() < fil;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            if(matrix.getnumberofColumns() > col){
                col++;
                return  matrix.getValor(fil,col);
            }else if(matrix.getnumberofRows() > fil){
                fil++;
                col = 0;
                return  matrix.getValor(fil,col);
            }else return null;

        }else return null;
    }

    @Override
    public void remove() {
        throw new IllegalCallerException("");
    }
}
