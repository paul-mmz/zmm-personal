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
        switch (type) {
            case 1:
                partition = partitionList_1(list, start, end);
                break;
            case 2:
                partition = partitionList_2(list, start, end);
                break;
            case 3:
                partition = partitionList_3(list, start, end);
                break;
            case 4:
                partition = partitionList_4(list, start, end);
                break;
            default:
                return;
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
        while (start < end) {
            while (start < end && list.get(end).compareTo(temp) > -1) {
                --end;
            }
            list.set(start, list.get(end));

            while (start < end && list.get(start).compareTo(temp) < 1) {
                ++start;
            }
            list.set(end, list.get(start));
        }
        list.set(start, temp);

        return start;

    }

    private static <T extends Comparable<T>> int partitionList_2(List<T> list, int start, int end) {
        if (start >= end) {
            return end;
        }
        T temp = list.get(end);
        int i = start, j = end - 1;
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
            T it = list.get(i);
            list.set(i, list.get(j));
            list.set(j, it);
        }
        int index = j + 1;
        if (list.get(i).compareTo(temp) > 0) {
            index = j;
        }
        list.set(end, list.get(index));
        list.set(index, temp);

        return index;
    }

    private static <T extends Comparable<T>> int partitionList_3(List<T> list, int start, int end) {
        if (start >= end) {
            return end;
        }
        T temp = list.get(end);
        int i = start, j = end - 1;
        while (i < j) {
            while (i < j && list.get(i).compareTo(temp) < 1) {
                ++i;
            }
            while (i < j && list.get(j).compareTo(temp) > -1) {
                --j;
            }
            if (i == j) {
                break;
            }
            T it = list.get(i);
            list.set(i, list.get(j));
            list.set(j, it);
        }
        int index = j;
        if (list.get(i).compareTo(temp) < 0) {
            return i + 1;
        }
        list.set(end, list.get(index));
        list.set(index, temp);

        return index;
    }

    private static <T extends Comparable<T>> int partitionList_4(List<T> list, int start, int end) {
        if (start >= end) {
            return end;
        }
        T temp = list.get(end);
        int i = start - 1, j = start -1;
        while (j < end) {
            ++j;
            if (list.get(j).compareTo(temp) < 0) {
                T it = list.get(j);
                list.set(j, list.get(++i));
                list.set(i, it);
            }
        }
        ++i;
        if (i != end) {
            T it = list.get(i);
            list.set(i, temp);
            list.set(end, it);
        }
        return i;
    }

}
