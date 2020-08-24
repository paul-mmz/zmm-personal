package com.paul.leetcode;

import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zmm233489
 * @date 2020/8/14
 */
public class MyAtoi {

    public int myAtoi(String str) {
        if (Objects.isNull(str) || str.length() <= 0) {
            return 0;
        }

        int index = 0;

        while (index < str.length() && str.charAt(index) == ' ') {
            ++index;
        }

        if (index >= str.length()) {
            return 0;
        }

        int z = 0, signed = 1, maxZ = Integer.MAX_VALUE / 10, minZ = Integer.MIN_VALUE / 10, currentNum = 0;

        if (str.charAt(index) == '-') {
            signed = -1;
            ++index;
        } else if (str.charAt(index) == '+') {
            ++index;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            currentNum = str.charAt(index) - '0';

            if (z > maxZ || (z == maxZ && currentNum > 7)) {
                return Integer.MAX_VALUE;
            }

            if (z < minZ || (z == minZ && currentNum > 8)) {
                return Integer.MIN_VALUE;
            }

            z = z * 10 + currentNum * signed;

            ++index;
        }

        return z;
    }

    private static final int START = 0;
    private static final int SIGNED = 1;
    private static final int IN_NUMBER = 2;
    private static final int END = 3;
    private static int[][] stateMachine = new int[4][];

    static {
        stateMachine[0] = new int[]{0, 1, 2, 3};
        stateMachine[1] = new int[]{3, 3, 2, 3};
        stateMachine[2] = new int[]{3, 3, 2, 3};
        stateMachine[3] = new int[]{3, 3, 3, 3};
    }

    public int getColumnByChar(char c) {
        if (c == ' ') {
            return 0;
        }

        if (c == '-' || c == '+') {
            return 1;
        }

        if (c >= '0' && c <= '9') {
            return 2;
        }

        return 3;
    }

    public int myAtoi_stateMachine(String str) {
        if (Objects.isNull(str) || str.length() <= 0) {
            return 0;
        }

        int z = 0, signed = 1, maxZ = Integer.MAX_VALUE / 10, minZ = Integer.MIN_VALUE / 10, currentNum = 0, currentState = START;

        for (int i = 0; i < str.length(); ++i) {
            currentState = stateMachine[currentState][getColumnByChar(str.charAt(i))];

            if (currentState == END) {
                return z;
            }

            if (currentState == START) {
                continue;
            }

            if (currentState == SIGNED) {
                signed = str.charAt(i) == '-' ? -1 : 1;
                continue;
            }

            currentNum = str.charAt(i) - '0';

            if (z > maxZ || (z == maxZ && currentNum > 7)) {
                return Integer.MAX_VALUE;
            }

            if (z < minZ || (z == minZ && currentNum > 8)) {
                return Integer.MIN_VALUE;
            }

            z = z * 10 + currentNum * signed;
        }

        return z;
    }

    public int myAtoi_pattern(String str) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        if (!m.find( )) {
            return 0;
        }

        BigInteger ans = new BigInteger(m.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        return ans.intValue();

    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi_pattern("    -42  abc  "));
    }
}
