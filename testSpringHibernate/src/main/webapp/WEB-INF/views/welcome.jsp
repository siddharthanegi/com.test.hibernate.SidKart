<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"></script>
<script type="text/javascript">
function makeAjaxCall(){
	
	$.ajax({
		type : "GET" ,
		url : "getCustomerOrder",
	    success : function(response){
	    	
	    	var obj=JSON.parse(response);
	    	//alert(obj[0].id);
	    	if(obj.length == 0)
	    		$("#result").html("<b>No Order !</b>");
	    	else{
	    	var table_body="<tr><th><spring:message code="label.order"/> ID</th><th><spring:message code="label.product"/></th><th><spring:message code="label.order"/> <spring:message code="label.date"/> </th></tr><tr>";
		    
	    	alert(obj.length);
	    
	    	for(var i=0;i<obj.length;i++){
	    		table_body+="<tr><td>"+obj[i].id+"</td><td>";
	    		
	    		for(var j=0;j<obj[i].product.length;j++){
	    			
	    			table_body+=obj[i].product[j].name+"<br>";
	    			
	    		}
	    			table_body+="</td><td>"+obj[i].orderDate+"</td></tr>";
	    		
	    	}
	    	$("#results").html(table_body);
	    	}
	    	
	    	
	    	
			
	    },
		error : function(){
			alert("F@#k !");
		}		
		
	});
}
</script>
</head>
<body>
<div id='container' >
<h1><spring:message code="label.welcome"/> ${SessionCustomer.firstName }!</h1>
<p>

<input type="button" id="getPreviousOrders" value='<spring:message code="label.showPreviousOrders"/>' onclick="makeAjaxCall();"><br>

<div id='result'>
<table id='results' border='1'></table>
</div>
<br>
<table>
<tr><td><input type="button" onclick="location.href='customer/Browse'" value='<spring:message code="label.browse"/> <spring:message code="label.product"/>'></td></tr>
<tr><td><input type="button" onclick="location.href='customer/productDisplay'" value='<spring:message code="label.buy"/> <spring:message code="label.product"/>'></td></tr>
</table>
</div>





</body>
</html>