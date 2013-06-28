<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
<script type="text/javascript">

$(document).ready(function(){
		$('#show-all-customers').hide();
     	$('#find-customer').hide();
});

function makeAjaxCall(){
	
	$.ajax({
		type : "GET" ,
		url : "findCustomerHandler",
		data : "choice="+$("input[type='radio'][name='choice']:checked").val()+"&searchParam="+$('#searchParam').val(),
	    success : function(response){
	    		var obj=JSON.parse(response);
	    		var table_body="<tr><th>Customer ID</th><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th></tr>";
	    	 		//alert(obj.length);
	    		
	    		if(obj.length == null){
	    			table_body+="<tr><td>"+obj.id+"</td><td>"+obj.firstName+"</td><td>"+obj.lastName+"</td><td>"+obj.street+"</td><td>"+obj.city+"</td></tr>";
	    		}
	    		
	    		else{
	    		for(var i=0;i<obj.length;i++){
	    		table_body+="<tr><td> "+obj[i].id+"</td><td>"+obj[i].firstName+"</td><td>"+obj[i].lastName+"</td><td>"+obj[i].street+"</td><td>"+obj[i].city+"</td></tr>";
	    		} 
	    		
	    		
	    		}
	    		$("#result").html(table_body);
	    },
		error : function(){
			alert("F@#k !");
		}		
		
	});
}


</script>

</head>
<body>
<div class='container'>
<div class='show-all'>
<input type="button" value="Show All Customers" onclick="$('#show-all-customers').toggle();">
<div id='show-all-customers'>
<c:if test="${!empty customerList}">
		<table class="data" border="1">
			<tr>
				<th>Customer ID</th>
				<th>First Name</th>
				<th>Last NAme</th>
				<th>Address</th>
				<th>City</th>

			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.street}</td>
					<td>${customer.city}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</div>
</div>
<br>
<div class='customer-query'>
<input type="button" value="Find Customer" onclick="$('#find-customer').toggle();">
<div id='find-customer'>
<form method="get" onsubmit="">
					<input type="radio" name="choice" checked value="1">ID &nbsp;
					<input type="radio" name="choice" value="2">Last Name &nbsp;
					<input type="radio" name="choice" value="3">City<br> 
					<input type="text" name="searchParam" id="searchParam" value="Search parameter according to selection.." onfocus="this.value=''">
					<br><input type="button" id="submit" onclick="makeAjaxCall();" value="Get Results">
					</form>




</div>
</div>
<div id='customer-detail'>
<table id='result' border='1'>

</table>
</div>




</div>

</body>
</html>