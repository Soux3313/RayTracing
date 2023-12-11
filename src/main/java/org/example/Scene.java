package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
     private List<Shape> objects = new ArrayList<>();

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

     public Shape get(int index)
     {
         return objects.get(index);
     }

     public List<Shape> getObjects()
     {
         return objects;
     }

     public int objectsAmount()
     {
         return objects.size();
     }

     public boolean containsShape(Shape shape)
     {
         for(int i = 0; i < objects.size(); i++)
         {
             if(objects.get(i).getClass() == shape.getClass()) return true;
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
         for(int i = 0; i < objects.size(); i++)
         {
             xs.addIntersections(objects.get(i).intersect(ray));
         }
         return xs;
     }
}
