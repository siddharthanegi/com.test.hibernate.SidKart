<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success !</title>
</head>
<body>
<div id='container' align="center">
<h1>Order Successful !</h1>
<p> Thank you Mr. <b>${SessionCustomer.firstName}</b>, your order ID is <b>${OrderID}</b></p>
<a href="http://localhost:8080/SidKart/">Return to Homepage</a>
</div>
</body>

</html>