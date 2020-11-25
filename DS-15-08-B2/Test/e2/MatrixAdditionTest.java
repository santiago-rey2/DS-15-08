package e2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAdditionTest {
    int[][] mbid ={{3,2,3},{5,2,7},{4,8,3}} ;
    int[][] mbid2 ={{4,5,9},{3,5,2},{1,8,9}} ;
    int[][] mbid3 ={{4,5},{3,5}};
    int[][] mbid4 =null;
    int[][] resultado = {{3,2,3},{5,2,10},{4,13,13}};
    int[][] ragged = {{1,2,4},null,{0,1,9}};
    Matrix m1 = new Matrix(3,3) ;
    Matrix m2 = new Matrix(mbid);
    Matrix m3 = new Matrix(mbid3);
    Matrix m4 = new Matrix(resultado);
    MatrixAddition adition = new MatrixAddition();
    Iterator<Integer> it = m1.iterator();
    Iterator<Integer> it3 = m3.iterator();


    @Test
    void creationMatrixTest(){
        Matrix c1 = new Matrix(3,3);  //Test crear una matriz pasandole numero de filas y columnas
        assertEquals(c1.toString(),m1.toString());
        Matrix c2 = new Matrix(mbid);              //Test crear una matriz pasandole un int bidimensonal
        assertEquals(c2.toString(),m2.toString());
        assertEquals(c2.getMatrixHowDimensonalInt(),mbid);
        Matrix c3 = new Matrix(mbid2);
        assertEquals(c3.getMatrixHowDimensonalInt(),mbid2);
    }
    @Test
    void settersAndGettersTest(){
        m1.setValor(0,0,4);
        m1.setValor(0,1,3);
        m1.setValor(0,2,6);
        m1.setValor(1,0,8);
        m1.setValor(1,1,0);
        m1.setValor(1,2,2);
        m1.setValor(2,0,1);
        m1.setValor(2,1,5);
        m1.setValor(2,2,7);

        //Testeamos que los valores se hayan introducido correctamente
        //y al mismo tiempo tb comprobamos que las getters de los valores funcionan
        assertEquals(m1.getValor(0,0),4);
        assertEquals(m1.getValor(0,1),3);
        assertEquals(m1.getValor(0,2),6);
        assertEquals(m1.getValor(1,0),8);
        assertEquals(m1.getValor(1,1),0);
        assertEquals(m1.getValor(1,2),2);
        assertEquals(m1.getValor(2,0),1);
        assertEquals(m1.getValor(2,1),5);
        assertEquals(m1.getValor(2,2),7);

        //Testeamos que los getters de la cantidad de Filas y Columnas

        assertEquals(m1.getnumberofColumns(),3);
        assertEquals(m1.getnumberofRows(),3);
        int[] aux = m2.getRow(0);
        assertEquals(aux[0],mbid[0][0]);
        assertEquals(aux[1],mbid[0][1]);
        assertEquals(aux[2],mbid[0][2]);
        aux = m2.getColumn(0);
        assertEquals(aux[0],mbid[0][0]);
        assertEquals(aux[1],mbid[1][0]);
        assertEquals(aux[2],mbid[2][0]);

    }
    @Test
    void iteratorsTest(){
        assertTrue(it3.hasNext());
        assertEquals(it3.next(),4);
        assertTrue(it3.hasNext());
        assertEquals(it3.next(),5);
        assertTrue(it3.hasNext());
        assertEquals(it3.next(),3);
        assertTrue(it3.hasNext());
        assertEquals(it3.next(),5);
        assertFalse(it3.hasNext());
        assertEquals(it3.next(),null);
        m1.setIterator(false);
        Iterator<Integer> t = m1.iterator();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        t.next();
        assertEquals(t.next(),null);

    }
    @Test
    void aditionTest(){
        m1.setValor(2,2,10);
        m1.setValor(1,2,3);
        m1.setValor(2,1,5);

        assertEquals(adition.sumaMatrices(m1,m2,false).toString(),m4.toString());
        assertEquals(adition.sumaMatrices(m1,m2,true).toString(),m4.toString());
    }
    @Test
    void exceptionsTest(){
        assertThrows(IllegalArgumentException.class,() -> new Matrix(ragged));
        assertThrows(IllegalArgumentException.class,() -> m1.getColumn(4));
        assertThrows(IllegalArgumentException.class,() -> m1.getRow(6));
        assertThrows(IllegalArgumentException.class,() -> m1.getValor(5,2));
        assertThrows(IllegalArgumentException.class,() -> m1.setValor(5,4,0));
        assertThrows(IllegalArgumentException.class,() -> new Matrix(mbid4));
        assertThrows(ArithmeticException.class,() -> adition.sumaMatrices(m1,m3,true));
        assertThrows(IllegalCallerException.class,() -> it.remove());
        m1.setIterator(false);
        assertThrows(IllegalCallerException.class,() -> m1.iterator().remove());
        assertThrows(IllegalCallerException.class,() -> m1.iterator().remove());

    }

}