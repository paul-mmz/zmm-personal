package com.paul.servlet.headFirst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BeerSelect extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String color = req.getParameter("color");
        List<String> brands = (new BeerExpert()).getBrands(color);
        req.setAttribute("styles", brands);
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/classes/views/beerSelect.jsp");
        view.forward(req, resp);
    }
}
