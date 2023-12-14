package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointAndVectorTest {

    @Test
    void subtractPoints()
    {
        Point p1 = new Point(3,2,1);
        Point p2 = new Point(5,6,7);

        double[] expected = {-2,-4,-6};
        Vector actualPoint = p1.sub(p2);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void vectorAddPoint()
    {
        Point p = new Point(3, -2, 5);
        Vector v = new Vector(-2,3,1);

        double[] expected = {1,1,6};
        Point actualPoint = p.add(v);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void pointMinusVector()
    {
        Point p = new Point(3,2,1);
        Vector v = new Vector(5,6,7);

        double[] expected = {-2,-4,-6};
        Point actualPoint = p.sub(v);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

}