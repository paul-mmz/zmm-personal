<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Product</title>
</head>
<body>
	<div id="global">
		<h4>The product has been saved.</h4>
		<p>
			<h5>Details:</h5>
			Product Name: ${product.name} <br/>
			Product Number: ${product.number} <br/>
			Product Category: ${product.category}
		</p>
	</div>
</body>
</html>