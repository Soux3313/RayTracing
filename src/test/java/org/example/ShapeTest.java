package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    public void testDefaultTransformation() {
        Shape shape = new TestShape();
        assertEquals(Matrix.identity(4), shape.getTransformation());
    }

    @Test
    public void testAssigningTransformation() {
        Shape shape = new TestShape();
        shape.setTransformation(Matrix.translate(2, 3, 4));
        assertEquals(Matrix.translate(2, 3, 4), shape.getTransformation());
    }

    @Test
    public void testDefaultMaterial() {
        Shape shape = new TestShape();
        Material material = shape.getMaterial();
        assertEquals(new Material(), material);
    }

    @Test
    public void testAssigningMaterial() {
        Shape shape = new TestShape();
        Material material = new Material();
        material.setAmbient(1.0);
        shape.setMaterial(material);
        assertEquals(material, shape.getMaterial());
    }

    @Test
    public void testIntersectingScaledShapeWithRay() {
        Ray ray = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        TestShape shape = new TestShape();
        shape.setTransformation(Matrix.scale(2, 2, 2));
        shape.intersect(ray);
        assertEquals(new Point(0, 0, -2.5), shape.getSavedRay().getOriginPoint());
        assertEquals(new Vector(0, 0, 0.5), shape.getSavedRay().getVector());
    }

    @Test
    public void testIntersectingTranslatedShapeWithRay() {
        Ray ray = new Ray(new Point(0, 0, -5), new Vector(0, 0, 1));
        TestShape shape = new TestShape();
        shape.setTransformation(Matrix.translate(5, 0, 0));
        shape.intersect(ray);
        assertEquals(new Point(-5, 0, -5), shape.getSavedRay().getOriginPoint());
        assertEquals(new Vector(0, 0, 1), shape.getSavedRay().getVector());
    }

    @Test
    public void testComputingNormalOnTranslatedShape() {
        Shape shape = new TestShape();
        shape.setTransformation(Matrix.translate(0, 1, 0));
        Vector normal = shape.normalAt(new Point(0, 1.70711, -0.70711));
        assertEquals(new Vector(0, 0.707106, -0.707106), normal);
    }

    @Test
    public void testComputingNormalOnTransformedShape() {
        Shape shape = new TestShape();
        Matrix m = Matrix.scale(1, 0.5, 1).mult(Matrix.rotateZ(0.628318));
        shape.setTransformation(m);
        Vector normal = shape.normalAt(new Point(0, 0.707106, -0.707106));
        assertEquals(new Vector(0, 0.9701425, -0.2425356), normal);
    }
}
