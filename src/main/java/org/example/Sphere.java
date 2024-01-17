package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends Shape{

    private final Point center;
    private final double radius;

    public Sphere()
    {
        this.center = new Point(0,0,0);
        this.radius = 1;
    }

    @Override
    public Intersections localIntersect(Ray ray) {

        // Der Vektor vom Strahl ursprung zur Kugelmitte
        Vector sphereToRay = ray.getOriginPoint().sub(center);

        // Berechnung der Koeffizienten für die quadratische Gleichung
        double a = ray.getVector().dot(ray.getVector());
        double b = 2.0 * ray.getVector().dot(sphereToRay);
        double c = sphereToRay.dot(sphereToRay) - radius * radius;

        // Berechnung der Diskriminante
        double discriminant = b * b - 4 * a * c;

        // Initialisierung einer Liste für die Schnittpunkte
        List<Intersection> intersectionsList = new ArrayList<>();

        // Fall: Der Strahl verfehlt die Kugel
        if (discriminant < 0) {
            return new Intersections();
        }

        // Berechnung der Schnittpunkte
        double sqrtDiscriminant = Math.sqrt(discriminant);
        double t1 = (-b - sqrtDiscriminant) / (2 * a);
        double t2 = (-b + sqrtDiscriminant) / (2 * a);

        // Hinzufügen der Schnittpunkte zur Liste
        intersectionsList.add(new Intersection(t1, this));
        intersectionsList.add(new Intersection(t2, this));

        Intersections xs = new Intersections(intersectionsList.get(0), intersectionsList.get(1));

        xs.sort();

        return xs;
    }


    @Override
    public Vector normalAt(Point worldPoint) {
        // Transformieren des worldPoint in das lokale Koordinatensystems
        Point localPoint = this.getTransformation().getInverse().mult(worldPoint);
        // Berechne die lokale Normale
        Vector localNormal = localNormalAt(localPoint);
        // Transformiere die lokale Normale in das Weltkoordinatensystem
        Vector worldNormal = getTransformation().getInverse().transpose().mult(localNormal);

        worldNormal.w = 0;

        return worldNormal.norm();
    }

    private Vector localNormalAt(Point localPoint)
    {
        return localPoint.sub(new Point(0,0,0));
    }

}
