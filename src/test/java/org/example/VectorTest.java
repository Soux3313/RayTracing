package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {


    @Test
    void add() {
    }

    @Test
    void subtract() {
    }

    @Test
    void subtractZeroVector(){

    }

    @Test
    void negative() {
        Vector v = new Vector(0.1,2.3,9.6);
        Vector minusV = v.negative();

        double[] expected = {-0.1, -2.3, -9.6};
        double[] actual = {minusV.getX(), minusV.getY(), minusV.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void multiply() {
        Vector v = new Vector(0.1,0.2,0.3);
        Vector actualVector = v.multiply(0.3);

        double[] expected = {0.03,0.06,0.09};
        double[] actual = {actualVector.getX(), actualVector.getY(), actualVector.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void illegalDivisionByZero(){
        Vector v = new Vector(0.1,0.2,0.3);
        Vector actualVector = v.divide(0);

        double[] expected = {0.1,0.2,0.3};
        double[] actual = {actualVector.getX(), actualVector.getY(), actualVector.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void divide() {
        Vector v = new Vector(0.1,0.2,0.3);
        Vector actualVector = v.divide(10);

        double[] expected = {0.01,0.02,0.03};
        double[] actual = {actualVector.getX(), actualVector.getY(), actualVector.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void magnitude() {
    }

    @Test
    void sqrMagnitude() {
    }

    @Test
    void normalized() {
    }

    @Test
    void dot() {
    }

    @Test
    void cross() {
    }
}