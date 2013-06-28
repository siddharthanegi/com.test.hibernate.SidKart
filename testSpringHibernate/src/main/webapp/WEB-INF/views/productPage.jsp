<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
	<div id='container' align="center">
		<table class="data" border="1">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Warehouse Location</th>

			</tr>
			<tr>
				<td>${Product.id }</td>
				<td>${Product.name}</td>
				<td>${Product.quantity}</td>
				<td>${Product.address.getCname()}</td>
			</tr>
		</table>
	</div>
</body>
</html>