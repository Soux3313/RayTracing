package org.example;

public abstract class Shape {


    private Matrix transformation;
    private Material material;

    public Shape() {
        this.transformation = Matrix.identity(4); // Initialisiere mit Einheitsmatrix
        this.material = new Material(); // Standardmaterial zuweisen
    }
    public Matrix getTransformation() {
        return transformation;
    }

    public void setTransformation(Matrix transformation)
    {
        this.transformation = transformation;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Intersections intersect(Ray worldRay)
    {
        Ray ray = worldRay.transform(this.transformation.getInverse());
        return localIntersect(ray);
    }
    public abstract Intersections localIntersect(Ray localRay);
    public Vector normalAt(Point point)
    {
        // Transformieren des worldPoint in das lokale Koordinatensystems
        Point localPoint = this.getTransformation().getInverse().mult(point);
        // Berechne die lokale Normale
        Vector localNormal = localNormalAt(localPoint);
        // Transformiere die lokale Normale in das Weltkoordinatensystem
        Vector worldNormal = getTransformation().getInverse().transpose().mult(localNormal);

        worldNormal.w = 0;

        return worldNormal.norm();
    }
    public abstract Vector localNormalAt(Point point);
}
