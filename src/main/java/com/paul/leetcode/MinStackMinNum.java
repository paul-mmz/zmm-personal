package com.paul.leetcode;

import java.util.Stack;

class MinStackMinNum {

    private Stack<Integer> normalStack;
    private Stack<Integer> minNumStack;

    /**
     * initialize your data structure here.
     */
    public MinStackMinNum() {
        this.normalStack = new Stack<>();
        this.minNumStack = new Stack<>();
    }

    public void push(int x) {
        if (normalStack.isEmpty() || x <= minNumStack.peek()) {
            minNumStack.push(x);
        }
        normalStack.push(x);
    }

    public void pop() {
        Integer pop = normalStack.pop();

        if (pop != null && !minNumStack.isEmpty() && pop.equals(minNumStack.peek())) {
            minNumStack.pop();
        }
    }

    public int top() {
        Integer peek = normalStack.peek();
        return peek == null ? 0 : peek;
    }

    public int getMin() {
        return minNumStack.isEmpty() ? 0 : minNumStack.peek();
    }

    public static void main(String[] args) {
        MinStackMinNum minStack = new MinStackMinNum();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
