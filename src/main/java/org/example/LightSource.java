package org.example;

public abstract class LightSource {
    private final Color color;
    private final double intensity;


    public LightSource(Color color, double intensity)
    {
        this.color = color;
        this.intensity = intensity;
    }

    public LightSource( Color color)
    {
        this.color = color;
        this.intensity = 1;
    }

    public LightSource()
    {
        this.color = new Color("white");
        this.intensity = 1;
    }


    public Color getColor() {
        return color;
    }

    public double getIntensity() {
        return intensity;
    }


    public abstract boolean isDirectional();

    public abstract Vector directionFromPoint(Point p);

    public abstract Vector directionToPoint(Point p);

    public abstract Color colorAtPoint(Point p);
    public abstract double distanceFromPoint(Point p);


}

