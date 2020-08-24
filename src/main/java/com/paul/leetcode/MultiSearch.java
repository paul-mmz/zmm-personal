package com.paul.leetcode;

import java.util.*;

public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        if (smalls == null || smalls.length == 0) {
            return new int[0][0];
        }

        if (Objects.isNull(big) || big.length() <= 0) {
            return new int[smalls.length][0];
        }

        TrieTree trieTree = createTrieTree(smalls);

        Map<String, List<Integer>> multiSearchResult = new HashMap<>();

        for (int i = 0; i < big.length(); ++i) {
            multiSearchStartFromPosition(big, i, trieTree, multiSearchResult);
        }

        int[][] resultArr = new int[smalls.length][];

        for (int i = 0; i < smalls.length; ++i) {
            List<Integer> result = multiSearchResult.get(smalls[i]);

            if (result != null) {
                resultArr[i] = new int[result.size()];

                for (int j = 0; j < result.size(); ++j) {
                    resultArr[i][j] = result.get(j);
                }
            } else {
                resultArr[i] = new int[]{};
            }
        }

        return resultArr;
    }

    private void multiSearchStartFromPosition(String searchString, int startIndex, TrieTree trieTree, Map<String, List<Integer>> searchResultMap) {
        TrieTree.TrieTreeNode current = trieTree.getRoot();

        for (int i = startIndex; i < searchString.length(); ++i) {
            TrieTree.TrieTreeNode node = current.findCharInSubNode(searchString.charAt(i));

            if (node == null) {
                return;
            }

            if (node.isCloseChar()) {
                searchResultMap.computeIfAbsent(node.getSatelliteKey(), k -> new ArrayList<>()).add(startIndex);
            }

            current = node;
        }
    }

    private TrieTree createTrieTree(String[] smalls) {
        TrieTree trieTree = new TrieTree(new TrieTree.TrieTreeNode('/'));

        for (String small : smalls) {
            trieTree.insertWord(small);
        }

        return trieTree;
    }

    public static void main(String[] args) {
        MultiSearch multiSearch = new MultiSearch();
        int[][] result = multiSearch.multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});

        List<int[]> results = Arrays.asList(result);

        results.stream().forEach(arr -> {
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println('\n');
        });

    }
}
