package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersections {

    private List<Intersection> intersections;
    private int count = 0;

    public Intersections(Intersection... intersection) {

        this.intersections = new ArrayList<>();

        this.intersections.addAll(Arrays.asList(intersection));

        sort();

        count = this.intersections.size();
    }

    public Intersection get(int index) {
        return intersections.get(index);
    }

    public void addIntersections(Intersections intersections)
    {
        if(intersections.getCount() == 0) return;

        for(int i = 0; i < intersections.getCount(); i++)
        {
            this.intersections.add(intersections.get(i));
        }

        sort();
        count = this.intersections.size();
    }

    public int getCount() {
        return count;
    }

    private void sort() {
        int length = intersections.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (intersections.get(i - 1).t() > intersections.get(i).t()) {
                    swap(i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private void swap(int i, int j) {
        Intersection temp = intersections.get(i);
        intersections.set(i, intersections.get(j));
        intersections.set(j, temp);
    }

    public Intersection hit()
    {
        for(int i = 0; i < intersections.size(); i++)
        {
            if(intersections.get(i).t() > 0) return intersections.get(i);
        }
        return null;
    }
}
