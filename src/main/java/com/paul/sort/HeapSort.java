package com.paul.sort;

import java.util.List;

public class HeapSort {

    public static <T extends Comparable<T>> void heapSort(List<T> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        int size = list.size();
        int index = size/2;
        while(index > 0) {
            adjustHeap(list, size, index--);
        }
        while(size > 1) {
            T it = list.get(0);
            list.set(0, list.get(size - 1));
            list.set(size - 1, it);
            adjustHeap(list, --size, 1);
        }

    }

    private static <T extends Comparable<T>> void adjustHeap(List<T> list, int size, int index) {
        if (size <= 1) {
            return;
        }
        int root = index;
        while (2 * root <= size) {
            int left = 2 * root;
            int right = left + 1;
            int largest = root;
            if (list.get(largest - 1).compareTo(list.get(left - 1)) < 0) {
                largest = left;
            }
            if (right <= size && list.get(largest - 1).compareTo(list.get(right - 1)) < 0) {
                largest = right;
            }
            if (largest == root) {
                break;
            }
            T it = list.get(root - 1);
            list.set(root - 1, list.get(largest - 1));
            list.set(largest - 1, it);
            root = largest;
        }

    }
}
