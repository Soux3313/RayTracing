package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void newColor(){
        Color c = new Color();

        double[] expected = {0,0,0};
        double[] actual = {c.getR(),c.getG(), c.getB()};

        assertArrayEquals(expected,actual);
    }
    @Test
    void customColor() {
        Color c = new Color(0.3, 0.6, 0.2);

        double[] expected = {0.3, 0.6, 0.2};
        double[] actual = {c.getR(), c.getG(), c.getB()};

        assertArrayEquals(expected, actual);
    }
    @Test
    void add() {
        Color c1 = new Color(0.9, 0.6, 0.75);
        Color c2 = new Color(0.7, 0.1, 0.25);

        Color added = c1.add(c2);

        double[] expected = {1.0, 0.7, 1.0};
        double[] actual = {added.getR(),added.getG(), added.getB()};

        assertArrayEquals(expected,actual);
    }

    @Test
    void multiplyByScale() {
        Color c = new Color(0.2,0.3,0.4);
        Color m = c.multiply(2);

        double[] expected = {0.4, 0.6, 0.8};
        double[] actual = {m.getR(),m.getG(), m.getB()};

        assertArrayEquals(expected,actual);
    }
    @Test
    void multiplyByColor() {
        Color c1 = new Color(1, 0.2, 0.4);
        Color c2 = new Color(0.9, 1, 0.1);
        Color m = c1.multiply(c2);

        double[] expected = {0.9, 0.2, 0.04000000000000001};
        double[] actual = {m.getR(),m.getG(), m.getB()};

        assertArrayEquals(expected,actual);
    }

    @Test
    void clamped()
    {
        Color c = new Color(1.5, -2, 0.4);

        double[] expected = {1, 0, 0.4};
        double[] actual = {c.getR(),c.getG(), c.getB()};

        assertArrayEquals(expected,actual);
    }
}