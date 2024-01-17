package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightSourceTest {

    @Test
    void constructPoint() {
        Color c = new Color(1,1,1);
        Point p = new Point(0,0,0);
        PointLightSource ls = new PointLightSource(p,c);

        assertEquals(p,ls.getPosition());
        assertEquals(c,ls.getColor());
        assertEquals(ls.getIntensity(),1);
    }

    @Test
    public void standardPropertiesPoint() {
        PointLightSource light = new PointLightSource(new Point(0, 0, 0), new Color("white"));
        Point p = new Point(0, 1, 0);

        assertFalse(light.isDirectional());
        assertEquals(1.0, light.distanceFromPoint(p), 0.0001);

        Vector expectedDirection = new Vector(0, 1, 0);
        assertEquals(expectedDirection, light.directionToPoint(p));

        Vector expectedDirectionFromPoint = new Vector(0, -1, 0);
        assertEquals(expectedDirectionFromPoint, light.directionFromPoint(p));

        Color expectedColor = new Color(1, 1, 1);
        assertEquals(expectedColor, light.colorAtPoint(p));
    }
    @Test
    public void customPropertiesPoint() {
        PointLightSource light = new PointLightSource(new Point(0, 0, 0), new Color(0.2, 0.1, 0.3), 3.0);
        Point p = new Point(0, 1, 0);

        assertFalse(light.isDirectional());
        assertEquals(1.0, light.distanceFromPoint(p), 0.0001);

        Vector expectedDirection = new Vector(0, 1, 0);
        assertEquals(expectedDirection, light.directionToPoint(p));

        Vector expectedDirectionFromPoint = new Vector(0, -1, 0);
        assertEquals(expectedDirectionFromPoint, light.directionFromPoint(p));

        Color expectedColor = new Color(0.6, 0.3, 0.9);
        assertEquals(expectedColor, light.colorAtPoint(p));
    }

    @Test
    public void testDirectionalLightStandardParameters() {
        DirectionalLightSource light = new DirectionalLightSource(new Vector(0, -1, 0));
        Point p = new Point(0, 1, 0);

        assertTrue(light.isDirectional());
        assertEquals(Double.POSITIVE_INFINITY, light.distanceFromPoint(p), 0.0001);

        Vector expectedDirection = new Vector(0, -1, 0);
        assertEquals(expectedDirection, light.directionToPoint(p));

        Vector expectedDirectionFromPoint = new Vector(0, 1, 0);
        assertEquals(expectedDirectionFromPoint, light.directionFromPoint(p));

        Color expectedColor = new Color(1, 1, 1);
        assertEquals(expectedColor, light.colorAtPoint(p));
    }

    @Test
    public void testDirectionalLightCustomParameters() {
        DirectionalLightSource light = new DirectionalLightSource(new Color(0.2, 0.1, 0.3), 3.0, new Vector(0, -1, 0));
        Point p = new Point(0, 1, 0);

        assertTrue(light.isDirectional());
        assertEquals(Double.POSITIVE_INFINITY, light.distanceFromPoint(p), 0.0001);

        Vector expectedDirection = new Vector(0, -1, 0);
        assertEquals(expectedDirection, light.directionToPoint(p));

        Vector expectedDirectionFromPoint = new Vector(0, 1, 0);
        assertEquals(expectedDirectionFromPoint, light.directionFromPoint(p));

        Color expectedColor = new Color(0.6, 0.3, 0.9);
        assertEquals(expectedColor, light.colorAtPoint(p));
    }
}