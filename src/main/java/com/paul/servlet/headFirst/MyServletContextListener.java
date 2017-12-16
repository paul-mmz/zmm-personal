package com.paul.servlet.headFirst;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println(sce.getServletContext().toString()  + "init");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setInitParameter("attr-key1", new String("attr-value1"));
        servletContext.setInitParameter("attr-key2", new String("attr-value1"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.err.println(sce.getServletContext().toString() + "has destorying");
    }
}
