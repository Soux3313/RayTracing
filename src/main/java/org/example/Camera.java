package org.example;

public class Camera {
    private int width;
    private int height;
    private double fov;
    private Matrix transform;

    public Camera(int width, int height, double fov)
    {
        this.width = width;
        this.height = height;
        this.fov = Math.toRadians(fov);
        this.transform = Matrix.identity(4);
    }

    public Camera(int width, int height, double fov, Matrix viewTransform)
    {
        this.width = width;
        this.height = height;
        this.fov = Math.toRadians(fov);
        this.transform = viewTransform;
    }

    public Camera(int width, int height, double fov, Point position, Point lookAt, Vector up)
    {
        this.width = width;
        this.height = height;
        this.fov = Math.toRadians(fov);
        this.transform = Matrix.viewTransform(position,lookAt,up);
    }

    public double getFov() {
        return fov;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Matrix getTransform() {
        return transform;
    }
}
