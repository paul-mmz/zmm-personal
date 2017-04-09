package com.paul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.paul.spring.beans.Product;
import com.paul.spring.beans.ProductForm;

public class ProductDetails implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("productDetails");

		return modelAndView;
	}

}
