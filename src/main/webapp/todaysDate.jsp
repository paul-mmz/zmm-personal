<%@page import="javax.annotation.Resource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<%!
	public void jspInit() {
    	System.out.println("jsp init");
    	
	}

	public void jspDestory() {
	    System.out.println("jsp destory");
	}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todays Date</title>
</head>
<body>
	<!-- this is a comment -->
	<%
	    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	    String s = dateFormat.format(new Date());
	    out.println("Today is " + s);
	%>

	<%
	    String userName = request.getParameter("username");
	    out.println(userName);
	%>

	<%
	    pageContext.setAttribute("name", "value", PageContext.REQUEST_SCOPE);
	    request.setAttribute("enheng", "eennhheenngg");
	%>

	<%
	    out.println(request.getAttribute("name"));
	    out.println(request.getAttribute("enheng"));
	    response.setContentType("text/html");
	    String myname = "zmm";
	%>

	<%!
		public void p() {
        	System.out.println("zzz");
    	}
	
		public String q() {
		    return "cccc";
		}
		
		public String qq(String i) {
		    return i;
		}
		
		String ss = "sssssssss";
    %>

	<%=myname%>
	
	<% 
		p(); 
		q();
	%>
	<%=qq(ss) %>
</body>
</html>