<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.paul.servlet.headFirst.WelcomeServlet" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Beer Select Result</title>
</head>
<body>
	<h1 align="center">Beer Recommendations JSP</h1>
	<p/>
	<%
		String userName = null;
		if (session.isNew()) {
			userName = "Stranger, This is thr first time to visit our website.";
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName() != null && cookie.getName().equals("userName")) {
						userName = cookie.getValue() + " back to our websit";
						break;
					}
				}
			}
			if(StringUtils.isBlank(userName)) {
				userName = WelcomeServlet.getIdNameMap().get(session.getId());
			}
		}
		out.print("welcome " + userName);
		List<String> styles = (List<String>) request.getAttribute("styles");
		for (String s : styles) {
		    out.print("<br>try: " + s);
		}
	%>
</body>
</html>