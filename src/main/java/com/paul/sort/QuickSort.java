package com.paul.sort;

import java.util.List;

public class QuickSort {

    public static <T extends Comparable<T> > void quickSort(List<T> list, int type) {
        if (list == null || list.isEmpty()) {
            return;
        }
        innerQuickSort(list, 0, list.size() - 1, type);
    }

    private static <T extends Comparable<T>> void innerQuickSort(List<T> list, int start, int end, int type) {

        int partition = 0;
        if (type == 1) {
            partition = partitionList_1(list, start, end);
        } else if (type == 2) {
            partition = partitionList_2(list, start, end);
        }

        if (partition - 1 > start) {
            innerQuickSort(list, start, partition - 1, type);
        }
        if (partition + 1 < end) {
            innerQuickSort(list, partition + 1, end, type);
        }
    }

    private static <T extends Comparable<T>> int partitionList_1(List<T> list, int start, int end) {
        if (start >= end) {
            return end;
        }

        T temp = list.get(start);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && list.get(j).compareTo(temp) > -1) {
                --j;
            }
            list.set(i, list.get(j));

            while (i < j && list.get(i).compareTo(temp) < 1) {
                ++i;
            }
            list.set(j, list.get(i));
        }
        list.set(i, temp);

        return i;

    }

    private static <T extends Comparable<T>> int partitionList_2(List<T> list, int start, int end) {
        if (start >= end) {
            return end;
        }

        T temp = list.get(start);
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && list.get(j).compareTo(temp) > -1) {
                --j;
            }

            while (i < j && list.get(i).compareTo(temp) < 1) {
                ++i;
            }
            if (i == j) {
                break;
            }
            T it = list.get(j);
            list.set(j, list.get(i));
            list.set(i, it);
        }
        list.set(i, temp);

        return i;

    }
}
