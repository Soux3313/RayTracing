package org.example;

public class Camera {
    private final int width;
    private final int height;
    private final double fov;
    private Matrix transform;
    private final double aspectRatio;
    private final double halfView;
    private double halfHeight;
    private double halfWidth;

    public Camera(int width, int height, double fov)
    {
        this.width = width;
        this.height = height;
        aspectRatio =(double) width / (double) height;
        //this.fov = Math.toRadians(fov);
        this.fov = fov;
        this.halfView = Math.tan(Math.toRadians(fov) / 2);
        this.transform = Matrix.identity(4);
        calculate();
    }

    public Camera(int width, int height, double fov, Matrix viewTransform)
    {
        this.width = width;
        this.height = height;
        aspectRatio =(double) width / (double) height;
        //this.fov = Math.toRadians(fov);
        this.fov = fov;
        this.halfView = Math.tan(Math.toRadians(fov) / 2);
        this.transform = viewTransform;
        calculate();
    }

    public Camera(int width, int height, double fov, Point position, Point lookAt, Vector up)
    {
        this.width = width;
        this.height = height;
        aspectRatio =(double) width / (double) height;
        //this.fov = Math.toRadians(fov);
        this.fov = fov;
        this.halfView = Math.tan(Math.toRadians(fov) / 2);
        this.transform = Matrix.viewTransform(position,lookAt,up);
        calculate();
    }

    private void calculate()
    {
        if(getAspectRatio() < 1)
        {
            halfHeight = halfView;
            halfWidth = halfView * aspectRatio;
        }
        else
        {
            halfWidth = halfView;
            halfHeight = halfView / aspectRatio;
        }
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

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public double getHalfView()
    {
        return halfView;
    }

    public double getPixelSize()
    {
        return (2*halfWidth) / width;
    }

    public Ray generateRay(int x, int y)
    {

        double xOffset = (x + 0.5) * getPixelSize();
        double yOffset = (y + 0.5) * getPixelSize();

        double worldX = halfWidth - xOffset;
        double worldY = halfHeight - yOffset;

        Point pixel = transform.getInverse().mult(new Point(worldX,worldY,-1));
        Point origin = transform.getInverse().mult(new Point(0,0,0));

        Vector direction = pixel.sub(origin).norm();

        return new Ray(origin, direction);
    }
}
