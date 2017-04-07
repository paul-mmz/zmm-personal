/**
 * 
 */
package com.paul.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hzzhouminmin
 *
 */
public class InputProductController implements Controller{

	/* (non-Javadoc)
	 * @see com.paul.servlet.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/WEB-INF/classes/views/productForm.jsp";
	}

}
