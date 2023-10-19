package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void multiply() {
        Point p = new Point(0.1,0.2,0.3);
        double scale = -1.5;

        double[] expected = {-0.15, -0.3, -0.45};
        Point actualPoint = p.multiply(-1.5);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

    }

    @Test
    void divide() {
        Point p = new Point(0.1,0.2,0.3);
        double scale = -10;

        double[] expected = {-0.01, -0.02, -0.03};

        Point actualPoint = p.divide(-10);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void illegalDivision()
    {
        Point p = new Point(0.1,0.2,0.3);
        double[] expected = {0.1, 0.2, 0.3};
        Point actualPoint = p.divide(0);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void minimum()
    {
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(3,2,1);

        double[] expected = {1,2,1};
        Point actualPoint = p1.minimum(p2);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void maximum()
    {
        Point p1 = new Point(1,2,3);
        Point p2 = new Point(3,2,1);

        double[] expected = {3,2,3};
        Point actualPoint = p1.maximum(p2);
        double[] actual = {actualPoint.getX(), actualPoint.getY(), actualPoint.getZ()};

        assertArrayEquals(expected, actual);
    }


}