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
public interface Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);

}
