<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<div id='container'>
	<c:if test="${!empty productList}">
		<table class="data" border="1">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Quantity</th>

			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.quantity}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<p>Page: 
	
	<c:forEach var="i" begin="1" end="${pageNo}">
	<a href="http://localhost:8080/SidKart/${usermode }/products/page/${i}">${i} </a>
	</c:forEach>
	</p>
	

	<p>
		<b>Order By:</b>
	</p>
	<form method="post" action="http://localhost:8080/SidKart/${usermode}/products/page/${startPage}/order">
		<input type="radio" name="choice" value="id" checked>ID<br>
		<input type="radio" name="choice" value="name">Name<br> 
		<input type="radio" name="choice" value="quantity">Quantity<br>
		<input type="hidden" name="start" value="${startPage}">
		<input type="hidden" name="max" value="5">
		<input type="submit" value="Submit">

	</form>
	<a href="http://localhost:8080/SidKart/">Go Home!</a>
</div>
</body>
</html>