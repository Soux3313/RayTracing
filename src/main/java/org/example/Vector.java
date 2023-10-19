package org.example;

public class Vector {

    private double x;
    private double y;
    private double z;
    private double omega;


    public Vector(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        double omega = 0;
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

    public Vector add(Vector a)
    {
        double x = a.getX() + this.getX();
        double y = a.getY() + this.getY();
        double z = a.getZ() + this.getZ();

        return new Vector(x,y,z);
    }

    public Vector subtract(Vector a)
    {
        double x = this.getX() - a.getX();
        double y = this.getY() - a.getY();
        double z = this.getZ() - a.getZ();

        return new Vector(x,y,z);
    }

    public Vector negative()
    {
        double x = this.getX() * -1;
        double y = this.getY() * -1;
        double z = this.getZ() * -1;

        return new Vector(x,y,z);
    }

    public Vector multiply(double scale)
    {
        double x = this.getX() * scale;
        double y = this.getY() * scale;
        double z = this.getZ() * scale;

        return new Vector(x,y,z);
    }

    public Vector divide(double scale)
    {
        if(scale == 0) return this;

        double x = this.getX() / scale;
        double y = this.getY() / scale;
        double z = this.getZ() / scale;

        return new Vector(x,y,z);
    }

    public boolean equals(Vector a)
    {
        return a.getX() == x && a.getY() == y && a.getZ() == z;
    }

    public double magnitude()//√(x² + y² + z²)
    {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double sqrMagnitude()
    {
        return this.magnitude() * this.magnitude();
    }

    public Vector normalized()
    {
        double x = this.getX() / this.magnitude();
        double y = this.getY() / this.magnitude();
        double z = this.getZ() / this.magnitude();

        return new Vector(x,y,z);
    }

    public double dot(Vector a)
    {
        return x * a.getX() + y * a.getY() + z * a.getZ();
    }

    public Vector cross(Vector a)
    {
        double x = this.getY() * a.getZ() - this.getZ() * a.getY();
        double y = this.getZ() * a.getX() - this.getX() * a.getZ();
        double z = this.getX() * a.getY() - this.getY() * a.getX();

        return new Vector(x,y,z);
    }

}
