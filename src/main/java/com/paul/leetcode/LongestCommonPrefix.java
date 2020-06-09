package com.paul.leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix_divide(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int mid = strs.length / 2;

        String leftCommonPrefix = partCommonPrefixFinder(strs, 0, mid);
        String rightCommonPrefix = partCommonPrefixFinder(strs, mid, strs.length);

        return twoStringCommonPrefix_partition(leftCommonPrefix, rightCommonPrefix);
    }

    /**
     * [start, end)
     * @param strs
     * @param start
     * @param end
     * @return
     */
    public static String partCommonPrefixFinder(String[] strs, int start, int end) {
        int diff = end - start;
        if (diff == 0) {
            return "";
        }

        if (diff == 1) {
            return strs[start];
        }

        if (diff == 2) {
            return twoStringCommonPrefix_partition(strs[start], strs[end - 1]);
        }

        int mid = start + diff / 2;

        String leftCommonPrefix = partCommonPrefixFinder(strs, start, mid);
        String rightCommonPrefix = partCommonPrefixFinder(strs, mid, end);

        return twoStringCommonPrefix_partition(leftCommonPrefix, rightCommonPrefix);
    }

    public static String twoStringCommonPrefix_partition(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "";
        }

        // [low, high)
        int low = 0;
        int high = Math.min(str1.length(), str2.length());

        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;

            if (str2.startsWith(str1.substring(0, mid + 1))) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return str1.substring(0, (low + high) / 2);
    }



    public static String twoStringCommonPrefix(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "";
        }

        int minLength = Math.min(str1.length(), str2.length());

        int i = 0;

        for (; i < minLength; ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }

        return str1.substring(0, i);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                // 1. 当前字符串不够长，直接结束匹配
                // 2. 当前字符串够长，当时字符不相同，直接结束匹配
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix_divide(strs));

    }
}