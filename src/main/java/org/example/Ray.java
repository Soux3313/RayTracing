package org.example;

public class Ray {

    Point originPoint;
    Point targetPoint;
    Vector vector;

    public Ray(Point point, Vector vector)
    {
        this.originPoint = point;
        this.targetPoint = originPoint.add(vector);
        this.vector = vector;
    }

    public Ray(Point origin, Point target)
    {
        this.originPoint = origin;
        this.targetPoint = target;
        this.vector = targetPoint.sub(originPoint).norm();
    }

    public Point getOriginPoint() {
        return originPoint;
    }

    public Point getTargetPoint() {
        return targetPoint;
    }

    public Vector getVector() {
        return vector;
    }



    public Point pointAt(double distance)
    {
        Vector v = vector.mult(distance);

        return originPoint.add(v);
    }
}
