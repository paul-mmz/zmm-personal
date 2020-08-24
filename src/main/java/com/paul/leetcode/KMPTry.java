package com.paul.leetcode;

public class KMPTry {

    /**
     * [0, endInedx) 里找无字符重复的最长前缀
     * @param str
     * @param endIndex
     * @return
     */
    public static int findNoRepeatCharPrfixIndex(String str, int endIndex) {
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
    public static int subStrMatch(String str, String subStr) {
        if (str == null || subStr == null) {
            return -1;
        }

        int strLength = str.length();
        int subStrLength = subStr.length();

        if (subStrLength > strLength) {
            return -1;
        }

        for (int i = 0; i <= strLength - subStrLength;) {

            int j = 0;

            for (j = 0; j < subStrLength; ++j) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    i += findNoRepeatCharPrfixIndex(subStr, j + 1);
                    break;
                }
            }

            if (j == subStrLength) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "defdefdefdefgdef";
        String subStr = "defg";

        System.out.println(subStrMatch(str, subStr));
    }
}
