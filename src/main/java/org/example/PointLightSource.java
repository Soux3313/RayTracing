package org.example;

public class PointLightSource extends LightSource{


    public PointLightSource( Point position, Color color, double intensity) {
        super(position, color, intensity);

    }
    public PointLightSource(Point position, Color color) {
        super(position, color);
    }

}

