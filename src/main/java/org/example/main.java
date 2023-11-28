package org.example;

public class main {
    public static void main(String[] args) {

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
