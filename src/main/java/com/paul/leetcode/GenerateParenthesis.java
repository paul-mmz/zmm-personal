package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zmm233489
 * @date 2020/8/23
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return Arrays.asList("()");
        }

        List<String> result = new ArrayList<>();

        innerParenthesisMatch_arr(new char[2 * n], n, n, result);

        return result;
    }

    public List<String> innerParenthesisMatch(int left, int right) {
        if (left == 1 && right == 1) {
            return Arrays.asList("()");
        }

        if (left == 0) {
            StringBuilder rightBrackets = new StringBuilder();
            for (int i = 0; i < right; ++i) {
                rightBrackets.append(')');
            }

            return Arrays.asList(rightBrackets.toString());
        }

        List<String> result = new ArrayList<>();

        List<String> partBrackets = innerParenthesisMatch(left - 1, right);

        for (String partBracket : partBrackets) {
            result.add(new StringBuilder("(").append(partBracket).toString());
        }

        if (left < right) {
            partBrackets = innerParenthesisMatch(left, right - 1);

            for (String partBracket : partBrackets) {
                result.add(new StringBuilder(")").append(partBracket).toString());
            }
        }
        return result;
    }

    public void innerParenthesisMatch_arr(char[] arr, int left, int right, List<String> result) {
        if (left == 1 && right == 1) {
            arr[arr.length - 2] = '(';
            arr[arr.length - 1] = ')';

            result.add(new String(arr));
            return;
        }

        if (left == 0) {
            for (int i = right; i > 0; --i) {
                arr[arr.length - i] = ')';
            }

            result.add(new String(arr));
            return;
        }

        arr[arr.length - left - right] = '(';
        innerParenthesisMatch_arr(arr, left - 1, right, result);

        if (left < right) {
            arr[arr.length - left - right] = ')';
            innerParenthesisMatch_arr(arr, left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(4));
    }
}
