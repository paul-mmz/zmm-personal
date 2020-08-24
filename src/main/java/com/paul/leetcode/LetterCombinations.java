package com.paul.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/23
 */
public class LetterCombinations {

    public static String[] dial = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.length() <= 0) {
            return new ArrayList<>();
        }

        List<String> re = new ArrayList<>();

        singleLetterComb(digits, 0, new StringBuilder(), re);

        return re;
    }

    public void singleLetterComb(String digits, int startIndex, StringBuilder currentPrefix,
        List<String> currentResult) {

        String alph = dial[digits.charAt(startIndex) - '0'];

        if (startIndex == digits.length() - 1) {
            for (int i = 1; i < alph.length(); ++i) {
                currentResult.add(new StringBuilder(currentPrefix.toString()).append(alph.charAt(i)).toString());
            }

            currentResult.add(currentPrefix.append(alph.charAt(0)).toString());

            return;
        }

        for (int i = 1; i < alph.length(); ++i) {
            singleLetterComb(digits, startIndex + 1, new StringBuilder(currentPrefix.toString()).append(alph.charAt(i)),
                currentResult);
        }

        singleLetterComb(digits, startIndex + 1, currentPrefix.append(alph.charAt(0)), currentResult);
    }
}
