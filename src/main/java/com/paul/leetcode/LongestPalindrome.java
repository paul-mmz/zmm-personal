package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/7/27
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (Objects.isNull(s) || s.length() <= 1) {
            return s;
        }

        int maxLeft = 0, maxRight = 0, maxInterval = 0;

        for (int i = 0; i < s.length(); ++i) {
            int leftOdd = i - 1, rightOdd = i + 1, intervalOdd = 0;
            int leftEven = i, rightEven = i + 1, intervalEven = 0;

            while (leftOdd >= 0 && rightOdd < s.length() && s.charAt(leftOdd) == s.charAt(rightOdd)) {
                leftOdd--;
                rightOdd++;
            }

            while (leftEven >= 0 && rightEven < s.length() && s.charAt(leftEven) == s.charAt(rightEven)) {
                leftEven--;
                rightEven++;
            }

            intervalOdd = rightOdd - 1 - leftOdd - 1;
            intervalEven = rightEven - 1 - leftEven - 1;

            if (intervalOdd > intervalEven && intervalOdd > maxInterval) {
                maxLeft = leftOdd + 1;
                maxRight = rightOdd - 1;
                maxInterval = intervalOdd;
            } else if (intervalOdd <= intervalEven && intervalEven > maxInterval) {
                maxLeft = leftEven + 1;
                maxRight = rightEven - 1;
                maxInterval = intervalEven;
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }

    public String longestPalindrome_betterFormat(String s) {
        if (Objects.isNull(s) || s.length() <= 1) {
            return s;
        }

        int maxLen = 0, len1 = 0, len2 = 0, innerMaxLen = 0;
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); ++i) {
            len1 = expendAroundCenter(i, i, s);
            len2 = expendAroundCenter(i, i + 1, s);

            innerMaxLen = Math.max(len1, len2);

            if (innerMaxLen > maxLen) {
                start = i - (innerMaxLen - 1) / 2;
                end = i + innerMaxLen / 2;
                maxLen = innerMaxLen;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expendAroundCenter(int left, int right, String s) {
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /**
     * 已知P(i + 1, j - 1) = true 是个回文串，则有 P(i, j) = {1. S[i] = S[j] then P(i, j) = true; 2. S[i] != S[j] then P(i, j) = false}
     * 初始 P(i, i) = true; P(i, i + 1) = {1. S[i] = S[i + 1] then P(i, i + 1) = true 2. S[i] != S[i + 1] then P(i, i + 1) = false}
     *
     * 如果有长度为5的abcba回文存在，就一定有长度为3的回文存在，如果某次找 n + 1长度的回文没找到，就不用再去找 n + 3长度的回文了
     * 同理 - 如果有长度为4的abba回文存在，就一定有长度为2的回文存在，如果某次找 n长度的回文没找到，就不用再去找 n + 2长度的回文了
     * @param s
     * @return
     */
    public String longestPalindrome_dp(String s) {
        if (Objects.isNull(s) || s.length() <= 1) {
            return s;
        }

        boolean[][] P = new boolean[s.length()][s.length()];

        String re = "";

        /**
         * 记录某次奇数长度或偶数长度的回文是否找到，如果没找到，下次就不需要找对应 +2 长度的回文了
         */
        boolean oddFind = true, evenFind = true, innerFind = false;

        for (int l = 0; l < s.length(); ++l) {
            if ((l + 1) % 2 == 0) {
                if (evenFind) {
                    evenFind = false;
                    innerFind = false;
                } else {
                    continue;
                }
            }

            if ((l + 1) % 2 == 1) {
                if (oddFind) {
                    oddFind = false;
                    innerFind = false;
                } else {
                    continue;
                }
            }

            for (int i = 0; i < s.length() - l; ++i) {
                if ((s.charAt(i) == s.charAt(i + l)) && (l < 2 || P[i + 1][i + l - 1])) {
                    P[i][i + l] = true;
                    innerFind = true;
                }

                if (l + 1 > re.length() && P[i][i + l]) {
                    re = s.substring(i, i + l + 1);
                }
            }

            if ((l + 1) % 2 == 0) {
                evenFind = innerFind;
            } else {
                oddFind = innerFind;
            }
        }

        return re;
    }

    /**
     * manancher算法
     * @param s
     * @return
     */
    public String manacher(String s) {
        if (Objects.isNull(s) || s.length() <= 1) {
            return s;
        }

        String newS = paddingChar(s);

        int[] radius = new int[newS.length()];
        radius[0] = 1;
        int maxRight = 0, center = 0, maxRadius = 1;

        for (int i = 1; i < radius.length; ++i) {
            radius[i] = i < maxRight ? Math.min(radius[2 * center - i], maxRight - i + 1) : 1;

            radius[i] = expendAroundCenter(i - radius[i], i + radius[i], newS) / 2 + 1;

            if (radius[i] > maxRadius) {
                maxRadius = radius[i];
                center = i;
                maxRight = center + maxRadius - 1;
            }
        }

        return s.substring((center - maxRadius) / 2, maxRight / 2);
    }

    public String paddingChar(String s) {
        StringBuilder sb = new StringBuilder("^#");

        for (int i = 0;i < s.length(); ++i) {
            sb.append(s.charAt(i)).append("#");
        }

        sb.append("%");

        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new LongestPalindrome().longestPalindrome("bab"));
        System.out.println(new LongestPalindrome().manacher("abcba"));
    }
}
