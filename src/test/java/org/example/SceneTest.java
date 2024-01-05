package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.*;

class SceneTest {

    @Test
    void createScene() {
        Scene s = new Scene();

        assertEquals(0, s.objectsAmount());
    }
    @Test
    void addUnnamedObject() {
        Scene s = new Scene();
        Sphere sph = new Sphere();
        s.addObject(sph);

        assertTrue(s.containsShape(sph));
    }
    @Test
    void intersectSceneWithRay()
    {
        Scene s = Scene.defaultScene();
        Ray ray = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Intersections xs = s.traceRay(ray);

        assertEquals(4, xs.getCount());
        assertEquals(4,xs.get(0).t());
        assertEquals(4.5,xs.get(1).t());
        assertEquals(5.5,xs.get(2).t());
        assertEquals(6,xs.get(3).t());
    }

    @Test
    void noLights()
    {
        Scene s = new Scene();

        assertEquals(s.getLights().size(), 0);
        assertEquals(s.getObjects().size(), 0);
    }

    @Test
    void lights()
    {
        Scene s = new Scene();
        PointLightSource ls = new PointLightSource(new Color(1,1,1),new Point(-10,10,-10));
        s.addLight(ls);
        assertEquals(s.getLights().size(), 1);
        assertEquals(s.getObjects().size(), 0);
    }

}