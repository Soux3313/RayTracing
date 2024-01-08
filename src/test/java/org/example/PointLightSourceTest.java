package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointLightSourceTest {

    @Test
    void construct() {
        Color c = new Color(1,1,1);
        Point p = new Point(0,0,0);
        PointLightSource ls = new PointLightSource(p,c);

        assertEquals(p,ls.getPosition());
        assertEquals(c,ls.getColor());
        assertEquals(ls.getIntensity(),1);
    }

}