package com.paul.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{
    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public MyResponse(HttpServletResponse response) {
        super(response);
    }
}
