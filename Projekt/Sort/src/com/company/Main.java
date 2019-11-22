package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<B> list = new ArrayList<B>();
        ArrayList<? super C> xList = list;


        Integer[] intValues = {17, 3, 9 , 15, 8, 11};
        String[] stringBalues = {"John", "Alice", "Zeus", "Tom", "Breda"};
        BubbleSort bSort = new BubbleSort();

        Person p1 = new Person("Eva", "Andradottir");
        Person p2 = new Person("Mikael", "Karlsson");
        Person p3 = new Person("Mona", "Nilsson");

        Person[] personValues = {p1, p2, p3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(intValues);
        quickSort.quickSort(stringBalues);

        quickSort.quickSort(personValues);
        for(int i : intValues) {
            System.out.println(i);
        }

        for(String s: stringBalues) {
            System.out.println(s);
        }

        for (Person p : personValues) {
            System.out.println(p);
        }


    }
}
