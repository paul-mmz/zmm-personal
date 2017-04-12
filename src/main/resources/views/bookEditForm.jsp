<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Book Form</title>
</head>
<body>
	<form:form commandName="book" action="../book_update" method="post">
		<fieldset>
			<legend>Edit a book</legend>
			<form:hidden path="id" />
			<p>
				<label for="category">Category: </label>
				<form:select id="category" path="category.id" items="${categories}"
					itemLabel="name" itemValue="id" />
			</p>

			<p>
				<label for="titile">Title: </label>
				<form:input id="title" path="title" />
			</p>

			<p>
				<label for="author">Author: </label>
				<form:input id="author" path="author" />
			</p>

			<p>
				<label for="isbn">ISBN: </label>
				<form:input id="isbn" path="isbn" />
			</p>

			<p>
				<label for="price">Price: </label>
				<form:input id="price" path="price" />
				<!-- <input type="text" id="price" name="price"> -->
			</p>

			<p id="buttons">
				<input id="reset" type="reset" tabindex="4"> <input
					id="submit" type="submit" tabindex="5" value="Update Book">
			</p>
		</fieldset>
	</form:form>
</body>
</html>