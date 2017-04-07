<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Product</title>
</head>
<body>
<div id="global">
	<form action="productSave" method="post">
		<fieldset>
			<legend>Add a product</legend>
			<p>
				<label for="name">Product name:</label>
				<input type="text" id="name" name="name" tabindex="1">
			</p>
			
			<p>
				<label for="number">Product number:</label>
				<input type="text" id="number" name="number" tabindex="2">
			</p>
			
			<p>
				<label for="category">Product category:</label>
				<input type="text" id="category" name="category" tabindex="3">
			</p>
			<p id="buttons">
				<input id="submit" type="submit" tabindex="4" value="Add Product" >
			</p>
		</fieldset>
	</form>
</div>
</body>
</html>