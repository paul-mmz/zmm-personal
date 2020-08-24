package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/18
 */
public class RomanToInt {

    public int romanToInt(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }

        int num = 0, index = 0;
        while (index < s.length() - 1){
            if (getValue(s.charAt(index)) >= getValue(s.charAt(index + 1))) {
                num += getValue(s.charAt(index++));
            } else {
                num += (getValue(s.charAt(index + 1)) - getValue(s.charAt(index)));
                index += 2;
            }
        }

        if (index == s.length() - 1) {
            num += getValue(s.charAt(index));
        }

        return num;
    }

    public int romanToInt_opt(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }

        int num = 0, pre = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); ++i) {
            if (getValue(s.charAt(i)) > pre) {
                num -= pre;
            } else {
                num += pre;
            }

            pre = getValue(s.charAt(i));
        }

        num += pre;

        return num;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }
}
