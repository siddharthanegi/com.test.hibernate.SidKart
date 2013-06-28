<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse Locations</title>
</head>
<body>
<h1>SidKart</h1>
<h2>Add Location</h2>
<div id='container' >
<form action="insertLocation" method="post">
<b>Location:</b> <input type="text" name="location">
<input type="submit" value="Add">
</form>


<a href="http://localhost:8080/SidKart">Go Home!</a>
</div>
</body>
</html>