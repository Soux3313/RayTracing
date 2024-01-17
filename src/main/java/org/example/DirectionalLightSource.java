package org.example;

public class DirectionalLightSource extends LightSource{

    private final Vector direction;

    public DirectionalLightSource(Color color, double intensity, Vector direction) {
        super(color, intensity);
        this.direction = direction;
    }

    public DirectionalLightSource(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }

    public DirectionalLightSource(Vector direction)
    {
        this.direction = direction;
    }


    @Override
    public boolean isDirectional() {
        return true;
    }

    @Override
    public Vector directionFromPoint(Point p) {
        return direction.norm().negative();
    }

    @Override
    public Vector directionToPoint(Point p) {
        return direction.norm();
    }

    @Override
    public Color colorAtPoint(Point p) {
        return this.getColor().multiply(this.getIntensity());
    }

    @Override
    public double distanceFromPoint(Point p) {
        return Double.POSITIVE_INFINITY;
    }
}
