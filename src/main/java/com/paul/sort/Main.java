package com.paul.sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(9);
        list1.add(8);
        list1.add(7);
        list1.add(6);
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        list1.add(0);
        System.out.println(list1);

//        QuickSort.quickSort(list1, 2);

        HeapSort.heapSort(list1);

        System.out.println(list1);

        System.out.println("******************");

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        System.out.println(list2);

//        QuickSort.quickSort(list2, 2);

        HeapSort.heapSort(list2);

        System.out.println(list2);

    }
}
