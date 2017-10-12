package com.paul.proxy.cglib;

import net.sf.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("wo zong shi shu chu gu ding de jie guo");
        Long result = -1L;
        return result;
    }
}
