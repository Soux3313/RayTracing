package org.example;

public class LightSource {
    private final Color color;
    private final double intensity;
    private final Point position;

    public LightSource(Point position, Color color, double intensity)
    {
        this.position = position;
        this.color = color;
        this.intensity = intensity;
    }

    public LightSource(Point position, Color color)
    {
        this.position = position;
        this.color = color;
        this.intensity = 1;
    }

    public Point getPosition() {
        return position;
    }
    public Color getColor() {
        return color;
    }

    public double getIntensity() {
        return intensity;
    }
    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) return false;
        LightSource other = (LightSource) obj;

        return  this.getColor().equals(other.getColor()) &&
                Math.abs(this.getIntensity() - other.getIntensity()) < 0.00001 &&
                this.getPosition().equals(other.getPosition());
    }

}

