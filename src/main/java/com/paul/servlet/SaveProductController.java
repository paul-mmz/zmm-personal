/**
 * 
 */
package com.paul.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paul.spring.beans.Product;
import com.paul.spring.beans.ProductForm;

/**
 * @author hzzhouminmin
 *
 */
public class SaveProductController implements Controller{

	/* (non-Javadoc)
	 * @see com.paul.servlet.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

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

		return "/WEB-INF/classes/views/productDetails.jsp";
	
	}

}
