package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author zmm233489
 * @date 2020/7/26
 */
public class LongestCommonSubString {

    public int lcssLength(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2) || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        int[][] lcss = new int[s1.length() + 1][s2.length() + 1];
        int longestLcss = 0;

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if (i == 0 || j == 0) {
                    lcss[i][j] = 0;
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcss[i][j] = lcss[i - 1][j - 1] + 1;
                    longestLcss = Math.max(longestLcss, lcss[i][j]);

                } else {
                    lcss[i][j] = 0;
                }
            }
        }

        return longestLcss;
    }

    public List<String> lcss(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2) || s1.length() == 0 || s2.length() == 0) {
            return Arrays.asList("");
        }

        int[][] lcss = new int[s1.length() + 1][s2.length() + 1];
        int longestLcssLength = 0;

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if (i == 0 || j == 0) {
                    lcss[i][j] = 0;
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcss[i][j] = lcss[i - 1][j - 1] + 1;
                    longestLcssLength = Math.max(longestLcssLength, lcss[i][j]);

                } else {
                    lcss[i][j] = 0;
                }
            }
        }

        return lcssMaker(s1, s2, lcss, longestLcssLength);
    }

    private List<String> lcssMaker(String s1, String s2, int[][] lcss, int longestLcssLength) {
        Set<String> resultSet = new HashSet<>();

        for (int i = 1; i <= s1.length(); ++i) {
            for (int j = 1; j <= s2.length(); ++j) {
                if (longestLcssLength != lcss[i][j]) {
                    continue;
                }

                resultSet.add(s1.substring(i - longestLcssLength, i));
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        //System.out.println(new LongestCommonSubString().lcssLength("abcde", "de"));
        System.out.println(new LongestCommonSubString().lcss("abcdefdefyabcd", "decdefxabcd"));

    }
}
