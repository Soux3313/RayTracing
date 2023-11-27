package org.example;

import org.junit.jupiter.api.Test;

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
    void createUnityMatrix() {

        Matrix m = new Matrix(10);

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
    /*Scenario: Multiplying two matrices
    Given the following matrix M:
            | 1 | 2 | 3 | 4 |
            | 5 | 6 | 7 | 8 |
            | 9 | 8 | 7 | 6 |
            | 5 | 4 | 3 | 2 |
    And the following matrix B:
            | -2 | 1 | 2 | 3 |
            | 3 | 2 | 1 | -1 |
            | 4 | 3 | 6 | 5 |
            | 1 | 2 | 7 | 8 |
    Then M * B is the following matrix:
            | 20| 22 | 50 | 48 |
            | 44| 54 | 114 | 108 |
            | 40| 58 | 110 | 102 |
            | 16| 26 | 46 | 42 |
*/
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

 /*   Scenario: Multiplying a matrix with the identity matrix
    Given M is the matrix identity(4)
    And the following matrix B:
            | 20 | 22 | 50 | 48 |
            | 44 | 54 | 114 | 108 |
            | 40 | 58 | 110 | 102 |
            | 16 | 26 | 46 | 42 |
    Then M * B = B
    And B * M = B
*/
    @Test
    void testMultiplicationIdentity()
    {
        Matrix m = new Matrix(4);
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
}