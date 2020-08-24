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

        Arrays.sort(nums);

        int i = 0, j = 0, k = 0;
        int sum = 0;
        Set<List<Integer>> result = new HashSet<>();

        for (i = 0; i < nums.length - 2; ++i) {
            sum = nums[i];

            if (nums[i] > 0) {
                break;
            }

            for (j = i + 1; j < nums.length - 1; ++j) {
                sum += nums[j];

                if (sum > 0) {
                    break;
                }

                for (k = j + 1; k < nums.length; ++k) {
                    sum += nums[k];

                    if (sum > 0) {
                        break;
                    }

                    if (sum == 0) {
                        List<Integer> r1 = new ArrayList<>();
                        r1.add(nums[i]);
                        r1.add(nums[j]);
                        r1.add(nums[k]);

                        result.add(r1);
                    }

                    sum -= nums[k];
                }

                sum -= nums[j];
            }
        }

        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSum_3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, k = -1, firstZeroIndex = -1, lastZeroIndex = -1, temp = -1;

        while (i < nums.length && j >= 0 && i < j) {
            k = (i + j) / 2;

            if (nums[k] < 0 && nums[k + 1] >= 0) {
                break;
            }

            if (nums[k] >= 0) {
                j = k;
                continue;
            }

            if (nums[k + 1] < 0) {
                i = k + 1;
                continue;
            }
        }

        if (!(nums[k] <= 0 && nums[k + 1] >= 0)) {
            return new ArrayList<>();
        }

        if (nums[k + 1] == 0) {
            firstZeroIndex = k + 1;
        } else {
            firstZeroIndex = k;
        }

        temp = nums[k + 1];
        while (++k < nums.length && nums[k] == temp) { ; }
        lastZeroIndex = --k;

        for (i = 0; i <= firstZeroIndex; ++i) {
            for (j = Math.max(lastZeroIndex, i + 2); j < nums.length; ) {
                k = Arrays.binarySearch(nums, i + 1, j, 0 - nums[i] - nums[j]);

                if (k > 0) {
                    List<Integer> r1 = new ArrayList<>();
                    r1.add(nums[i]);
                    r1.add(nums[k]);
                    r1.add(nums[j]);
                    result.add(r1);
                    temp = nums[j];

                    while (++j < nums.length && nums[j] == temp) { ; }
                    continue;
                }
                ++j;
            }
        }

        return new ArrayList<>(result);
    }

    private ThreeSum() {
        throw new AssertionError();
    }

    public static List<List<Integer>> threeSum_4(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> re = new ArrayList<>();

        int left = 0, right = 0, currentSum = 0;

        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    ++left;
                    continue;
                }

                currentSum = nums[left] + nums[right];

                if (currentSum == -nums[i]) {
                    List<Integer> innerRe = new ArrayList<>();
                    innerRe.add(nums[i]);
                    innerRe.add(nums[left]);
                    innerRe.add(nums[right]);
                    re.add(innerRe);
                    ++left;
                    --right;
                } else if (currentSum < -nums[i]) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return re;
    }

    public static List<List<Integer>> threeSum_5(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}