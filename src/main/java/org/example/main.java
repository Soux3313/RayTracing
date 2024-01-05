package org.example;

public class main {
    public static void main(String[] args) {
/*
        Canvas image = new Canvas(500,500);
        Sphere sphere = new Sphere();
        Point origin = new Point(0,0,-10);

        for(int i = 0; i < image.getWidth(); i++)
        {
            for(int j = 0; j < image.getHeight(); j++)
            {
                Point p = new Point(0.01*(i-250),0.01*(j-250),0);
                Vector v = p.sub(origin).norm();
                Ray r = new Ray(origin, v);

                Intersections intersections = sphere.intersect(r);
               //System.out.println(ray.getVector().magnitude());

                //System.out.println(r.getVector().toString());

                Color c = new Color(abs(r.getVector().getX()),
                        abs(r.getVector().getY()),
                        0);

                if (intersections.getCount() == 0) {
                    c = new Color("blue"); // Kugel nicht getroffen
                } else {
                    c = new Color("magenta"); // Kugel getroffen
                }


                // Visualisierung des t-Werts
                if (intersections.getCount() > 0) {
                    double t;
                    if(intersections.getCount() > 1)
                    {
                        if(intersections.get(0).t() < intersections.get(1).t())
                        {
                            t = intersections.get(0).t() - 9;

                        }
                        else
                        {
                            t = intersections.get(1).t() - 9;
                        }
                    }
                    else t = intersections.get(0).t() - 9;
                    System.out.println(t);
                    double grayValue = (t);

                    c = new Color(grayValue, grayValue, grayValue);
                }

                if (intersections.getCount() > 0) {
                    Point hitPoint = r.pointAt(intersections.get(0).t());
                    Vector normal = sphere.normalAt(hitPoint).norm();
                    c = new Color( (abs(normal.getX())),
                             (abs(normal.getY())),
                            (abs(normal.getZ())));
                }

                image.setPixel(i,j,c);
            }
        }
        image.saveToFile("test5");

        int width = 400;
        int height = 400;
        double wallZ = 10;
        double wallSize = 7;
        double halfSize = wallSize / 2;
        double pixelSize = wallSize / width;

        Canvas image = new Canvas(width, height);
        Sphere s = new Sphere();
        Matrix transform = Matrix.scale(0.5,1,1);
        Matrix rotate = Matrix.rotateZ(Math.PI/4);
       // s.setTransformation(transform);
        Point origin = new Point(0,0,-10);

        for(int y = 0; y < height - 1; y++)
        {
            double worldY = halfSize - pixelSize * y;
            for(int x = 0; x < width; x++)
            {
                double worldX = -halfSize + pixelSize * x;
                Point position = new Point(worldX, worldY, wallZ);
                Ray ray = new Ray(origin, position);
                Intersections xs = s.intersect(ray);
                Color c;

                if (xs.getCount() == 0) {
                    c = new Color("cyan"); // Kugel nicht getroffen
                } else {
                    c = new Color(1,0.5,0); // Kugel getroffen
                }
                image.setPixel(x,y,c);
            }
        }

        image.saveToFile("transformation8");*/
        Sphere sph1 = new Sphere();
        sph1.setRadius(1);
        sph1.setCenter(new Point(-0.5,1,1.5));

        Sphere sph2 = new Sphere();
        sph2.setRadius(0.5);
        sph2.setCenter(new Point(0.5,0.5,-0.5));

        Sphere sph3 = new Sphere();
        sph3.setRadius(0.33);
        sph3.setCenter(new Point(-1.5,0.33,0.75));

        Sphere sph4 = new Sphere();
        sph4.setRadius(0.75);
        sph4.setCenter(new Point(2,2,2));

        Scene scene = new Scene(sph1, sph2, sph3, sph4);

        PointLightSource ls = new PointLightSource(new Color(1,1,1), 1, new Point(-10,10,-10));
        scene.addLight(ls);

        int width = 800;
        int height = 400;
        double fov = 60;
        Point position = new Point(0,1.5,-5);
        Point lookAt = new Point(0,1,0);
        Vector up = new Vector(0,1,0);
        Camera camera = new Camera(width,height,fov,position,lookAt,up);
        RayTracer rt = new RayTracer(scene, camera);
        rt.render();
        Canvas canvas = rt.getRenderTarget();
        canvas.saveToFile("scendfafaasasde2");


    }

    private static double abs(double value)
    {
        if (value < 0)
        {
            return value * -1;
        }
        else return value;
    }
}
