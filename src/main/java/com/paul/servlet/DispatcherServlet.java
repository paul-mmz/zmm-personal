package com.paul.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name="DispatcherServlet", urlPatterns={"/input", "/productSave"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String uri = request.getRequestURI();
		StringBuilder dispatchUrl = new StringBuilder("");

		if (uri.contains("input")) {
			dispatchUrl.append((new InputProductController()).handleRequest(request, response));
		} else if (uri.contains("productSave")) {
			dispatchUrl.append((new SaveProductController()).handleRequest(request, response));
		} else {
			dispatchUrl.append("/todaysDate.jsp");
		}

		if (dispatchUrl != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatchUrl.toString());
			requestDispatcher.forward(request, response);
		}
	
	}

}
