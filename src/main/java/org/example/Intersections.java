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

        sort(this.intersections);

        count = this.intersections.size();
    }

    public Intersection get(int index) {
        return intersections.get(index);
    }

    public int getCount() {
        return count;
    }

    private void sort(List<Intersection> intersections) {
        int length = intersections.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (intersections.get(i - 1).t() > intersections.get(i).t()) {
                    swap(intersections, i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private void swap(List<Intersection> list, int i, int j) {
        Intersection temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
