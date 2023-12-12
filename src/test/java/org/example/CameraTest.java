package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

    @Test
    void constructCamera() {
        int hSize = 160;
        int vSize = 120;
        int fov = 90;

        Camera c = new Camera(hSize,vSize,fov);

        assertEquals(160,c.getWidth());
        assertEquals(120,c.getHeight());
        assertEquals(90,c.getFov());
        assertEquals(Matrix.identity(4), c.getTransform());
    }

    @Test
    void horizontalPixelSize() {
        Camera c = new Camera(200,125,90);
        assertEquals(0.01,c.getPixelSize(), 0.00001);
    }

    @Test
    void verticalPixelSize() {
        Camera c = new Camera(125,200,90);
        assertEquals(0.01,c.getPixelSize(), 0.00001);
    }

    @Test
    void rayThroughCenter()
    {
        Camera c = new Camera(201,101,90);
        Ray r = c.generateRay(100,50);

        assertEquals(new Point(0,0,0),r.getOriginPoint());
        assertEquals(new Vector(0,0,-1),r.getVector());
    }

    @Test
    void rayThroughCorner()
    {
        Camera c = new Camera(201,101,90);
        Ray r = c.generateRay(0,0);

        assertEquals(new Point(0,0,0),r.getOriginPoint());
        assertEquals(new Vector(0.665186, 0.332593, -0.668512),r.getVector());

    }
    @Test
    void rayThroughTransformed()
    {
        Camera c = new Camera(201,101,90);
        c.setTransform(Matrix.rotateY(0.785398).mult(Matrix.translate(0,-2,5)));
        Ray r = c.generateRay(100,50);

        assertEquals(new Point(0,2,-5),r.getOriginPoint());
        assertEquals(new Vector(0.707106, 0, -0.707106),r.getVector());
    }
}