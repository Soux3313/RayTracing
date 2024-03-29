package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {
     private final List<Shape> objects = new ArrayList<>();
     private final List<LightSource> lights = new ArrayList<>();
     private Sampler sampler;

     public Scene(Shape... shapes)
     {
         for (Shape shape : shapes) {
             addObject(shape);
         }
         this.sampler = new NoSampler();
     }

    public Sampler getSampler() {
        return sampler;
    }

    public void setSampler(Sampler sampler) {
        this.sampler = sampler;
    }

    public void addObject(Shape shape)
     {
         objects.add(shape);
     }

     public Shape getObj(int index)
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
    public void addLight(LightSource light)
    {
        lights.add(light);
    }
     public LightSource getLit(int index)
     {
         return lights.get(index);
     }

     public List<LightSource> getLights()
     {
         return lights;
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
         Shape sphere = new Sphere();
         Material m = new Material();
         Material m1 = new Material(new Color(0.8,1.0,0.6), m.getAmbient(), 0.7, 0.2, m.getShininess());
         sphere.setMaterial(m1);
         Shape smallSphere = new Sphere();
         Matrix transform = Matrix.scale(0.5,0.5,0.5);
         smallSphere.setTransformation(transform);

         Scene scene = new Scene(sphere, smallSphere);
         LightSource ls = new PointLightSource(new Point(-10,10,-10), new Color(1,1,1));
         scene.addLight(ls);

         return scene;
     }

     public Intersections traceRay(Ray ray)
     {
         Intersections xs = new Intersections();
         for (Shape object : objects) {
             xs.addIntersections(object.intersect(ray));
         }
         xs.sort();
         return xs;
     }

     public Color shadeHit(HitInfo info, int depth)
     {
         Point adjusted = info.position().add(info.normal().mult(0.0000001));
         Color finalColor = new Color("black");
         Color reflect = reflectedColor(info, depth);
         for (LightSource light: lights) {
             boolean isShadowed = isShadowed(adjusted, light);
             finalColor = finalColor.add(
                     info.shape().getMaterial().phongLighting(
                             light,
                             info.position(),
                             info.eye(),
                             info.normal(),
                             isShadowed));
         }
         return finalColor.add(reflect);
     }

     public boolean isShadowed(Point position, LightSource ls)
     {

         //Vector zwischen LightSource und Punkt
         Vector v = ls.directionFromPoint(position);

         //Länge des Vektors
         double distance = v.magnitude();

         //Strahl von Punkt nach Lichtquelle
         Ray ray = new Ray(position, v.norm());

         //Schnittpunkte in Szene
         Intersections xs = traceRay(ray);
         Intersection hit = xs.hit();

         if(hit==null) return false;

         return hit.t() < distance;
     }

    public Color colorAt(Ray ray, int depth) {
        Intersections intersections = traceRay(ray);
        Intersection hit = intersections.hit();
        if (hit == null) return new Color("black");
        HitInfo hitInfo = hit.prepareHitInfo(ray);
        return shadeHit(hitInfo, depth);
    }

    public Color reflectedColor(HitInfo hitInfo, int depth)
    {
        if(depth <= 0) return new Color("black");

        if(hitInfo.shape().getMaterial().getReflexion() == 0) return new Color("black");

        Ray ray = new Ray(hitInfo.position().add(hitInfo.normal().mult(0.0001)), hitInfo.reflect());

        Color color = colorAt(ray, depth-1);

        return color.multiply(hitInfo.shape().getMaterial().getReflexion());
    }

}
