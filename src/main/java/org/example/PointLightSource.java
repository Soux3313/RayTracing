package org.example;

public class PointLightSource extends LightSource{
    private final Point position;

    public PointLightSource(Color color, double intensity, Point position) {
        super(color, intensity);
        this.position = position;
    }
    public PointLightSource(Color color,Point position) {
        super(color);
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

}

