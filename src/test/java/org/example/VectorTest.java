package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

/*Scenario: adding two vectors
Given vector1 is a Vector(3.0, -2.0, 5.0)
And vector2 is a Vector(-2.0, 3.0, 1.0)
Then vector1 + vector2 = Vector(1.0, 1.0, 6.0)*/
    @Test
    void add() {
        Vector v1 = new Vector(3,-2,5);
        Vector v2 = new Vector(-2,3,1);
        Vector add = v1.add(v2);

        double[] expected = {1,1,6};
        double[] actual = {add.getX(), add.getY(), add.getZ()};

        assertArrayEquals(expected,actual);
    }

    @Test
    void subtract() {
        Vector v1 = new Vector(3,2,1);
        Vector v2 = new Vector(5,6,7);
        Vector minusV = v1.sub(v2);

        double[] expected = {-2, -4, -6};
        double[] actual = {minusV.getX(), minusV.getY(), minusV.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void subtractZeroVector(){
    Vector v1 = new Vector(0,0,0);
    Vector v2 = new Vector(1,-2,3);
    Vector minusV = v1.sub(v2);

    double[] expected = {-1, 2, -3};
    double[] actual = {minusV.getX(), minusV.getY(), minusV.getZ()};

    assertArrayEquals(expected, actual);

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
        Vector actualVector = v.mult(0.3);

        double[] expected = {0.03,0.06,0.09};
        double[] actual = {actualVector.getX(), actualVector.getY(), actualVector.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void illegalDivisionByZero(){
        Vector v = new Vector(0.1,0.2,0.3);

        assertThrows(ArithmeticException.class, ()->v.div(0));

    }

    @Test
    void divide() {
        Vector v = new Vector(0.1,0.2,0.3);
        Vector actualVector = v.div(10);

        double[] expected = {0.01,0.02,0.03};
        double[] actual = {actualVector.getX(), actualVector.getY(), actualVector.getZ()};

        assertArrayEquals(expected, actual);
    }

    @Test
    void magnitude() {
        Vector v = new Vector(1,2,3);
        double actualMag = v.magnitude();
        double expectedMag = 3.7416573867739413;

        assertEquals(actualMag, expectedMag);
    }


    @Test
    void sqrMagnitude() {
        Vector v = new Vector(1,2,3);
        double actualMag = v.sqrMagnitude();
        double expectedMag = 14.0;

        assertEquals(expectedMag, actualMag);
    }

    @Test
    void normalized() {
        Vector v = new Vector(4,0,0);
        Vector n = v.norm();

        double[] expected = {1,0,0};
        double[] actual = {n.getX(), n.getY(), n.getZ()};

        assertArrayEquals(expected, actual);
    }
/*Scenario: The magnitude of a normalized vector
Given vector is a Vector(1, 2, 3)
When vector is normalize(vector)
Then magnitude(vector) = 1

 */
    @Test
    void normalizedMagnitude()
    {
        Vector v = new Vector(1,2,3);
        Vector n = v.norm();
        double mag = n.magnitude();

        assertEquals(1,mag);
    }
    /*Scenario: The dot product of two vectors
Given vector1 is a Vector(1, 2, 3)
And vector2 is a Vector(2, 3, 4)
Then dot(vector1, vector2) = 20
*/
    @Test
    void dot() {
        Vector v1 = new Vector(1,2,3);
        Vector v2 = new Vector(2,3,4);
        double dot = v1.dot(v2);

        assertEquals(20,dot);
    }

    /*Scenario: The cross product of two vectors
Given vector1 is a Vector(1, 2, 3)
And vector2 is a Vector(2, 3, 4)
Then cross(vector1, vector2) = Vector(-1, 2, -1)
And cross(vector2, vector1) = Vector(1, -2, 1)
*/
    @Test
    void cross() {
        Vector v1 = new Vector(1,2,3);
        Vector v2 = new Vector(2,3,4);
        Vector cross1 = v1.cross(v2);
        Vector cross2 = v2.cross(v1);

        double[] expected1 = {-1,2,-1};
        double[] expected2 = {1,-2,1};

        double[] actual1 = {cross1.getX(), cross1.getY(), cross1.getZ()};
        double[] actual2 = {cross2.getX(), cross2.getY(), cross2.getZ()};

        assertArrayEquals(expected1, actual1);
        assertArrayEquals(expected2, actual2);
    }

    @Test
    void equals()
    {
        Vector v1 = new Vector(1,2,3);
        Vector v2 = new Vector(2,3,4);
        Vector v3 = new Vector(1,1,1);
        Vector v4 = new Vector(1,1,1);

        assertNotEquals(v1, v2);
        assertEquals(v3, v4);
    }

    @Test
    void reflect45()
    {
        Vector v1 = new Vector(1,-1,0);
        Vector v2 = new Vector(0,1,0);
        Vector reflect = v1.reflect(v2);
        Vector expected = new Vector(1,1,0);

        assertEquals(expected, reflect);
    }

    @Test
    void reflectSlanted()
    {
        Vector v1 = new Vector(0,-1,0);
        Vector v2 = new Vector(0.707011, 0.707011, 0);
        Vector reflect = v1.reflect(v2);
        Vector expected = new Vector(1,0,0);

        assertEquals(expected, reflect);
    }
}