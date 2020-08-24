package com.paul.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TrieTree {

    private TrieTreeNode root;

    public TrieTree(TrieTreeNode root) {
        this.root = root;
    }

    public boolean insertWord(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        TrieTreeNode current = root;
        TrieTreeNode subNode = null;
        int index = 0;
        for (;index < word.length(); ++index) {
            subNode = current.findCharInSubNode(word.charAt(index));

            if (subNode == null) {
                break;
            }

            current = subNode;
        }

        for (;index < word.length(); ++index) {
            TrieTreeNode node = new TrieTreeNode(word.charAt(index));
            current.insertSubNode(node);

            current = node;
        }

        current.markNodeClosed(word);

        return true;
    }

    public TrieTreeNode getRoot() {
        return root;
    }

    static class TrieTreeNode {

        private List<TrieTreeNode> subTreeNodes;

        private boolean isLeaf;

        private boolean isCloseChar;

        private char key;

        private String satelliteKey;

        public TrieTreeNode(char key) {
            this.key = key;
            // 默认是叶子节点，不是单词结尾字符
            this.isLeaf = true;
            this.isCloseChar = false;
        }

        public TrieTreeNode findCharInSubNode(char c) {
            if (isLeaf) {
                return null;
            }

            for (TrieTreeNode subNode : subTreeNodes) {
                if (subNode.getKey() == c) {
                    return subNode;
                }
            }

            return null;
        }

        public boolean insertSubNode(TrieTreeNode subNode) {
            if (Objects.isNull(subTreeNodes)) {
                subTreeNodes = new ArrayList<>();
            }

            // 插入子节点后，就不是叶子节点了
            subTreeNodes.add(subNode);
            isLeaf = false;

            return true;
        }

        public boolean markNodeClosed(String satelliteKey) {
            this.satelliteKey = satelliteKey;
            this.isCloseChar = true;

            return true;
        }

        public boolean isCloseChar() {
            return isCloseChar;
        }

        public char getKey() {
            return key;
        }

        public String getSatelliteKey() {
            return satelliteKey;
        }
    }
}


