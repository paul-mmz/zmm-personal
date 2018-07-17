package com.paul.java8;

public enum OperateImpl {
    ADD((x, y) -> x + y),
    SUB((x, y) -> x - y);

    Operate operate;

    OperateImpl(Operate operate) {
        this.operate = operate;
    }

    public float operate(float a, float b) {
        return operate.operate(a, b);
    }

    public static void main(String[] args) {
        System.out.println(OperateImpl.ADD.operate(100.0f, 20.0f));
        System.out.println(OperateImpl.SUB.operate(100.0f, 20.0f));
    }
}
