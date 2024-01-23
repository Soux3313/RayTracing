package org.example;

public class Cube extends Shape {
    public Cube() {
        super(); // Aufruf des Konstruktors der Oberklasse
    }
    private static class MinMaxT {


        double minT;
        double maxT;

        MinMaxT(double minT, double maxT) {
            this.minT = minT;
            this.maxT = maxT;
        }
    }

    private MinMaxT checkAxis(double origin, double direction) {
        double tminNumerator = -1 - origin;
        double tmaxNumerator = 1 - origin;

        double tmin, tmax;
        if (Math.abs(direction) >= 0.00001) {
            tmin = tminNumerator / direction;
            tmax = tmaxNumerator / direction;
        } else {
            tmin = tminNumerator * Double.POSITIVE_INFINITY;
            tmax = tmaxNumerator * Double.POSITIVE_INFINITY;
        }

        if (tmin > tmax) {
            double temp = tmin;
            tmin = tmax;
            tmax = temp;
        }

        return new MinMaxT(tmin, tmax);
    }

    @Override
    public Intersections localIntersect(Ray localRay) {
        MinMaxT xMinMax = checkAxis(localRay.getOriginPoint().getX(), localRay.getVector().getX());
        MinMaxT yMinMax = checkAxis(localRay.getOriginPoint().getY(), localRay.getVector().getY());
        MinMaxT zMinMax = checkAxis(localRay.getOriginPoint().getZ(), localRay.getVector().getZ());

        double tmin = Math.max(xMinMax.minT, Math.max(yMinMax.minT, zMinMax.minT));
        double tmax = Math.min(xMinMax.maxT, Math.min(yMinMax.maxT, zMinMax.maxT));

        if (tmin > tmax) {
            return new Intersections(); // Kein Schnittpunkt
        }

        return new Intersections(new Intersection(tmin, this), new Intersection(tmax, this));
    }


    @Override
    public Vector localNormalAt(Point localPoint) {
        double maxC = Math.max(Math.abs(localPoint.getX()), Math.max(Math.abs(localPoint.getY()), Math.abs(localPoint.getZ())));

        if (maxC == Math.abs(localPoint.getX())) {
            return new Vector(localPoint.getX(), 0, 0);
        } else if (maxC == Math.abs(localPoint.getY())) {
            return new Vector(0, localPoint.getY(), 0);
        } else {
            return new Vector(0, 0, localPoint.getZ());
        }
    }
}


