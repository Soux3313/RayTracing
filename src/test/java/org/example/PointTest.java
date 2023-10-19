package org.example;

import org.junit.jupiter.api.Test;

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
        double scale = -1.5;
    }
}