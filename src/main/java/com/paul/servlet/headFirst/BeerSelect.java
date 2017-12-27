package com.paul.servlet.headFirst;

import org.springframework.util.CollectionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class BeerSelect extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String color = req.getParameter("color");
        List<String> brands = (new BeerExpert()).getBrands(color);
        if(CollectionUtils.isEmpty(brands)) {
            brands = new ArrayList<>();
        }
        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            brands.add(servletConfig.getInitParameter(s));
        }

        ServletContext servletContext = servletConfig.getServletContext();
        Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();
        while(initParameterNames1.hasMoreElements()) {
            brands.add(servletContext.getInitParameter(initParameterNames1.nextElement()));
        }

        req.setAttribute("styles", brands);
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/classes/views/beerSelect.jsp");
        view.forward(req, resp);
    }
}
