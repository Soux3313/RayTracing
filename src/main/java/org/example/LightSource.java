package org.example;

public class LightSource {
    private final Color color;
    private final double intensity;

    public LightSource(Color color, double intensity)
    {
        this.color = color;
        this.intensity = intensity;
    }

    public LightSource(Color color)
    {
        this.color = color;
        this.intensity = 1;
    }

    public Color getColor() {
        return color;
    }

    public double getIntensity() {
        return intensity;
    }
}

