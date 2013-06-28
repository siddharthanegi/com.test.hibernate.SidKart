<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<script type="text/javascript">

	function generateXML(){
		
		$.ajax({
			
			url: "GetXml",
			type: "GET",
			success: function(){
				alert("Xml Generated Successfully");
				
			},
			error:function(){
				alert("Fail !");
				
			},
			
		});
		
		
	}

</script>
</head>
<body>
<div id='container'>
<p><a href="http://localhost:8080/SidKart/admin/products/page/1"><b><em>Click here to PAGINATE!</em></b> </a></p>
<div>
		<b>Order By:</b>
	
	<form method="post" action="http://localhost:8080/SidKart/admin/products/order">
		<input type="radio" name="choice" value="id" checked>ID
		<input type="radio" name="choice" value="name">Name 
		<input type="radio" name="choice" value="quantity">Quantity<br>
		<input type="hidden" name="start" value="1">
		<input type="hidden" name="max" value="${max}">
		<input type="submit" value="Submit">

	</form>
	</div>
	<c:if test="${!empty productList}">
		<table class="data" border="1">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Warehouse Location</th>

			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.category.getCategory() }</td>
					<td>${product.quantity}</td>
					<td>${product.price }</td>
					<td>${product.address.getCname()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div id='xmlreport'>
	<a href="GetXml">Generate XML Report</a><br>
	</div>
		
	<a href="http://localhost:8080/SidKart/">Go Home!</a>
</div>
</body>

</html>