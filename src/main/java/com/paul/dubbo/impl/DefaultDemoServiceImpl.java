package com.paul.dubbo.impl;

import com.paul.dubbo.DemoService;
import org.springframework.stereotype.Service;

@Service("defaultDemoServiceImpl")
public class DefaultDemoServiceImpl implements DemoService {
    @Override
    public String sayHello() {
        return "Hello, I'm DemoServiceImpl";
    }
}
