package com.paul.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paul.spring.beans.Product;
import com.paul.spring.beans.ProductForm;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		StringBuilder dispatchUrl = new StringBuilder("");

		if (uri.contains("productInput")) {
			dispatchUrl.append("/WEB-INF/classes/views/productForm.jsp");
		} else if (uri.contains("productSave")) {
			ProductForm productForm = new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setNumber(request.getParameter("number"));
			productForm.setCategory(request.getParameter("category"));

			Product product = new Product();
			product.setName(productForm.getName());
			String nubmerStr = productForm.getNumber();
			Long numberLong = null;
			try {
				numberLong = Long.parseLong(nubmerStr);
			} catch (Exception e) {
				System.out.println("number parse error");
			}
			product.setNumber(numberLong);
			product.setCategory(productForm.getCategory());

			request.setAttribute("product", product);

			dispatchUrl.append("/WEB-INF/classes/views/productDetails.jsp");
		} else {
			dispatchUrl.append("/todaysDate.jsp");
		}

		if (dispatchUrl != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatchUrl.toString());
			requestDispatcher.forward(request, response);
		}
	}

}
