package com.paul.leetcode;

public class OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        if (first.length() == second.length()) {
            return mostKdiff(first, 0, second, 0, 1);
        }

        String moreLength = first.length() > second.length() ? first : second;
        String lessLength = first.length() < second.length() ? first : second;


        int diffIndex = 0;

        for (;diffIndex < moreLength.length() && diffIndex < lessLength.length(); ++diffIndex) {
            if (moreLength.charAt(diffIndex) != lessLength.charAt(diffIndex)) {
                break;
            }
        }

        return mostKdiff(moreLength, diffIndex + 1, lessLength, diffIndex, 0);
    }

    public boolean mostKdiff(String first, int startIndex1, String second, int startIndex2, int k) {
        int diffCount = 0;

        for (int i = startIndex1, j = startIndex2; i < first.length() && j < second.length(); ++i, ++j) {
            if (first.charAt(i) != second.charAt(j)) {
                ++diffCount;
            }

            if (diffCount > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String first =  "teacher";
        String second = "attacher";

        System.out.println(new OneEditAway().oneEditAway(first, second));
    }
}
