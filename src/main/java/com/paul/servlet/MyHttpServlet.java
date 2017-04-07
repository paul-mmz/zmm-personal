package com.paul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        String userName = (String)req.getParameter("username");
        writer.print("<html><head></head>"
                +"<body>"+userName+"</body>"
                +"</html>");
    }

}
