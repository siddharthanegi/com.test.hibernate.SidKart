<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<div id='container' align="center">
	<h1>Welcome</h1>
	<form method="get" action="control">
		<input type="radio" name="choice" value="add">Add Product<br>
		<input type="radio" name="choice" value="view" checked>List Products<br>
		<input type="radio" name="choice" value="find">Get Product by ID<br> 
		<input type="radio" name="choice" value="warehouse">Product Storage<br>
		<input type="radio" name="choice" value="customer">Customer Login<br>
		<input type="radio" name="choice" value="allorders">Orders<br>
		<input type="submit" value="Submit">
	</form>
</div>
</body>

</html>
