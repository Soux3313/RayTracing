package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    @Test
    void testEncapsule() {
        Sphere sphere = new Sphere();
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
}