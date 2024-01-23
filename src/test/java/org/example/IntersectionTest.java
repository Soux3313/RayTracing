package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    @Test
    void testEncapsule() {
        Shape sphere = new Sphere();
        Intersection i1 = new Intersection(3.5,sphere);

        assertEquals(i1.t(), 3.5);
        assertEquals(sphere, i1.shape());
    }

    @Test
    void testCompare()
    {
        Sphere sphere = new Sphere();
        Intersection i1 = new Intersection(3.5,sphere);
        Intersection i2 = new Intersection(0.3,sphere);

        boolean test = i1.t() > i2.t();

        assertTrue(test);
    }

    @Test
    void testAggregate()
    {
        Sphere sphere = new Sphere();

        Intersection i1 = new Intersection(1,sphere);
        Intersection i2 = new Intersection(2,sphere);

        Intersections xs = new Intersections(i1,i2);

        assertEquals(2, xs.getCount());
        assertEquals(1.0, xs.get(0).t());
        assertEquals(2.0, xs.get(1).t());

    }

    @Test
    void hitAllIntersectionsPositive()
    {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(1, s);
        Intersection i2 = new Intersection(2, s);
        Intersections xs = new Intersections(i2,i1);

        assertEquals(i1, xs.hit());
    }
    @Test
    void hitSomeIntersectionsNegative()
    {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(-1, s);
        Intersection i2 = new Intersection(1, s);
        Intersections xs = new Intersections(i2,i1);

        assertEquals(i2, xs.hit());
    }
    @Test
    void hitAllIntersectionsNegative()
    {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(-2, s);
        Intersection i2 = new Intersection(-1, s);
        Intersections xs = new Intersections(i2,i1);

        assertNull(xs.hit());
    }
    @Test
    void hitLowestNonNegative()
    {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(5, s);
        Intersection i2 = new Intersection(7, s);
        Intersection i3 = new Intersection(-3, s);
        Intersection i4 = new Intersection(2, s);
        Intersections xs = new Intersections(i1,i2,i3,i4);

        assertEquals(i4,xs.hit());
    }

}