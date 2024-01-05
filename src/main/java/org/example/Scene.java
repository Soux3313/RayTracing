package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {
     private final List<Shape> objects = new ArrayList<>();
     private final List<LightSource> lights = new ArrayList<>();

     public Scene(Shape... shapes)
     {
         for (Shape shape : shapes) {
             addObject(shape);
         }
     }

     public void addObject(Shape shape)
     {
         objects.add(shape);
     }

     public void addLight(LightSource light)
     {
         lights.add(light);
     }

     public Shape getObj(int index)
     {
         return objects.get(index);
     }

     public List<Shape> getObjects()
     {
         return objects;
     }

     public LightSource getLit(int index)
     {
         return lights.get(index);
     }

     public List<LightSource> getLights()
     {
         return lights;
     }

     public int objectsAmount()
     {
         return objects.size();
     }

     public boolean containsShape(Shape shape)
     {
         for (Shape object : objects) {
             if (object.getClass() == shape.getClass()) return true;
         }
         return false;
     }

     public static Scene defaultScene()
     {
         Sphere sphere = new Sphere();
         Sphere smallSphere = new Sphere();
         Matrix transform = Matrix.scale(0.5,0.5,0.5);
         smallSphere.setTransformation(transform);

         return new Scene(sphere, smallSphere);
     }

     public Intersections traceRay(Ray ray)
     {
         Intersections xs = new Intersections();
         for (Shape object : objects) {
             xs.addIntersections(object.intersect(ray));
         }
         return xs;
     }
}
