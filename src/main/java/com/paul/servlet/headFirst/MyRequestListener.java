package com.paul.servlet.headFirst;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;

public class MyRequestListener extends RequestContextListener {

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        super.requestInitialized(requestEvent);
        System.err.println(requestEvent.toString() + "init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        super.requestDestroyed(requestEvent);
        System.err.println(requestEvent.toString() + "destory");
    }
}
