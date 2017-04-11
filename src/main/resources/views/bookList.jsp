<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<h1>Book List</h1>
	<a href="<c:url value="/book_input"/>">Add Book</a>
	<table>
	<tr>
		<th>Category</th>
		<th>Title</th>
		<th>ISBN</th>
		<th>Author</th>
	</tr>
	</table>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.category.name}</td>
			<td>${book.title}</td>
			<td>${book.isbn}</td>
			<td>${book.author}</td>
			<td><a href="book_edit/${book.id}">Edit</a></td>
		</tr>
		<br>
	</c:forEach>
</body>
</html>