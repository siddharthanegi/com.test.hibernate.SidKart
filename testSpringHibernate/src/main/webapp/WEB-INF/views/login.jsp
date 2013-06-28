<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Login</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {
   $('#exist').show();
    $('#new').hide();
   $("#hideshow").click(function(){
       $("#exist").show();
      $("#new").hide();
});
     $("#newhideshow").click(function(){
      $("#exist").hide();
      $("#new").show();
});
});
</script>
</head>

<body>
<div id='container' align="center">
<p>
<b><input type='button' id='hideshow' value='<spring:message code="label.customer"/> <spring:message code="label.login"/>'></b><br>
<div id="exist">
<form action="checkCredentials" method="post">
<spring:message code="label.customer"/> ID: <input type="text" name="custId">
<input type="submit" value='<spring:message code="label.login"/>'>
</form>
</div>

<p><b><input type='button' id='newhideshow' value='<spring:message code="label.newCustomerRegistration"/>'></b><br>
<div id="new">
	<form action="customerRegistration" method="post">
<table>
	<tr>
		<td><spring:message code="label.firstName"/>:</td>
		<td> <input type="text" name="firstName"></td>
	</tr>
	<tr>
		<td><spring:message code="label.lastName"/>:</td>
		<td> <input type="text" name="lastName"></td>
	</tr>
	<tr>
		<td><spring:message code="label.street"/>:</td>
		<td> <input type="text" name="street"></td>
	</tr>
	<tr>
		<td><spring:message code="label.city"/>:</td>
		<td> <input type="text" name="city"></td>
	</tr>
	</table>
<input type="submit" value='<spring:message code="label.register"/>'>
</form>
</div>
<div id="language-select">
<a href="?lang=en">en</a> 
    | 
    <a href="?lang=hi">hi</a>
</div>

</div>
</body>
</html>