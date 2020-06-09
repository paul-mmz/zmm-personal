package com.paul.leetcode;

public class KMPTry {

    /**
     * [0, endInedx) 里找无字符重复的最长前缀
     * @param str
     * @param endIndex
     * @return
     */
    public static int findNoRepeatLongestPrfixIndex(String str, int endIndex) {
        if (str == null || str.length() == 0 || endIndex <= 0) {
            return 0;
        }

        if (str.length() == 1 || endIndex == 1) {
            return 1;
        }

        int currentCharIndex = 0;
        int newEndIndex = endIndex;

        while (currentCharIndex < newEndIndex){
            for (int i = currentCharIndex + 1; i < newEndIndex; ++i) {
                if (str.charAt(currentCharIndex) == str.charAt(i)) {
                    newEndIndex = i;
                    break;
                }
            }

            ++currentCharIndex;

        }

        return currentCharIndex - 1;
    }

    /**
     * 返回subStr子串在str中匹配的startIndex [startIndex, startIndex + subStr.length())，
     * 未匹配返回 -1
     * @param str
     * @param subStr
     * @return
     */
    public static int subStrMatch_NoRepeatLongestPrefix(String str, String subStr) {
        if (str == null || subStr == null) {
            return -1;
        }

        int strLength = str.length();
        int subStrLength = subStr.length();

        if (subStrLength > strLength) {
            return -1;
        }

        int[] noRepeatLongestPrefixIndexs = new int[subStrLength];

        for (int i = 0; i < subStrLength; ++i) {
            noRepeatLongestPrefixIndexs[i] = findNoRepeatLongestPrfixIndex(subStr, i + 1);
        }

        for (int i = 0; i <= strLength - subStrLength;) {

            int j = 0;

            for (j = 0; j < subStrLength; ++j) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    // 这里其实可以改成
                    i += noRepeatLongestPrefixIndexs[j];
                    break;
                }
            }

            if (j == subStrLength) {
                return i;
            }
        }

        return -1;
    }

    /**
     * subStr字符串中，[0, i] 的前缀和后缀最长匹配的子字符串长度
     * 如 abcabcd - next[5] = 3,既 [0,2] = [3, 5] = abc
     * @param subStr
     * @return
     */
    public static int[] next(String subStr) {
        if (subStr == null) {
            return null;
        }

        int[] result = new int[subStr.length()];

        result[0] = 0;

        for (int i = 1; i < subStr.length(); ++i) {

            // 前提： 已知 [0, i-1] 的最长匹配子串长度是 result[i-1]，既最长匹配字符串是[0, result[i-1] - 1]
            // 1. 如果 subStr.charAt(i) == subStr.charAt(result[i-1]), 则[0, i] 的最长匹配字符串是[0, result[i-1] -1 + 1]
            // 自然 result[i] = result[i - 1] + 1

            // 2. 如果 subStr.charAt(i) != subStr.charAt(result[i-1]),
            // 则 对于 [0, i] 的最长匹配子串只可能在 [0, result[i-1] - 1] 这个字符串的里面,
            // 既有可能是 [0, result[result[i-1] - 1] 字符串 + subStr.charAt(i) 的字符串的长度 - 这里很难理解
            // 既类似于第1步，比较 subStr.charAt(i) 和 subStr.charAt(result[result[i-1]]) 是否相等，并依次递归，直到 i = 0, 此时 result[i] 也就 = 0

            int j = i - 1;

            while (j > 0) {
                if (subStr.charAt(i) == subStr.charAt(result[j])) {
                    result[i] = result[j] + 1;
                    break;
                }

                j = result[j] - 1;
            }
        }

        return result;
    }

    /**
     * 返回subStr子串在str中匹配的startIndex [startIndex, startIndex + subStr.length())，
     * 未匹配返回 -1
     * @param str
     * @param subStr
     * @return
     */
    public static int subStrMatch_KMP(String str, String subStr) {
        if (str == null || subStr == null) {
            return -1;
        }

        int[] next = next(subStr);

        int i = 0;
        int j = 0;

        while (i < str.length() && j < subStr.length()) {
            if (str.charAt(i) != subStr.charAt(j)) {
                if (j == 0) {
                    ++i;
                    continue;
                }

                j = j - next[j - 1] - 1;

                continue;
            }

            ++i;
            ++j;
        }

        if (j == subStr.length()) {
            return i - j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "defdefdefdefgdef";
        String subStr = "defg";

        System.out.println(subStrMatch_NoRepeatLongestPrefix(str, subStr));
        System.out.println(subStrMatch_KMP(str, subStr));
    }
}