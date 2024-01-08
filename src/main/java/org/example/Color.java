package org.example;

public class Color {

    private double r;
    private double g;
    private double b;

    public Color(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color()
    {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    public Color(String identifier)
    {
        switch (identifier) {
            case "black" -> {
                this.r = 0;
                this.g = 0;
                this.b = 0;
            }
            case "white" -> {
                this.r = 1;
                this.g = 1;
                this.b = 1;
            }
            case "green" -> {
                this.r = 0;
                this.g = 1;
                this.b = 0;
            }
            case "yellow" -> {
                this.r = 1;
                this.g = 1;
                this.b = 0;
            }
            case "blue" -> {
                this.r = 0;
                this.g = 0;
                this.b = 1;
            }
            case "cyan" -> {
                this.r = 0;
                this.g = 1;
                this.b = 1;
            }
            case "red" -> {
                this.r = 1;
                this.g = 0;
                this.b = 0;
            }
            case "magenta" -> {
                this.r = 1;
                this.g = 0;
                this.b = 1;
            }
            case "orange" -> {
                this.r = 1;
                this.g = 0.64;
                this.b = 0;
            }
        }

    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass()) return false;
        Color other = (Color) obj;

        return  Math.abs(this.getB() - other.getB()) < 0.000001 &&
                Math.abs(this.getG() - other.getG()) < 0.00001 &&
                Math.abs( this.getR() - other.getR()) < 0.00001;
    }

    @Override
    public String toString()
    {
        return "Color: R="+r+" G="+g+" B="+b;
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
        double green = g + c.g;
        double blue = b + c.b;

        return new Color(red,green,blue);
    }

    public Color multiply(double scale)
    {
        double red = r * scale;
        double green = g * scale;
        double blue = b * scale;

        return new Color(red,green,blue);
    }

    public Color multiply(Color c)
    {
        double red = r * c.r;
        double green = g * c.g;
        double blue = b * c.b;

        return new Color(red,green,blue);
    }

    // Convert the color to an integer format for BufferedImage (TYPE_INT_RGB)
    public int toImageColor() {
        int red = (int) (limit(r) * 255);
        int green = (int) (limit(g) * 255);
        int blue = (int) (limit(b) * 255);
        int redValue = (red & 0xFF) << 16;
        int greenValue = (green & 0xFF) << 8;
        int blueValue = blue & 0xFF;
        return 0xFF000000 | redValue | greenValue | blueValue;
    }
    // Convert an integer from BufferedImage format to a Color object
    public static Color fromImageColor(int imageColor) {
        int red = (imageColor >> 16) & 0xFF;
        int green = (imageColor >> 8) & 0xFF;
        int blue = imageColor & 0xFF;
        double r = (double) red / 255;
        double g = (double) green / 255;
        double b = (double) blue / 255;
        return new Color(r, g, b);
    }

}
