package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void createFromPointAndVector() {
        Point p = new Point(1, 4, 7.6);
        Vector v = new Vector(3, 5, 9);
        Ray ray = new Ray(p,v);

        assertEquals(p,ray.getOriginPoint());
        assertEquals(v,ray.getVector());
    }

    @Test
    void createFrom2Points() {
        Point o = new Point(1, 4, 7.6);
        Point t = new Point(3, 5, 9);
        Ray ray = new Ray(o,t);

        assertEquals(o,ray.getOriginPoint());
        assertEquals(t,ray.getTargetPoint());
    }

    @Test
    void pointAt() {
        Point p = new Point(2, 3, 4);
        Vector v = new Vector(1, 0, 0);
        Ray ray = new Ray(p,v);

        Point p2 = ray.pointAt(-1);

        double[] expected = {1,3,4};
        double[] actual = {p2.getX(), p2.getY(), p2.getZ()};


        assertArrayEquals(expected,actual);
    }


    @Test
    void translate()
    {
        Ray r = new Ray(new Point(1,2,3), new Vector(0,1,0));
        Matrix m = Matrix.translate(3,4,5);
        Ray r2 = r.transform(m);

        Point expectedP = new Point(4,6,8);
        Vector expectedV = new Vector(0,1,0);
        Point actualP = r2.getOriginPoint();
        Vector actualV = r2.getVector();

        assertTrue(expectedP.equals(actualP));
        assertTrue(expectedV.equals(actualV));
    }

    @Test
    void scale()
    {
        Ray r = new Ray(new Point(1,2,3), new Vector(0,1,0));
        Matrix m = Matrix.scale(2,3,4);
        Ray r2 = r.transform(m);

        Point expectedP = new Point(2,6,12);
        Vector expectedV = new Vector(0,3,0);
        Point actualP = r2.getOriginPoint();
        Vector actualV = r2.getVector();

        assertTrue(expectedP.equals(actualP));
        assertTrue(expectedV.equals(actualV));
    }
}