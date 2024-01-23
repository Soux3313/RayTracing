package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    @Test
    public void testLocalNormalAt() {
        Plane plane = new Plane();
        Vector n1 = plane.localNormalAt(new Point(0, 0, 0));
        Vector n2 = plane.localNormalAt(new Point(10, 0, -10));
        Vector n3 = plane.localNormalAt(new Point(-5, 0, 150));

        assertEquals(new Vector(0, 1, 0), n1);
        assertEquals(new Vector(0, 1, 0), n2);
        assertEquals(new Vector(0, 1, 0), n3);
    }

    @Test
    public void testIntersectWithRayParallelToPlane() {
        Plane plane = new Plane();
        Ray ray = new Ray(new Point(0, 10, 0), new Vector(0, 0, 1));
        Intersections xs = plane.localIntersect(ray);

        assertEquals(0, xs.getCount());
    }

    @Test
    public void testIntersectWithCoplanarRay() {
        Plane plane = new Plane();
        Ray ray = new Ray(new Point(0, 0, 0), new Vector(0, 0, 1));
        Intersections xs = plane.localIntersect(ray);

        assertEquals(0, xs.getCount());
    }

    @Test
    public void testRayIntersectingPlaneFromAbove() {
        Plane plane = new Plane();
        Ray ray = new Ray(new Point(0, 1, 0), new Vector(0, -1, 0));
        Intersections xs = plane.localIntersect(ray);

        assertEquals(1, xs.getCount());
        assertEquals(1.0, xs.get(0).t(), 0.0001);
        assertEquals(plane, xs.get(0).shape());
    }

    @Test
    public void testRayIntersectingPlaneFromBelow() {
        Plane plane = new Plane();
        Ray ray = new Ray(new Point(0, -1, 0), new Vector(0, 1, 0));
        Intersections xs = plane.localIntersect(ray);

        assertEquals(1, xs.getCount());
        assertEquals(1.0, xs.get(0).t(), 0.0001);
        assertEquals(plane, xs.get(0).shape());
    }

}