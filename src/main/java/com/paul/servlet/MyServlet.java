package com.paul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MyServlet", urlPatterns = {"/my"})
public class MyServlet implements Servlet {

    private transient ServletConfig servletConfig;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.print("<html><head></head>"
                    + "<body>Hello from " + servletConfig.getServletName()
                    + "</body></html>"
                );
    }

    @Override
    public String getServletInfo() {
        return "MyServlet";
    }

    @Override
    public void destroy() {
    }

}
