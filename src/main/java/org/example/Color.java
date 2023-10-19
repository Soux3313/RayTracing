package org.example;

public class Color {

    private double r;
    private double g;
    private double b;

    public Color(double r, double g, double b)
    {
        this.r = limit(r);
        this.g = limit(g);
        this.b = limit(b);
    }

    public Color()
    {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    public double getB() {
        return b;
    }

    public double getG() {
        return g;
    }

    public double getR() {
        return r;
    }

    private double limit(double value)
    {
        if(value > 1.0)
        {
            return 1.0;
        }
        else if(value < 0.0)
        {
            return 0.0;
        }
        else return value;
    }

    public Color add(Color c)
    {
        double red = r +c.r;
        red = limit(red);
        double green = g + c.g;
        green = limit(green);
        double blue = b + c.b;
        blue = limit(blue);

        return new Color(red,green,blue);
    }

    public Color multiply(double scale)
    {
        double red = r * scale;
        red = limit(red);
        double green = g * scale;
        green = limit(green);
        double blue = b * scale;
        blue = limit(blue);

        return new Color(red,green,blue);
    }

    public Color multiply(Color c)
    {
        double red = r * c.r;
        red = limit(red);
        double green = g * c.g;
        green = limit(green);
        double blue = b * c.b;
        blue = limit(blue);

        return new Color(red,green,blue);
    }


}
