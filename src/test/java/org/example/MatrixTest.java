package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void create4x4Matrix() {
        double[][] matrix =
                {{1,2,3,4},
                {5.5,6.5,7.5,8.5},
                {9,10,11,12},
                {13.5,14.5,15.5,16.5}};

        Matrix m = new Matrix(matrix);

        assertEquals(1,m.getCell(0,0));
        assertEquals(4,m.getCell(0,3));
        assertEquals(5.5,m.getCell(1,0));
        assertEquals(7.5,m.getCell(1,2));
        assertEquals(11,m.getCell(2,2));
        assertEquals(13.5,m.getCell(3,0));
        assertEquals(15.5,m.getCell(3,2));
    }
    @Test
    void create3x3Matrix() {
        double[][] matrix =
                {
                        {-3,5,0},
                        {1,-2,-7},
                        {0,1,1}
                };

        Matrix m = new Matrix(matrix);

        assertEquals(-3,m.getCell(0,0));
        assertEquals(-2,m.getCell(1,1));
        assertEquals(1,m.getCell(2,2));
    }
    @Test
    void create2x2Matrix() {
        double[][] matrix =
                {
                        {-3,5},
                        {1,-2,}
                };

        Matrix m = new Matrix(matrix);

        assertEquals(-3,m.getCell(0,0));
        assertEquals(-2,m.getCell(1,1));
        assertEquals(1,m.getCell(1,0));
        assertEquals(5,m.getCell(0,1));
    }
    @Test
    void createIdentityMatrix() {

        Matrix m = Matrix.identity(10);

        for(int i = 0; i < m.getMatrix().length; i++)
        {
            assertEquals(1,m.getCell(i,i));
        }
        assertEquals(0,m.getCell(2,6));
        assertEquals(0,m.getCell(9,1));
    }
    @Test
    void testToString() {
        double[][] matrix =
                {
                        {-3,5,0},
                        {1,-2,-7},
                        {0,1,1}
                };

        Matrix m = new Matrix(matrix);

        System.out.println(m.toString());
    }

    @Test
    void testEqualsTrue(){
        double[][] matrix1 =
                {
                        {1,2,3,4},
                        {5.5,6.5,7.5,8.5},
                        {9,10,11,12},
                        {13.5,14.5,15.5,16.5}
                };

        Matrix m1 = new Matrix(matrix1);

        double[][] matrix2 =
                {
                        {1,2,3,4},
                        {5.5,6.5,7.5,8.5},
                        {9,10,11,12},
                        {13.5,14.5,15.5,16.5}
                };

        Matrix m2 = new Matrix(matrix2);

        boolean test = m1.equals(m2);

        assertTrue(test);
    }

    @Test
    void testEqualsFalse(){
        double[][] matrix1 =
                {
                        {1,2,3,4},
                        {5.5,6.5,7.5,8.5},
                        {9,10,11,12},
                        {13.5,14.5,15.5,16.5}
                };

        Matrix m1 = new Matrix(matrix1);

        double[][] matrix2 =
                {
                        {1,2,5,4},
                        {5.5,6.5,7.5,1.5},
                        {9,90,12,12},
                        {13.5,15.5,15.5,16.5}
                };

        Matrix m2 = new Matrix(matrix2);

        boolean test = m1.equals(m2);

        assertFalse(test);
    }

    @Test
    void testMultiplication()
    {
        double[][] M =
                {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 8, 7, 6},
                {5, 4, 3, 2}};
        Matrix m = new Matrix(M);
        double[][] B =
                {{-2, 1, 2, 3},
                {3, 2, 1, -1},
                {4, 3, 6, 5},
                {1, 2, 7, 8}};
        Matrix b = new Matrix(B);
        double[][] expected =
                {{20,22,50,48},
                {44,54,114,108},
                {40,58,110,102},
                {16,26,46,42}};
        Matrix actual = m.mult(b);
        System.out.println(actual.toString());
        assertArrayEquals(expected,actual.getMatrix());
    }


    @Test
    void testMultiplicationIdentity()
    {
        Matrix m = Matrix.identity(4);
        double[][] B =
                        {{20,22,50,48},
                        {44,54,114,108},
                        {40,58,110,102},
                        {16,26,46,42}};

        Matrix b = new Matrix(B);

        Matrix actual = m.mult(b);

        System.out.println(actual.toString());
        assertArrayEquals(B, actual.getMatrix());
    }

    @Test
    void testVectorMultiplication()
    {

        double[][] M =
                        {{1,2,3,4},
                        {2,4,4,2},
                        {8,6,4,1},
                        {0,0,0,1}};

        Matrix m = new Matrix(M);

        Vector v = new Vector(1,2,3);

        Vector actualV = m.mult(v);

        double[] expected = {14, 22, 32};
        double[] actual = {actualV.getX(), actualV.getY(), actualV.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testVectorMultiplicationIdentiy()
    {
        Vector v = new Vector(1,2,3);
        Matrix m = Matrix.identity(4);

        Vector actualV = m.mult(v);

        double[] expected = {1, 2, 3};
        double[] actual = {actualV.getX(), actualV.getY(), actualV.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testPointMultiplication()
    {

        double[][] M =
                        {{1,2,3,4},
                        {2,4,4,2},
                        {8,6,4,1},
                        {0,0,0,1}};

        Matrix m = new Matrix(M);

        Point p = new Point(1,2,3);

        Point actualP = m.mult(p);

        double[] expected = {18, 24, 33};
        double[] actual = {actualP.getX(), actualP.getY(), actualP.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testPointMultiplicationIdentiy()
    {
        Point p = new Point(1,2,3);
        Matrix m = Matrix.identity(4);

        Point actualP = m.mult(p);

        double[] expected = {1, 2, 3};
        double[] actual = {actualP.getX(), actualP.getY(), actualP.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranspose()
    {
        double[][] M =
                        {{0,9,3,0},
                        {9,8,0,8},
                        {1,8,5,3},
                        {0,0,5,8}};
        Matrix m = new Matrix(M);
        double[][] tM =
                        {{0,9,1,0},
                        {9,8,8,0},
                        {3,0,5,5},
                        {0,8,3,8}};

        assertArrayEquals(tM, m.transpose().getMatrix());
    }

    @Test
    void testTransposeIdentity()
    {
        Matrix m = new Matrix(4);

        Matrix mT = m.transpose();

        assertArrayEquals(m.getMatrix(),mT.getMatrix());
    }

    @Test
    void test2x2Determinant()
    {
        double[][] M =
                        {{1,5},
                        {-3,2}};
        Matrix m = new Matrix(M);

        assertEquals(17, m.determinant());
    }

    @Test
    void test3x3Determinant()
    {
        double[][] M =
                        {{1,2,6},
                        {-5,8,-4},
                        {2,6,4}};
        Matrix m = new Matrix(M);

        assertEquals(-196, m.determinant());
    }

    @Test
    void test4x4Determinant()
    {
        double[][] M =
                        {{-2,-8,3,5},
                        {-3,1,7,3},
                        {1,2,-9,6},
                        {-6,7,7,-9}};
        Matrix m = new Matrix(M);
        assertEquals(-4071, m.determinant());
    }

    @Test
    void testInversion1()
    {
        double[][] M =
                       {{-5,2,6,8},
                        {1,-5,1,8},
                        {7,7,-6,-7},
                        {1,-3,7,4}};
        Matrix m = new Matrix(M);

        double[][] expected = {
                {0.21805, 0.45113, 0.24060, -0.04511},
                {-0.80827, -1.45677, -0.44361, 0.52068},
                {-0.07895, -0.22368, -0.05263, 0.19737},
                {-0.52256, -0.81391, -0.30075, 0.30639}
        };

        Matrix actual = m.invert();

        assertArrayEquals(expected, actual.getMatrix());
    }

}