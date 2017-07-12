package com.paul.zmm_personal;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hzzhouminmin on 2017/7/12.
 */
public class Increment {

    private Long appMessageRandomId = 1l;
    private Long defaultFirstIdValue = 1000000l; // 从100w开始递增
    private AtomicLong incrIdNum = new AtomicLong(0);


    public Long createAppMessageIdInLocalCache() {
        String temp = new StringBuilder().append(appMessageRandomId)
                .append(defaultFirstIdValue + incrIdNum.incrementAndGet()).toString();
        return Long.parseLong(temp);
    }
}
