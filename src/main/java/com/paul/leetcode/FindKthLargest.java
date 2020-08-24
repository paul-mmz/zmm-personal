package com.paul.leetcode;

public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        int start = 0, end = nums.length - 1;


        while (true) {
            int i = start, j = end, key = nums[end];

            while (i < j) {
                while (i < j && nums[i] >= key) {
                    ++i;
                }

                nums[j] = nums[i];

                while (i < j && nums[j] < key) {
                    --j;
                }

                nums[i] = nums[j];
            }

            nums[j] = key;

            if (k - 1 == j) {
                return key;
            }

            if (k - 1 < j) {
                end = j - 1;
            } else {
                start = j + 1;
            }
        }
    }

    public static int findMaxLargest_heap(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        createMaxHeap(nums, k);

        for (int i = k; i < nums.length; ++i) {
            if (nums[i] < nums[0]) {
                continue;
            }

            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            adjustMinHeap(nums, 0, k);
        }

        return nums[0];
    }

    public static void adjustMinHeap(int[] heap, int adjust, int heapLength) {
        int root = adjust;

        while (root < heapLength / 2) {
            int left = 2 * root + 1, right = 2 * root + 2, mayNew = -1, temp = -1;

            if (right >= heapLength) {
                mayNew = left;
            } else {
                mayNew = heap[left] <= heap[right] ? left : right;
            }

            if (heap[root] <= heap[mayNew]) {
                break;
            }

            temp = heap[root];
            heap[root] = heap[mayNew];
            heap[mayNew] = temp;

            root = mayNew;
        }
    }

    public static void createMaxHeap(int[] nums, int heapLength) {
        int maxRoot = heapLength / 2;
        for (int i = maxRoot - 1; i >= 0; --i) {
            adjustMinHeap(nums, i, heapLength);
        }
    }

    public static void main(String[] args) {
        final int[] nums = {3,2,3,1,2,4,5,5,6};
//        System.out.println(findKthLargest(nums, 9));
        System.out.println(findMaxLargest_heap(nums, 4));
    }
}
