<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Record</title>
</head>
<body>
<div id='container'>

<form method="post" action="feed">
<table>
<tr><td>Name</td><td> <input type="text" name="name"></td></tr>
<tr><td>Quantity</td><td><input type="text" name="quantity"></td></tr>
<tr><td>Category</td><td><input type="text" name="category"></td></tr>
<tr><td>Price</td><td><input type="text" name="price"></td></tr>
<!-- Warehouse Location: <input type="text" name="cityName"><br> -->
<tr><td>Warehouse</td><td><select id='ware_loc' name="cityName">
				 <c:forEach items="${warehouses}" var="warehouse">
					<option value="${warehouse.getCname()}">${warehouse.getCname()}</option>
				</c:forEach>
				</select></td></tr>
</table>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>