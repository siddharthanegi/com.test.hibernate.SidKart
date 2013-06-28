<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Products</title>
</head>
<body>
<div id='container' align="center">
<h1><spring:message code="label.selectProducts"/> </h1>
<p>
<form method="post"  action="${custID }/selection">
	<c:if test="${!empty productList}">
		<table class="data" border="1">
			<tr>
				<th>Pick</th>
				<th><spring:message code="label.product"/> ID</th>
				<th><spring:message code="label.product"/></th>
				

			</tr>
			
			<c:forEach items="${productList}" var="product">
				<tr>
					<td><input type="checkbox" name="selection" value="${product.id}"></td>		
					<td>${product.id}</td>
					<td>${product.name}</td>
					
				</tr>
			</c:forEach>
		
		</table>
	</c:if>
<input type="submit" value='<spring:message code="label.buy"/>'>
</form>

</div>
</body>
</html>