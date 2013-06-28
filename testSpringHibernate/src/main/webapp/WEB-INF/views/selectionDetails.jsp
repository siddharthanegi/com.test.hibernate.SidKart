<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.order"/> <spring:message code="label.details"/></title>
</head>
<body>
<div id='container' align="center">
<h1><spring:message code="label.order"/> <spring:message code="label.details"/></h1>
<p><b><spring:message code="label.dear"/> ${custName},</b><br>
<div id='error4'>

<c:if test="${error ==1}">
<p><b>PLEASE ENTER CORRECT QUANTITY</b></p>
</c:if>

</div>
<form method="POST" action="placeOrder">
<c:if test="${!empty SelectedProducts}">
		<table class="data" border="1">
			<tr>
				
				<th><spring:message code="label.product"/> ID</th>
				<th><spring:message code="label.product"/></th>
				<th><spring:message code="label.quantityAvailable"/></th>
				<th><spring:message code="label.quantity"/></th>
			</tr>
			
			<c:forEach items="${SelectedProducts}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.quantity}</td>
					<td><input type="text" name="orderQty"></td>
				</tr>
			</c:forEach>
		
		</table>
	</c:if>
	<input type="submit" value="Place Order">
</form>
</div>
</body>
</html>