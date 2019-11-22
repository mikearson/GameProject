package com.company;

public class BubbleSort<E extends Comparable<E>> {



    public void sort(E[] values) {
        boolean swapped = true;
        for(int j = 1; j < values.length & swapped;j++) {
            swapped = false;
            for(int i = 0; i < values.length-j; i++) {
                if (values[i].compareTo(values[i+1]) > 0) {
                    E temp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = temp;
                    swapped = false;
                }
            }
        }
    }
}
