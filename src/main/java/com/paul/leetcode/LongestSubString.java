package com.paul.leetcode;

import org.testng.collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {


    public static int lengthOfLongestSubstring_best(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        int maxSubStringLength = 0;
        int subStrStart = 0;
        Map<Character, Integer> strMetaMap = new HashMap<>();

        int stringLength = s.length();

        for (int i = 0; i < stringLength; ++i) {
            Character cc = new Character(s.charAt(i));

            if (strMetaMap.containsKey(cc)) {
                subStrStart = Math.max(subStrStart, strMetaMap.get(cc) + 1);
            }

            maxSubStringLength = Math.max(maxSubStringLength, i - subStrStart + 1);

            strMetaMap.put(cc, i);
        }

        return maxSubStringLength;
    }

    public static int lengthOfLongestSubstring_better(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        int maxSubStringLength = 0;
        int subStrStart = 0;
        Map<Character, Integer> strMetaMap = new HashMap<>();

        int stringLength = s.length();

        for (int i = 0; i < stringLength; ++i) {
            Character cc = new Character(s.charAt(i));

            // 1. 如果当前字符和当前子字符串里任意一个字符不重复,更新最长字符串长度，更新当前字符串的元素map
            if (!strMetaMap.containsKey(cc)) {
                // 当前字符 - 在s中的index
                strMetaMap.put(cc, i);
                maxSubStringLength = Math.max(maxSubStringLength, i - subStrStart + 1);
            } else {
                // subStrStart的新值只能比当前大，不能比当前小，
                // 因为如果当前字符在子字符串中重复了，那么下一个子字符串的开始索引应该subStrStart 往后，决不能往前
                subStrStart = Math.max(subStrStart, strMetaMap.get(cc) + 1);
                // 因为subStrStart这里可能没有更新，所以当前字符，可能属于最长字符串中的一员，需要把该字符串加进去
                maxSubStringLength = Math.max(maxSubStringLength, i - subStrStart + 1);

                strMetaMap.put(cc, i);
            }
        }

        // 最后的字符也许也能组成一个最长字符串，别忘了对比
        maxSubStringLength = Math.max(maxSubStringLength, stringLength - subStrStart);

        return maxSubStringLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        // 子字符串定义 ：[currentSubStrStartIndex, currentSubStrEndIndex)
        int currentSubStrStartIndex = 0;
        int currentSubStrEndIndex = 0;
        int maxSubStringLength = 0;
        Map<Character, Integer> currentSubStrMetaMap = new HashMap<>();

        int stringLength = s.length();

        for (int i = 0; i < stringLength; ++i) {
            Character cc = new Character(s.charAt(i));

            // 1. 如果当前字符和当前子字符串里任意一个字符不重复，把这个字符加入到当前字符串中
            // 更新最长字符串长度，更新当前字符串的元素map，更新当前字符串的start，end index
            if (!currentSubStrMetaMap.containsKey(cc)) {
                currentSubStrEndIndex = i + 1;
                // 当前字符 - 在s中的index
                currentSubStrMetaMap.put(cc, i);

                int newMaxSubStringLength = currentSubStrEndIndex - currentSubStrStartIndex;
                maxSubStringLength = maxSubStringLength > newMaxSubStringLength ? maxSubStringLength : newMaxSubStringLength;
            } else {
                // 2. 如果当前字符和当前子串里的字符重复
                // 更新当前子串为“重复字符在子串中的后一位开始” 到 当前字符，更新子串的元素map，更新当前子串的start，end index

                currentSubStrStartIndex = currentSubStrMetaMap.get(cc) + 1;
                currentSubStrEndIndex = i + 1;

                currentSubStrMetaMap.clear();

                for (int j = currentSubStrStartIndex; j < currentSubStrEndIndex; ++j) {
                    currentSubStrMetaMap.put(new Character(s.charAt(j)), j);
                }
            }
        }

        return maxSubStringLength;
    }

    public static int lengthOfLongestSubstringWithSubString(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        // 子字符串定义 ：[currentSubStrStartIndex, currentSubStrEndIndex)
        int currentSubStrStartIndex = 0;
        int currentSubStrEndIndex = 0;
        int maxSubStringLength = 0;
        Map<Character, Integer> currentSubStrMetaMap = Maps.newHashMap();
        Map<Integer, String> kindsLengthSubStrMap = Maps.newHashMap();

        int stringLength = s.length();

        for (int i = 0; i < stringLength; ++i) {
            Character cc = new Character(s.charAt(i));

            // 1. 如果当前字符和当前子字符串里任意一个字符不重复，把这个字符加入到当前字符串中
            // 更新最长字符串长度，更新当前字符串的元素map，更新当前字符串的start，end index
            if (!currentSubStrMetaMap.containsKey(cc)) {
                currentSubStrEndIndex = i + 1;
                // 当前字符 - 在s中的index
                currentSubStrMetaMap.put(cc, i);

                int newMaxSubStringLength = currentSubStrEndIndex - currentSubStrStartIndex;
                maxSubStringLength = maxSubStringLength > newMaxSubStringLength ? maxSubStringLength : newMaxSubStringLength;
            } else {
                // 2. 如果当前字符和当前子串里的字符重复，把当前子串加入到kindsLengthSubStrMap中
                // 更新当前子串为“重复字符在子串中的后一位开始” 到 当前字符，更新子串的元素map，更新当前子串的start，end index
                String finishedSubStr = s.substring(currentSubStrStartIndex, currentSubStrEndIndex);
                kindsLengthSubStrMap.put(currentSubStrEndIndex - currentSubStrStartIndex, finishedSubStr);

                currentSubStrStartIndex = currentSubStrMetaMap.get(cc) + 1;
                currentSubStrEndIndex = i + 1;

                currentSubStrMetaMap.clear();

                for (int j = currentSubStrStartIndex; j < currentSubStrEndIndex; ++j) {
                    currentSubStrMetaMap.put(new Character(s.charAt(j)), j);
                }
            }
        }

        // 3. 不要忘了，最后的一个子串还没有保存
        String finishedSubStr = s.substring(currentSubStrStartIndex, currentSubStrEndIndex);
        kindsLengthSubStrMap.put(currentSubStrEndIndex - currentSubStrStartIndex, finishedSubStr);

        System.out.println(kindsLengthSubStrMap);

        return maxSubStringLength;
    }

    public static void main(String[] args) {
        String s = "alouzxilkaxkufsu";
        System.out.println(lengthOfLongestSubstring_best(s));
        System.out.println(lengthOfLongestSubstringWithSubString(s));

    }
}
