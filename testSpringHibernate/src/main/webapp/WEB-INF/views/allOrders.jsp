<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Orders</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {
    $('#more_details').hide();
   $("#toggle").click(function(){
       $("#more_details").toggle('fast');
     
});
   
});
</script>
</head>
<body>
<div id="container" align="center">
<h1>Orders</h1>
<p>
<div id='xmlreport'>
	<a href="GetOrderXml">Generate XML Report</a><br>
	</div>
<c:if test="${!empty allOrders}">
		<table class="data" border="1">
			<tr>
				
				<th>Order ID</th>
				<th>Customer ID</th>
				<th>Customer Name </th>
				<th>Order Date </th>
			</tr>
			
			<c:forEach items="${allOrders}" var="order">
				<tr>
					<td>${order.id}</td>
					<td>${order.customer.getId()}</td>
					<td>${order.customer.getFirstName()} ${order.customer.getLastName()}</td>
					<td>${order.orderDate.toString()}</td>
				</tr>
			</c:forEach>
		
		</table>
	</c:if>
	
	<input type="button" id="toggle" value="Show/Hide Details">
	<div id="more_details">
<c:if test="${!empty allOrders}">
		<table class="data" border="1">
			<tr>
				
				<th>Order ID</th>
				<th>Customer Name </th>
				<th>Product Names</th>
				
			</tr>
			
			<c:forEach items="${allOrders}" var="order">
				<tr>
					<td>${order.id}</td>
					<td>${order.customer.getFirstName()} ${order.customer.getLastName()}</td>
					<td> <c:forEach items="${order.product}" var="product">
						${product.getName() } <br>
					</c:forEach></td>
				</tr>
			</c:forEach>
		
		</table>
	</c:if>
	</div>
	

</div>
</body>
</html>