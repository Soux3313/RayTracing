package org.example;

public class PointLightSource extends LightSource{
    private final Point position;

    public PointLightSource( Point position, Color color, double intensity) {
        super(color, intensity);
        this.position = position;

    }
    public PointLightSource(Point position, Color color) {
        super(color);
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }
    public boolean isDirectional()
    {
       return false;
    }

    public Vector directionFromPoint(Point p)
    {
        return getPosition().sub(p).norm();
    }

    public Vector directionToPoint(Point p)
    {
        return p.sub(getPosition()).norm();
    }

    public double distanceFromPoint(Point p)
    {
        return this.position.sub(p).magnitude();
    }
    public Color colorAtPoint(Point p)
    {
        double distance = this.distanceFromPoint(p);
        double attenuation = 1.0 / (distance * distance);
        return this.getColor().multiply(this.getIntensity() * attenuation);
    }
    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) return false;
        PointLightSource other = (PointLightSource) obj;

        return  this.getColor().equals(other.getColor()) &&
                Math.abs(this.getIntensity() - other.getIntensity()) < 0.00001 &&
                this.getPosition().equals(other.getPosition());
    }
}

