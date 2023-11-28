package org.example;

public class main {
    public static void main(String[] args) {

        Canvas image = new Canvas(500,500);
        Point spectator = new Point(250,250,-100);

        for(int i = 0; i < image.getWidth(); i++)
        {
            for(int j = 0; j < image.getHeight(); j++)
            {
                Point p = new Point(i,j,0);
                Ray ray = new Ray(spectator, p);
               //System.out.println(ray.getVector().magnitude());
                System.out.println(ray.getVector().toString());
                Color c = new Color(abs(ray.getVector().sqrMagnitude()),
                        abs(ray.getVector().sqrMagnitude()),
                        abs(ray.getVector().sqrMagnitude()));
                image.setPixel(i,j,c);
            }
        }
        image.saveToFile("test4");
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
