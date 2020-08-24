package com.paul.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class LongestCommonSubSequence {

    public <T> int longestCommonSubSequenceLength(T[] seq1, T[] seq2) {
        if (Objects.isNull(seq1) || Objects.isNull(seq2) || seq1.length == 0 || seq2.length == 0) {
            return 0;
        }

        int[][] arrs = lcsArrsMaker(seq1, seq2);

        return arrs[seq1.length][seq2.length];
    }

    private <T> int[][] lcsArrsMaker(T[] seq1, T[] seq2) {
        int[][] arrs = new int[seq1.length + 1][seq2.length + 1];

        for (int i = 1; i <= seq1.length; ++i) {
            for (int j = 1; j <= seq2.length; ++j) {
                if (seq1[i - 1].equals(seq2[j - 1])) {
                    arrs[i][j] = arrs[i - 1][j - 1] + 1;
                } else {
                    arrs[i][j] = Math.max(arrs[i][j - 1], arrs[i - 1][j]);
                }
            }
        }

        return arrs;
    }

    public <T> Set<List<T>> allLongestCommonSubSequence(T[] seq1, T[] seq2) {
        if (Objects.isNull(seq1) || Objects.isNull(seq2) || seq1.length == 0 || seq2.length == 0) {
            return new HashSet<>();
        }

        int[][] arrs = lcsArrsMaker(seq1, seq2);

        return allLcs(arrs, seq1, seq1.length, seq2, seq2.length);
    }

    private <T> Set<List<T>> allLcs(int[][] arrs, T[] seq1, int seq1Index, T[] seq2, int seq2Index) {
        if (seq1Index == 0 || seq2Index == 0) {
            return null;
        }

        if (seq1[seq1Index - 1].equals(seq2[seq2Index - 1])) {
            Set<List<T>> subLcs = allLcs(arrs, seq1, seq1Index - 1, seq2, seq2Index - 1);

            if (CollectionUtils.isEmpty(subLcs)) {
                List<T> newLcs = new ArrayList<>();
                newLcs.add(seq1[seq1Index - 1]);

                Set<List<T>> newLcss = new HashSet<>();
                newLcss.add(newLcs);
                return newLcss;
            } else {
                for (List<T> sLcs : subLcs) {
                    sLcs.add(seq1[seq1Index - 1]);
                }

                return new HashSet<>(subLcs);
            }
        } else {
            Set<List<T>> lcs = null;

            if (arrs[seq1Index][seq2Index - 1] == arrs[seq1Index][seq2Index]) {
                lcs = allLcs(arrs, seq1, seq1Index, seq2, seq2Index - 1);
            }

            if (arrs[seq1Index - 1][seq2Index] == arrs[seq1Index][seq2Index]) {
                if (lcs == null) {
                    lcs = allLcs(arrs, seq1, seq1Index - 1, seq2, seq2Index);
                } else {
                    lcs.addAll(allLcs(arrs, seq1, seq1Index - 1, seq2, seq2Index));
                }
            }

            return lcs;
        }
    }

    public <T> int longestCommonSubSequenceLength_recursive(T[] seq1, T[] seq2) {
        if (Objects.isNull(seq1) || Objects.isNull(seq2) || seq1.length == 0 || seq2.length == 0) {
            return 0;
        }

        Integer[][] arrs = new Integer[seq1.length][seq2.length];

        int result = lcsCheck(seq1, seq1.length - 1, seq2, seq2.length - 1, arrs);

        return result;
    }

    private <T> int lcsCheck(T[] seq1, int index1, T[] seq2, int index2, Integer[][] arrs) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (arrs[index1][index2] != null) {
            return arrs[index1][index2];
        }

        if (seq1[index1].equals(seq2[index2])) {
            arrs[index1][index2] = lcsCheck(seq1, index1 - 1, seq2, index2 - 1, arrs) + 1;

            return arrs[index1][index2];
        } else {
            arrs[index1][index2] = Math.max(lcsCheck(seq1, index1, seq2, index2 - 1, arrs), lcsCheck(seq1, index1 - 1, seq2, index2, arrs));

            return arrs[index1][index2];
        }
    }

    public <T> Set<List<T>> allLongestCommonSubSequence_recursive(T[] seq1, T[] seq2) {
        if (Objects.isNull(seq1) || Objects.isNull(seq2) || seq1.length == 0 || seq2.length == 0) {
            return new HashSet<>();
        }

        return lcsCheck_all(seq1, seq1.length - 1, seq2, seq2.length - 1);
    }

    private <T> Set<List<T>> lcsCheck_all(T[] seq1, int index1, T[] seq2, int index2) {
        if (index1 < 0 || index2 < 0) {
            return new HashSet<>();
        }

        if (seq1[index1].equals(seq2[index2])) {
            Set<List<T>> subLcs = lcsCheck_all(seq1, index1 - 1, seq2, index2 - 1);

            if (CollectionUtils.isEmpty(subLcs)) {
                List<T> newLcs = new ArrayList<>();
                newLcs.add(seq1[index1]);

                Set<List<T>> newLcss = new HashSet<>();
                newLcss.add(newLcs);
                return newLcss;

            } else {
                for (List lcs : subLcs) {
                    lcs.add(seq1[index1]);
                }
            }

            return new HashSet<>(subLcs);
        } else {
            Set<List<T>> subLcs1 = lcsCheck_all(seq1, index1, seq2, index2 - 1);

            Set<List<T>> subLcs2 = lcsCheck_all(seq1, index1 - 1, seq2, index2);

            if (CollectionUtils.isEmpty(subLcs1)) {
                return subLcs2;
            } else if (CollectionUtils.isEmpty(subLcs2)) {
                return subLcs1;
            } else {
                int len1 = subLcs1.iterator().next().size();
                int len2 = subLcs2.iterator().next().size();

                if (len1 == len2) {
                    subLcs1.addAll(subLcs2);
                    return subLcs1;
                } else {
                    return len1 > len2 ? subLcs1 : subLcs2;
                }
            }
        }
    }

    public static void main(String[] args) {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();
        System.out.println(longestCommonSubSequence.allLongestCommonSubSequence(new Integer[]{1,2,3,2,4,1,2}, new Integer[]{2,4,3,1,2,1}));
    }
}
