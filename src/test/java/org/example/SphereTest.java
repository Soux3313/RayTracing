package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void intersect2Points() {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(2,xs.getCount());
        assertEquals(4,xs.get(0).t());
        assertEquals(6,xs.get(1).t());
    }

    @Test
    void intersect() {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(2,xs.getCount());
        assertEquals(s,xs.get(0).shape());
        assertEquals(s,xs.get(1).shape());
    }

    @Test
    void intersectTangent() {
        Ray r = new Ray(new Point(0,1,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(2,xs.getCount());
        assertEquals(5,xs.get(0).t());
        assertEquals(5,xs.get(1).t());
    }

    @Test
    void intersectMiss() {
        Ray r = new Ray(new Point(0,2,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(0,xs.getCount());
    }

    @Test
    void intersectInside() {
        Ray r = new Ray(new Point(0,0,0), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(2,xs.getCount());
        assertEquals(-1,xs.get(0).t());
        assertEquals(1,xs.get(1).t());
    }

    @Test
    void intersectBehind() {
        Ray r = new Ray(new Point(0,0,5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Intersections xs = s.intersect(r);

        assertEquals(2,xs.getCount());
        assertEquals(-6,xs.get(0).t());
        assertEquals(-4,xs.get(1).t());
    }

    @Test
    void testX()
    {
        Sphere s = new Sphere();
        Vector n = s.normalAt(new Point(1,0,0));
        Vector expected = new Vector(1,0,0);
        Vector no = n.norm();

        boolean test1 = n.equals(expected);
        boolean test2 = n.equals(no);

        assertTrue(test1);
        assertTrue(test2);

    }
    @Test
    void testY()
    {
        Sphere s = new Sphere();
        Vector n = s.normalAt(new Point(0,1,0));
        Vector expected = new Vector(0,1,0);
        Vector no = n.norm();

        boolean test1 = n.equals(expected);
        boolean test2 = n.equals(no);

        assertTrue(test1);
        assertTrue(test2);
    }
    @Test
    void testZ()
    {
        Sphere s = new Sphere();
        Vector n = s.normalAt(new Point(0,0,1));
        Vector expected = new Vector(0,0,1);
        Vector no = n.norm();

        boolean test1 = n.equals(expected);
        boolean test2 = n.equals(no);

        assertTrue(test1);
        assertTrue(test2);
    }
    @Test
    void testNonAxial()
    {
        Sphere s = new Sphere();
        Vector n = s.normalAt(new Point(0.57735,0.57735,0.57735));
        Vector expected = new Vector(0.57735,0.57735,0.57735);
        Vector no = n.norm();

        boolean test1 = n.equals(expected);
        boolean test2 = n.equals(no);

        assertTrue(test1);
        assertTrue(test2);
    }
    @Test
    void defaultTransformation()
    {
        Sphere s = new Sphere();

        assertEquals(s.getTransformation(), Matrix.identity(4));
    }
    @Test
    void changeTransformation()
    {
        Sphere s = new Sphere();
        Matrix m = Matrix.translate(2,3,4);
        s.setTransformation(m);

        assertEquals(s.getTransformation(), m);
    }
    @Test
    void intersectScaledWithRay()
    {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Matrix m = Matrix.scale(2,2,2);
        s.setTransformation(m);
        Intersections xs = s.intersect(r);

        assertEquals(xs.getCount(), 2);
        assertEquals(xs.get(0).t(), 3);
        assertEquals(xs.get(1).t(), 7);
    }
    @Test
    void intersectTranslationWithRay()//??????????????????????????????????????????????????????
    {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Matrix m = Matrix.translate(5,0,0);
        s.setTransformation(m);
        Intersections xs = s.intersect(r);

        assertEquals(0,xs.getCount());
    }

    @Test
    void computeNormalOnTranslated()
    {
        Sphere s = new Sphere();
        Matrix t = Matrix.translate(0,1,0);
        s.setTransformation(t);
        Point p = new Point(0,1.707106,-0.707106);

        Vector n = s.normalAt(p);
        Vector expected = new Vector(0,0.707106,-0.707106);

        assertEquals(expected,n);
    }

    @Test
    void computeNormalOnScaled()
    {
        Sphere s = new Sphere();
        Matrix t = Matrix.scale(1,0.5,1).mult(Matrix.rotateZ(0.62831));
        s.setTransformation(t);
        Point p = new Point(0,0.70711,-0.70711);

        Vector n = s.normalAt(p);
        Vector expected = new Vector(0,0.970142,-0.242536);

        assertEquals(expected,n);
    }

    @Test
    void defaultMaterial()
    {
        Sphere s = new Sphere();
        Material m = new Material();

        assertEquals(m, s.getMaterial());
    }

    @Test
    void assignedMaterial()
    {
        Sphere s = new Sphere();
        Material m = new Material();
        m.setAmbient(1.0);
        s.setMaterial(m);

        assertEquals(m, s.getMaterial());
    }


}

