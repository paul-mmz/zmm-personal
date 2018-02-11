package com.paul.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

	private FilterConfig config;
	
    /**
     * Default constructor. 
     */
    public MyFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("zhe li shi: " + config.getInitParameter("site"));
//		MyResponse myRes = new MyResponse((HttpServletResponse) response);
//		chain.doFilter(request, myRes);
		chain.doFilter(request,response);
		System.out.println("after myFilter process……");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
