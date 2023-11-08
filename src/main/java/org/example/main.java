package org.example;

public class main {
    public static void main(String[] args) {

        Canvas image = new Canvas(500,500);
        Point spectator = new Point(0,0,-100);

        for(int i = 0; i < image.getWidth(); i++)
        {
            for(int j = 0; j < image.getHeight(); j++)
            {
                Point p = new Point(i,j,0);
                Ray ray = new Ray(spectator, p);
               //System.out.println(ray.getVector().magnitude());
                System.out.println(ray.getVector().toString());
                Color c = new Color(ray.getVector().getX(),
                        ray.getVector().getY(),
                        ray.getVector().getZ());

                image.setPixel(i,j,c);
            }
        }
        image.saveToFile("test3");
    }
}
