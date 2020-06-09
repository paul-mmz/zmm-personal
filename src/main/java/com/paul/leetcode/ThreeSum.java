package com.paul.leetcode;

import java.util.*;


public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> resultList = findCertainNumsForSum(nums, 3, 0, 0);

        Set<List<Integer>> resultSet = new HashSet<>(resultList);

        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> findCertainNumsForSum(int[] nums, int numCount, int sum, int startIndex) {
        if (numCount < 1 || startIndex >= nums.length) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = startIndex; i <= nums.length - numCount; ++i) {
            if (numCount == 1) {
                if (nums[i] == sum) {
                    result.add(Arrays.asList(nums[i]));
                }

                continue;
            }

            List<List<Integer>> partCertainNumsArr = findCertainNumsForSum(nums, numCount - 1, sum - nums[i], i + 1);

            for (List partNums : partCertainNumsArr) {
                List<Integer> innerResult = new ArrayList<>();
                innerResult.add(nums[i]);
                innerResult.addAll(partNums);
                result.add(innerResult);
            }
        }

        return result;
    }


    public static List<List<Integer>> threeSum_1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);


        List<List<Integer>> resultList = findCertainNumsForSum_1(nums, 3, 0, 0);
        Set<List<Integer>> resultSet = new HashSet<>(resultList);

        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> findCertainNumsForSum_1(int[] nums, int numCount, int sum, int startIndex) {
        if (numCount < 1 || startIndex >= nums.length) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastOneResult = null;
        List<Integer> currentResult = null;

        for (int i = startIndex; i <= nums.length - numCount; ++i) {
            if (nums[i] > sum) {
                break;
            }

            if (numCount == 1) {
                if (nums[i] == sum) {
                    currentResult = Arrays.asList(nums[i]);
                    if (checkNumListEquals(lastOneResult, currentResult)) {
                        continue;
                    }

                    result.add(currentResult);
                    lastOneResult = currentResult;
                }
                continue;
            }

            List<List<Integer>> partCertainNumsArr = findCertainNumsForSum_1(nums, numCount - 1, sum - nums[i], i + 1);

            for (int j = 0; j < partCertainNumsArr.size(); ++j) {
                currentResult = new ArrayList<>();
                currentResult.add(nums[i]);
                currentResult.addAll(partCertainNumsArr.get(j));

                if (j == 0 && checkNumListEquals(lastOneResult, currentResult)) {
                    break;
                }

                result.add(currentResult);

                if (j == 0) {
                    lastOneResult = currentResult;
                }
            }
        }

        return result;
    }

    public static boolean checkNumListEquals(List<Integer> numList1, List<Integer> numList2) {
        if (numList1 == null || numList2 == null) {
            return false;
        }

        for (int i = 0; i < numList1.size(); ++i) {
            if (!numList1.get(i).equals(numList2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static List<List<Integer>> threeSum_2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int i = -1, j = -1, k = -1, firstZeroIndex = -1, lastZeroIndex = -1, temp = -1;

        while (++j < nums.length && nums[j] < 0);

        if (j == nums.length) {
            return new ArrayList<>();
        }

        firstZeroIndex = j;
        temp = nums[j];

        while (++j < nums.length && nums[j] == temp);

        lastZeroIndex = --j;

        for (i = 0; i <= firstZeroIndex; ++i) {
            for (j = Math.max(lastZeroIndex, i + 2); j < nums.length;) {
                k = Arrays.binarySearch(nums, i + 1, j, 0 - nums[i] - nums[j]);

                if (k > 0) {
                    List<Integer> r1 = new ArrayList<>();
                    r1.add(nums[i]);
                    r1.add(nums[k]);
                    r1.add(nums[j]);

                    result.add(r1);

                    temp = nums[j];

                    while (++j < nums.length && nums[j] == temp);
                    continue;
                }
                ++j;
            }
        }

        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSum_3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        if (nums[0] > 0 && nums[nums.length - 1] < 0) {
            return new ArrayList<>();
        }

        int j = -1, k = -1, temp = -1;

        for (int i = 0; i < nums.length - 2;) {
            if (nums[i] > 0) {
                return result;
            }

            for (j = i + 1, k = nums.length - 1; j < k;) {
                temp = nums[i] + nums[j] + nums[k];

                if (temp == 0) {
                    List<Integer> r1 = new ArrayList<>();
                    r1.add(nums[i]);
                    r1.add(nums[j]);
                    r1.add(nums[k]);

                    result.add(r1);

                    temp = nums[j];
                    while (++j < k && nums[j] == temp);

                    temp = nums[k];
                    while (--k > j && nums[k] == temp);
                    continue;
                }

                if (temp > 0) {
                    --k;
                } else {
                    ++j;
                }
            }

            temp = nums[i];

            while (++i < nums.length - 2 && nums[i] == temp);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum_3(new int[]{0,0,0,0}));
    }
}