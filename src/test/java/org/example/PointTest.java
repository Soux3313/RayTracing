package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void multiply() {
        Point p = new Point(0.1,0.2,0.3);
        double scale = -1.5;

        Point expected = new Point(-0.15, -0.3, -0.45);
        Point actual = p.mult(scale);


        assertEquals(expected,actual);
    }

    @Test
    void divide() {
        Point p = new Point(0.1,0.2,0.3);
        double scale = -10;

        double[] expected = {-0.01, -0.02, -0.03};

        Point actualPoint = p.div(scale);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void illegalDivision()
    {
        Point p = new Point(0.1,0.2,0.3);

        assertThrows(ArithmeticException.class, ()->p.div(0));

    }

    @Test
    void minimum()
    {
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(3,2,1);

        double[] expected = {1,2,1};
        Point actualPoint = p1.min(p2);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void maximum()
    {
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(3,2,1);

        double[] expected = {3,2,3};
        Point actualPoint = p1.max(p2);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }


}