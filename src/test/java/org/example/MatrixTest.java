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

        System.out.println(m);
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
    void testVectorMultiplicationIdentity()
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
    void testPointMultiplicationIdentity()
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
    void multByTranslation()
    {
        Matrix m = Matrix.translate(5,-3,2);
        Point p = new Point(-3,4,5);
        Point actual = new Point(2,1,7);

        boolean test = m.mult(p).equals(actual);

        assertTrue(test);
    }

    @Test
    void translationDoesNotAffectVectors()
    {
        Matrix m = Matrix.translate(5,-3,2);
        Vector v = new Vector(-3,4,5);

        boolean test = m.mult(v).equals(v);

        assertTrue(test);
    }
    @Test
    void scalingPoint()
    {
        Matrix m = Matrix.scale(2,3,4);
        Point p = new Point(-4,6,8);
        Point actual = new Point(-8,18,32);

        boolean test = m.mult(p).equals(actual);

        assertTrue(test);
    }
    @Test
    void scalingVector()
    {
        Matrix m = Matrix.scale(2,3,4);
        Vector p = new Vector(-4,6,8);
        Vector actual = new Vector(-8,18,32);
        boolean test = m.mult(p).equals(actual);

        assertTrue(test);
    }
    @Test
    void multInverseScaling()
    {
        Matrix m = Matrix.scale(2,3,4);
        Matrix inv = m.getInverse();
        Vector v = new Vector(-4,6,8);
        Vector actual = new Vector(-2,2,2);

        boolean test = inv.mult(v).equals(actual);

        assertTrue(test);
    }
    @Test
    void reflectionScalingNegative()
    {
        Matrix m = Matrix.scale(-1,1,1);
        Point p = new Point(2,3,4);
        Point actual = new Point(-2,3,4);

        boolean test = m.mult(p).equals(actual);

        assertTrue(test);
    }
    @Test
    void rotatingPointAroundX()
    {
        Point p = new Point(0,1,0);
        Matrix half = Matrix.rotateX(0.7853981);
        Matrix full = Matrix.rotateX(1.5707963);
        Point actual = new Point(0, 0.707106, 0.707106);
        Point actual2 = new Point(0,0,1);


        boolean test = half.mult(p).equals(actual) && full.mult(p).equals(actual2);

        assertTrue(test);
    }
    @Test
    void inverseRotationX()
    {
        Point p = new Point(0,1,0);
        Matrix half = Matrix.rotateX(0.7853981);
        Matrix inv = half.getInverse();
        Point actual = new Point(0, 0.707106, -0.707106);

        boolean test = inv.mult(p).equals(actual);

        assertTrue(test);
    }
    @Test
    void rotatingPointAroundY()
    {
        Point p = new Point(0,0,1);
        Matrix half = Matrix.rotateY(0.7853981);
        Matrix full = Matrix.rotateY(1.5707963);
        Point actual = new Point( 0.707106,0, 0.707106);
        Point actual2 = new Point(1,0,0);


        boolean test = half.mult(p).equals(actual) && full.mult(p).equals(actual2);

        assertTrue(test);
    }
    @Test
    void rotatingPointAroundZ()
    {
        Point p = new Point(0,1,0);
        Matrix half = Matrix.rotateZ(0.7853981);
        Matrix full = Matrix.rotateZ(1.5707963);
        Point actual = new Point( -0.707106,0.707106,0);
        Point actual2 = new Point(-1,0,0);


        boolean test = half.mult(p).equals(actual) && full.mult(p).equals(actual2);

        assertTrue(test);
    }
    @Test
    void individualTransformationsInSequence()
    {
        Point p = new Point(1,0,1);
        Matrix full = Matrix.rotateX(1.5707963);
        Matrix scale = Matrix.scale(5,5,5);
        Matrix transl = Matrix.translate(10,5,7);

        Point p2 = full.mult(p);
        Point p3 = scale.mult(p2);
        Point p4 = transl.mult(p3);

        boolean test =
                p2.equals(new Point(1,-1,0)) &&
                p3.equals(new Point(5,-5,0)) &&
                p4.equals(new Point(15,0,7));

        assertTrue(test);

    }
    @Test
    void chainedTransformationReverseOrder()
    {
        Point p = new Point(1,0,1);
        Matrix full = Matrix.rotateX(1.5707963);
        Matrix scale = Matrix.scale(5,5,5);
        Matrix transl = Matrix.translate(10,5,7);

        Matrix m = transl.mult(scale).mult(full);

        boolean test = m.mult(p).equals(new Point(15,0,7));

        assertTrue(test);
    }

    @Test
    void transformationMatrixDefaultOrientation()
    {
        Point position = new Point(0,0,0);
        Point lookAt = new Point(0,0,-1);
        Vector up = new Vector(0,1,0);

        Matrix transform = Matrix.viewTransform(position,lookAt,up);

        assertEquals(Matrix.identity(4),transform);
    }
    @Test
    void transformationMatrixLookingInPositiveZ()
    {
        Point position = new Point(0,0,0);
        Point lookAt = new Point(0,0,1);
        Vector up = new Vector(0,1,0);

        Matrix transform = Matrix.viewTransform(position,lookAt,up);

        assertEquals(Matrix.scale(-1,1,-1),transform);
    }
    @Test
    void viewTransformationMovesWorlds()
    {
        Point position = new Point(0,0,8);
        Point lookAt = new Point(0,0,0);
        Vector up = new Vector(0,1,0);

        Matrix transform = Matrix.viewTransform(position,lookAt,up);

        assertEquals(Matrix.translate(0,0,-8),transform);
    }
    @Test
    void arbitraryViewTransformation()
    {
        Point position = new Point(1,3,2);
        Point lookAt = new Point(4,-2,8);
        Vector up = new Vector(1,1,0);

        Matrix transform = Matrix.viewTransform(position,lookAt,up);



        double[][] matrix =
                {
                        {-0.50709, 0.50709 , 0.67612 , -2.36643 },
                        { 0.76772 , 0.60609 , 0.12122 , -2.82843 },
                        {-0.35857 , 0.59761 , -0.71714 , 0.00000 },
                        { 0.00000 , 0.00000 , 0.00000 , 1.00000 }
                };

        Matrix m = new Matrix(matrix);
        assertEquals(m,transform);
    }


}