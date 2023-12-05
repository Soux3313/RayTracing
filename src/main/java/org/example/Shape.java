package org.example;

public abstract class Shape {

    private Matrix transformation = Matrix.identity(4);

    public Matrix getTransformation() {
        return transformation;
    }

    public void setTransformation(Matrix transformation)
    {
        this.transformation = transformation;
    }

    public Intersections intersect(Ray worldRay)
    {
        Ray ray = worldRay.transform(this.transformation.getInverse());
        return localIntersect(ray);
    };
    public abstract Intersections localIntersect(Ray localRay);
    public abstract Vector normalAt(Point point);
}
