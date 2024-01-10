package org.example;

public record Intersection(double t, Shape shape) {
    public HitInfo prepareHitInfo(Ray ray)
    {
           Point position = ray.pointAt(t);
           Vector eye = ray.getVector().negative();
           Vector normal = shape.normalAt(position);

           return new HitInfo(shape,t,position,eye,normal);
    }
}
