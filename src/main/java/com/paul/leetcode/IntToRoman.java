package com.paul.leetcode;

/**
 * @author zmm233489
 * @date 2020/8/19
 */
public class IntToRoman {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman_official(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        StringBuilder re = new StringBuilder();

        Pair partRomanNum = null;

        while (num > 0) {
            partRomanNum = getPartRomanNum(num);

            re.append(partRomanNum.romanNum);

            num -= partRomanNum.mathNum;
        }

        return re.toString();

    }

    public Pair getPartRomanNum(int num) {
        if (num >= 1 && num < 4) {
            return new Pair("I", 1);
        }

        if (num >= 4 && num < 5) {
            return new Pair("IV", 4);
        }

        if (num >= 5 && num < 9) {
            return new Pair("V", 5);
        }

        if (num >= 9 && num < 10) {
            return new Pair("IX", 9);
        }

        if (num >= 10 && num < 40) {
            return new Pair("X", 10);
        }

        if (num >= 40 && num < 50) {
            return new Pair("XL", 40);
        }

        if (num >= 50 && num < 90) {
            return new Pair("L", 50);
        }

        if (num >= 90 && num < 100) {
            return new Pair("XC", 90);
        }

        if (num >= 100 && num < 400) {
            return new Pair("C", 100);
        }

        if (num >= 400 && num < 500) {
            return new Pair("CD", 400);
        }

        if (num >= 500 && num < 900) {
            return new Pair("D", 500);
        }

        if (num >= 900 && num < 1000) {
            return new Pair("CM", 900);
        }

        if (num >= 1000) {
            return new Pair("M", 1000);
        }

        return new Pair("", 0);
    }

    class Pair {
        public String romanNum;
        public int mathNum;

        public Pair(String romanNum, int mathNum) {
            this.romanNum = romanNum;
            this.mathNum = mathNum;
        }
    }
}
