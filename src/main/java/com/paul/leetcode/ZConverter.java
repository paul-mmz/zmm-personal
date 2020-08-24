package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/13
 */
public class ZConverter {

    public static String convert(String s, int numRows) {
        if (Objects.isNull(s) || s.length() <= 1 || numRows <= 1 || s.length() < numRows) {
            return s;
        }

        int interval1 = 0, interval2 = 0;
        int sIndex = 0, newIndex = 0;

        char[] newSArr = new char[s.length()];

        for (int i = 0; i < numRows; ++i) {
            interval1 = 2 * (numRows - 1 - i);
            interval2 = 2 * i;
            sIndex = i;

            newSArr[newIndex++] = s.charAt(sIndex);

            while (true) {
                if (interval1 != 0) {
                    sIndex += interval1;

                    if (sIndex >= s.length()) {
                        break;
                    }

                    newSArr[newIndex++] = s.charAt(sIndex);
                }

                if (interval2 != 0) {
                    sIndex += interval2;

                    if (sIndex >= s.length()) {
                        break;
                    }

                    newSArr[newIndex++] = s.charAt(sIndex);
                }
            }
        }

        return new String(newSArr);
    }

    public static String convert_d(String s, int numRows) {
        if (Objects.isNull(s) || s.length() <= 1 || numRows <= 1 || s.length() < numRows) {
            return s;
        }


        char[] newSArr = new char[s.length()];

        int interval = 2 * (numRows - 1);

        int newIndex = 0;

        for (int i = 0; i < numRows; ++i) {

            for (int j = i; j < s.length(); j += interval) {
                newSArr[newIndex++] = s.charAt(j);

                if (i != 0 && i != numRows - 1 && j + interval - 2 * i < s.length()) {
                    newSArr[newIndex++] = s.charAt(j + interval - 2 * i);
                }
            }
        }

        return new String(newSArr);
    }

    public static void main(String[] args) {
        //LCIRETOESIIGEDHN
        System.out.println(convert_d("LEETCODEISHIRING", 3));
    }
}