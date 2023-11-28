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
    public Intersections intersect(Ray ray) {

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
        double t1 = (-b - sqrtDiscriminant) / (2.0 * a);
        double t2 = (-b + sqrtDiscriminant) / (2.0 * a);

        // Hinzufügen der Schnittpunkte zur Liste
        intersectionsList.add(new Intersection(t1, this));
        intersectionsList.add(new Intersection(t2, this));


        return new Intersections(intersectionsList.get(0), intersectionsList.get(1));
    }

    @Override
    public Vector normalAt(Point point) {
        return point.sub(center);
    }
}
