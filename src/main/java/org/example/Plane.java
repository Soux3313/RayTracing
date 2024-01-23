package org.example;

public class Plane extends Shape{
    public Plane() {
        super();
    }
    @Override
    public Intersections localIntersect(Ray localRay) {
        //Strahl läuft parallel / auf der Ebene
        if(Math.abs(localRay.getVector().getY()) < 0.01) return new Intersections();

        //alle anderen fälle → der Strahl schneidet ebene
        double t = -localRay.getOriginPoint().getY() / localRay.getVector().getY();

        Intersection intersection = new Intersection(t, this);

        return new Intersections(intersection);
    }

    @Override
    public Vector localNormalAt(Point point) {
        return new Vector(0,1,0);
    }
}
