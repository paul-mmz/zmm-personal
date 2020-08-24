package com.paul.leetcode;

import java.util.Stack;

class MinStack {

    private Stack<Integer> normalStack;
    private Stack<Integer> minNumStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.normalStack = new Stack<>();
        this.minNumStack = new Stack<>();
    }

    public void push(int x) {
        minNumStack.push(normalStack.isEmpty() ? x : Math.min(minNumStack.peek(), x));
        normalStack.push(x);
    }

    public void pop() {
        minNumStack.pop();
        normalStack.pop();
    }

    public int top() {
        Integer peek = normalStack.peek();
        return peek == null ? Integer.MIN_VALUE : peek;
    }

    public int getMin() {
        Integer peek = minNumStack.peek();
        return peek == null ? Integer.MIN_VALUE : peek;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
