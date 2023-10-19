package org.example;

public class Point {
    private double x;
    private double y;
    private double z;
    private double omega;


    public Point(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.omega = 1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getOmega() {
        return omega;
    }

    public Vector subtract(Point a)
    {
        double x = this.getX() - a.getX();
        double y = this.getY() - a.getY();
        double z = this.getZ() - a.getZ();

        return new Vector(x,y,z);
    }

    public Point subtract(Vector a)
    {
        double x = this.getX() - a.getX();
        double y = this.getY() - a.getY();
        double z = this.getZ() - a.getZ();

        return new Point(x,y,z);
    }

    public Point multiply(double scale)
    {
        double x = this.getX() * scale;
        double y = this.getY() * scale;
        double z = this.getZ() * scale;

        return new Point(x,y,z);
    }

    public Point divide(double scale)
    {
        if(scale == 0) return this;

        double x = this.getX() / scale;
        double y = this.getY() / scale;
        double z = this.getZ() / scale;

        return new Point(x,y,z);

    }

    public Point add(Vector a)
    {
        double x = this.getX() + a.getX();
        double y = this.getY() + a.getY();
        double z = this.getZ() + a.getZ();

        return new Point(x,y,z);
    }

    public boolean equals(Point a)
    {
        return a.getX() == x && a.getY() == y && a.getZ() == z;
    }

    public Point minimum(Point a)
    {
        double x;
        double y;
        double z;

        if(this.getX() > a.getX())
        {
            x = a.getX();
        }
        else x = this.getX();

        if(this.getY() > a.getY())
        {
            y = a.getY();
        }
        else y = this.getY();

        if(this.getZ() > a.getZ())
        {
            z = a.getZ();
        }
        else z = this.getZ();

        return new Point(x,y,z);
    }

    public Point maximum(Point a)
    {
        double x;
        double y;
        double z;

        if(this.getX() < a.getX())
        {
            x = a.getX();
        }
        else x = this.getX();

        if(this.getY() < a.getY())
        {
            y = a.getY();
        }
        else y = this.getY();

        if(this.getZ() < a.getZ())
        {
            z = a.getZ();
        }
        else z = this.getZ();

        return new Point(x,y,z);
    }

}
