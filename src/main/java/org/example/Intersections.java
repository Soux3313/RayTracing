package org.example;

import javax.print.attribute.IntegerSyntax;

public class Intersections {

    private Intersection[] intersections;
    private int count = 0;


    public Intersections(Intersection... intersection)
    {
        this.intersections = new Intersection[intersection.length];

        for(int i = 0; i < intersections.length; i++)
        {
            this.intersections[i] = intersection[i];
        }
        this.intersections = sort(intersection);

        count = intersections.length;

    }

    public Intersection get(int index)
    {
        return intersections[index];
    }

    public int getCount() {
        return count;
    }

    private Intersection[] sort(Intersection[] intersections)
    {
        int length = intersections.length;
        boolean swapped;

        do{
            swapped = false;
            for(int i = 1; i < length; i++)
            {
                if(intersections[i-1].t() > intersections[i].t())
                {
                    Intersection temp = intersections[i - 1];
                    intersections[i - 1] = intersections[i];
                    intersections[i] = temp;
                    swapped = true;
                }
            }
        }while (swapped);

        return intersections;
    }

}
