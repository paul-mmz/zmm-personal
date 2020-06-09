package com.paul.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, DNode> element;
    private DNode head;
    private DNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.element = new HashMap<>(capacity);
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DNode dNode = element.get(key);
        if (dNode != null) {
            dNode.pre.next = dNode.next;
            dNode.next.pre = dNode.pre;

            dNode.next = head.next;
            head.next.pre = dNode;

            dNode.pre = head;
            head.next = dNode;

            return dNode.val;
        }

        return -1;
    }


    public void put(int key, int value) {
        DNode dNode = element.get(key);

        if (dNode != null) {
            dNode.setVal(value);

            dNode.pre.next = dNode.next;
            dNode.next.pre = dNode.pre;
        } else {
            if (element.size() == capacity) {
                dNode = tail.pre;

                element.remove(dNode.key);

                dNode.setKey(key);
                dNode.setVal(value);

                dNode.pre.next = dNode.next;
                dNode.next.pre = dNode.pre;
            } else {
                dNode = new DNode(key, value);
            }
        }

        element.put(key, dNode);

        dNode.next = head.next;
        head.next.pre = dNode;

        dNode.pre = head;
        head.next = dNode;
    }

    public class DNode {
        private int key;
        private int val;
        private DNode pre;
        private DNode next;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public DNode getPre() {
            return pre;
        }

        public void setPre(DNode pre) {
            this.pre = pre;
        }

        public DNode getNext() {
            return next;
        }

        public void setNext(DNode next) {
            this.next = next;
        }
    }
}