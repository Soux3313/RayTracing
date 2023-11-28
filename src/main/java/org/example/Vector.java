package org.example;

public class Vector {

    private double x;
    private double y;
    private double z;
    private double w;


    public Vector(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 0;
    }

    public Vector(double x, double y, double z, double w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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
        return w;
    }

    public Vector add(Vector a)
    {
        double x = a.getX() + this.getX();
        double y = a.getY() + this.getY();
        double z = a.getZ() + this.getZ();

        return new Vector(x,y,z);
    }

    public Vector sub(Vector a)
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

    public Vector mult(double scale)
    {
        double x = this.getX() * scale;
        double y = this.getY() * scale;
        double z = this.getZ() * scale;

        return new Vector(x,y,z);
    }

    public Vector div(double scale)
    {
        if(scale == 0) return this;

        double x = this.getX() / scale;
        double y = this.getY() / scale;
        double z = this.getZ() / scale;

        return new Vector(x,y,z);
    }

    public boolean equals(Vector other) {

        return Math.abs(this.x - other.x) < 0.00001 &&
                Math.abs(this.y - other.y) < 0.00001 &&
                Math.abs(this.z - other.z) < 0.00001 &&
                Math.abs(this.w - other.w) < 0.00001;
    }

    public double magnitude()//√(x² + y² + z²)
    {
        return Math.sqrt(this.sqrMagnitude());
    }

    public double sqrMagnitude()
    {
        return x*x + y*y + z*z;
    }

    public Vector norm()
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

    public String toString()
    {
        return ("V("+this.getX()+","+this.getY()+","+this.getZ()+")");
    }

}
