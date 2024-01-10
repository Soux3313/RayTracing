package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    Material m = new Material();
    Point position = new Point(0,0,0);
    @Test
    void betweenLightAndSurface()
    {
        Vector eyeV = new Vector(0,0,-1);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,0,-10), new Color("white"));

        Color result = m.phongLighting(light,position,eyeV,normalV,false);
        Color expected = new Color(1.9,1.9,1.9);

        assertEquals(expected,result);
    }

    @Test
    void eyeOffset45()
    {
        Vector eyeV = new Vector(0,0.707106,-0.707106);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,0,-10), new Color("white"));

        Color result = m.phongLighting(light,position,eyeV,normalV,false);
        Color expected = new Color(1.0,1.0,1.0);

        assertEquals(expected,result);
    }

    @Test
    void lightOffset45()
    {
        Vector eyeV = new Vector(0,0,-1);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,10,-10), new Color("white"));

        Color result = m.phongLighting(light,position,eyeV,normalV,false);
        Color expected = new Color(0.736396,0.736396,0.736396);

        assertEquals(expected,result);
    }

    @Test
    void eyeInPath()
    {
        Vector eyeV = new Vector(0,-0.707106,-0.707106);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,10,-10), new Color("white"));

        Color result = m.phongLighting(light,position,eyeV,normalV,false);
        Color expected = new Color(1.636197,1.636197,1.636197);

        assertEquals(expected,result);
    }

    @Test
    void lightBehindSurface()
    {
        Vector eyeV = new Vector(0,0,-1);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,0,10), new Color("white"));

        Color result = m.phongLighting(light,position,eyeV,normalV,false);
        Color expected = new Color(0.1,0.1,0.1);

        assertEquals(expected,result);
    }

    @Test
    void surfaceInShadow()
    {
        Vector eyeV = new Vector(0,0,-1);
        Vector normalV = new Vector(0,0,-1);
        LightSource light = new PointLightSource(new Point(0,0,-10), new Color("white"));

        Color result = m.phongLighting(light, position, eyeV, normalV, true);
        Color expected = new Color(0.1,0.1,0.1);
        assertEquals(expected, result);
    }
}