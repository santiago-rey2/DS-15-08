package e2;

import java.util.Iterator;

public class MatrixAddition {

    public Matrix sumaMatrices(Matrix m1,Matrix m2,boolean b){
        Matrix aux;
        int i=0,k=0;
        int[] cal;
        Iterator<Integer> it;
        Iterator<Integer> it2;

        if(m1.getnumberofColumns()!= m2.getnumberofColumns() && m1.getnumberofRows()!=m2.getnumberofRows()){
            throw new ArithmeticException();
        }else{
            aux = new Matrix(m1.getnumberofColumns(),m1.getnumberofRows());
            m1.setIterator(b);
            m2.setIterator(b);
            aux.setIterator(b);
            it = m1.iterator();
            it2 = m2.iterator();
            cal = new int[m1.getnumberofRows()* m1.getnumberofColumns()];
        }
        while(it.hasNext()){
            cal[i] = it.next() + it2.next();
            aux = guardarMatriz(cal,aux,b);
            i++;
        }
        return guardarMatriz(cal,aux,b);
    }

    private Matrix guardarMatriz(int[] p,Matrix m,boolean t){
        int i=0,k=0,j=0;

        if(t){
            for(i=0;i< m.getnumberofRows();i++){
                for(k=0;k<m.getnumberofColumns();k++){
                    m.setValor(i,k,p[j]);
                    j++;
                }
            }
        }else{
            for(i=0;i< m.getnumberofColumns();i++){
                for(k=0;k<m.getnumberofRows();k++){
                    m.setValor(k,i,p[j]);
                    j++;
                }
            }
        }
        return m;
    }


}

