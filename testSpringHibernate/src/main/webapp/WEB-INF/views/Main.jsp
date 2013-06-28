<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SidKart-Main</title>
</head>
<body>
<div class='container'>
<header class='main-header'>
<div class='company-name'>
<h1><spring:message code="label.applicationName"/></h1>
</div>
</header>
<article>
<header class='welcome'>
<div class='welcome-div'>
<h2><spring:message code="label.welcome"/></h2>
</div>
</header>
<div class='welcome-admin-div'>
<p class='admin-login-btn'>
<input type="button" value='<spring:message code="label.admin"/>' onclick="window.location.href='admin'">
</p>
</div>
<div class='welcome-customer-div'>
<p class='customer-login-btn'>
<input type="button" value='<spring:message code="label.customer"/>' onclick="window.location.href='customer'">
</p>
</div>
<div id="language-select">
<a href="?lang=en">en</a> 
    | 
    <a href="?lang=hi">hi</a>
</div>
</article>
</div>

</body>
</html>