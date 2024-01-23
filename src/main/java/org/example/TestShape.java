package org.example;

public class TestShape extends Shape{
    private Ray savedRay;

    public Ray getSavedRay() {
        return savedRay;
    }

    @Override
    public Intersections localIntersect(Ray localRay) {
        savedRay = localRay;
        return new Intersections();
    }

    @Override
    public Vector localNormalAt(Point localPoint) {
        return new Vector(localPoint.getX(), localPoint.getY(),localPoint.getZ());
    }
}
