package e2;

import java.util.Iterator;

public class Matrix implements Iterable {

    private int[][] matrix;
    private boolean iterator;

    public Matrix(int filas, int columnas,boolean it) {
        this.iterator = it;
        int i, j;
        this.matrix = new int[filas][columnas];
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix(int[][] m,boolean it) {
        this.iterator = it;
        int i, j;
        this.matrix = m;
        if (isMatrixvalid(m)) {
            for (i = 0; i < m.length; i++) {
                for (j = 0; j < m[i].length; j++) {
                    this.matrix[i][j] = m[i][j];
                }
            }
        }else{
            throw new IllegalArgumentException("Formato de Matrix incorrecto");
        }
    }

    public int getnumberofRows(){
        return matrix[0].length;
    }
    public int getnumberofColumns(){
        return  matrix.length;
    }
    public int[][] getMatrixHowDimensonalInt(){
        return matrix;
    }

    public int[] getRow(int row){
        int[] arrayadevolver = new int[row] ;
        int i=0;

        if(row <= getnumberofRows()){
            while(i<getnumberofColumns()){
                arrayadevolver[i] = matrix[i][row];
            }
        }else {
            throw new IllegalArgumentException("Fila indicada inexistente");
        }
        return arrayadevolver;
    }

    public int[] getColumn(int col){
        int[] arrayadevolver = new int[col] ;
        int i=0;

        if(col <= getnumberofColumns()){
            while(i<getnumberofColumns()){
                arrayadevolver[i] = matrix[col][i];
            }
        }else {
            throw new IllegalArgumentException("Columna indicada inexistente");
        }
        return arrayadevolver;
    }

    public int getValor(int fila,int col){
        if(fila <= getnumberofRows() && col < getnumberofColumns()){
            return matrix[fila][col];
        }else {
            throw new IllegalArgumentException("Parametros de la matriz incorrectos");
        }
    }

    public void setValor(int fila,int col,int valor){

        if(fila <= getnumberofRows() && col < getnumberofColumns()){
            matrix[fila][col] = valor;
        }else {
            throw new IllegalArgumentException("Parametros de la matriz incorrectos");
        }
    }
    @Override
    public String toString (){
        StringBuilder m = new StringBuilder();
        if(matrix!=null){
            for(int k=0;k<getnumberofRows();k++){
                m.append("[");
                for(int i=0;i<getnumberofColumns();i++){
                    m.append(matrix[k][i]);
                    if(i < getnumberofColumns()-1){
                        m.append(", ");
                    }
                }
                m.append("]\n");
            }
            return m.toString();
        }else{
            return "[]";
        }
    }

    public Iterator<Integer> rowColumnIterator(){
        return new rowColumnIterator(new Matrix(matrix,iterator));
    }
    public Iterator<Integer> ColumnRowIterator(){
        return new ColumnRowIterator(new Matrix(matrix,iterator));
    }

    private boolean isMatrixvalid(int[][] m) {
        int i = 0, numFilas, numCol;
        if (m == null)
            return false;
        numFilas = m.length;
        numCol = m[0].length;
        while (i < numFilas) {
            if (m[i] == null)
                return false;
            if (numCol != m[i].length)
                return false;
            i++;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        if(this.iterator){
            return rowColumnIterator();
        }else{
            return ColumnRowIterator();
        }
    }
}
