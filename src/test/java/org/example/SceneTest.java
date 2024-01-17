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
        PointLightSource ls = new PointLightSource(new Point(-10,10,-10),new Color(1,1,1));
        s.addLight(ls);
        assertEquals(s.getLights().size(), 1);
        assertEquals(s.getObjects().size(), 0);
    }

    @Test
    void defaultScene()
    {
        Scene s = Scene.defaultScene();

        Sphere sphere = new Sphere();
        Material m = new Material();
        Material m1 = new Material(new Color(0.8,1.0,0.6), m.getAmbient(), 0.7, 0.2, m.getShininess());
        sphere.setMaterial(m1);
        Sphere smallSphere = new Sphere();
        Matrix transform = Matrix.scale(0.5,0.5,0.5);
        smallSphere.setTransformation(transform);

        PointLightSource ls = new PointLightSource( new Point(-10,10,-10),new Color(1,1,1));
        s.addLight(ls);

        assertEquals(ls, s.getLit(0));
        assertTrue(s.containsShape(sphere) && s.containsShape(smallSphere));
    }

    @Test
    void noShadowNoCollinear()
    {
        Scene s = Scene.defaultScene();
        Point p = new Point(0,10,0);

        //assertFalse(s.isShadowed(p));
    }

    @Test
    void shadowObjectBetweenPointLight()
    {
        Scene s = Scene.defaultScene();
        Point p = new Point(10,-10,10);

        //assertTrue(s.isShadowed(p));
    }
    @Test
    void noShadowObjectBehindLight()
    {
        Scene s = Scene.defaultScene();
        Point p = new Point(-20,20,-20);

        //assertFalse(s.isShadowed(p));
    }
    @Test
    void noShadowObjectBehindPoint()
    {
        Scene s = Scene.defaultScene();
        Point p = new Point(-2,2,-2);

        //assertFalse(s.isShadowed(p));
    }
}