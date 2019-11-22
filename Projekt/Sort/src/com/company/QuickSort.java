package com.company;

public class QuickSort <E extends Comparable<E>>{

    private void swap(E[] values, int left, int right) {
        E temp = values[left];
        values[left] = values[right];
        values[right] = temp;
    }

    private E findPivot(E[] values, int low, int high) {
        int center = (low + high) / 2;
        if(values[low].compareTo(values[center]) > 0) {
            swap(values, low, center);
        }
        if(values[low].compareTo(values[high]) > 0) {
            swap(values, low, high);
        }
        if(values[center].compareTo(values[high]) > 0 ){
            swap(values, center, high);
        }
        swap(values,center,high);
        return values[high];
    }
    private int partition(E[] values, int low, int high) {
        E pivot = findPivot(values, low, high);
        int i= low -1;
        for(int j = low; j < high; j++) {
            if(values[j].compareTo(pivot) < 0) {
                i++;
                swap(values, i , j);
            }
        }
        swap(values, i+1, high);
        return i +1;
    }

    public void sort(E[] values, int low, int high) {
        if(low < high) {
            //pi is the element that is  now in the right position
            int pi = partition(values, low, high);
            sort(values, low, pi -1);
            sort(values, pi +1, high);
        }
    }

    public void quickSort(E[] values) {
        sort(values, 0, values.length-1);
    }
}
