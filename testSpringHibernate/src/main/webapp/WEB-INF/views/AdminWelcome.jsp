<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.welcome"/>-<spring:message code="label.admin"/></title>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"> </script>
<script type="text/javascript">

$(document).ready(function(){
	$('#p-options').hide();
	$('#c-options').hide();
	$.ajax({
		type:"GET",
		url: "admin/Today",
		success:function(response){
			var obj=JSON.parse(response);
			if(obj.length==0)
				$('.today-order').append("<br><b>No Orders Today !</b>");
			else{
			var table_body="<tr><th><spring:message code="label.order"/> ID</th><th><spring:message code="label.customer"/> ID</th><th><spring:message code="label.customer"/></th><th><spring:message code="label.order"/> <spring:message code="label.date"/></th></tr>";
			$.each(obj,function(){
				var table_row="";
					$.each(this,function(k,v){
					    if(k=="id" || k=="orderDate")
						    table_row+="<td>"+v+"</td>";
						if(k=="customer"){
							table_row+="<td>"+v.id+"</td>";
							table_row+="<td>"+v.firstName+" "+v.lastName +"</td>";
						}
						
							
					});
					
					table_body+="<tr>"+table_row+"</tr>"; 
						
			});

			$("#resultTable").html(table_body);
			}
		},
		
	
	});

}
);


function pOptionToggle(){
	$('#p-options').toggle();
	$('#c-options').hide();
}

function cOptionToggle(){
	$('#c-options').toggle();
	$('#p-options').hide();
}




</script>
</head>
<body>
	<div class='container'>
		<h1><spring:message code="label.welcome"/> <spring:message code="label.admin"/></h1>

		<div class='today-order'>
			<input type="button" value="<spring:message code="label.todaysOrders"/>" onclick="todayOrders();">
			<div id='order'></div>
			<table id='resultTable' border='1'></table>
				
		</div>
		<br>
		<div class='product'>
			<input type="button" value="<spring:message code="label.product"/> <spring:message code="label.management"/>" onclick="pOptionToggle();">
			<div id='p-options'>
				<form method="get" action="admin/pro_choice">
					<input type="radio" name="pChoice" checked value="1"><spring:message code="label.listAll"/><br>
					<input type="radio" name="pChoice" value="2"><spring:message code="label.addProduct"/><br>
<!-- 					<input type="radio" name="pChoice" value="3">Delete Products<br> -->
					<input type="radio" name="pChoice" value="4"><spring:message code="label.warehouseLocation"/><br>
					<input type="submit" value="Submit">
					</form>
			</div>
			</div>
		<br>
		
		<div class='customer'>
			<input type="button" value="<spring:message code="label.customer"/> <spring:message code="label.management"/>" onclick="cOptionToggle();">
			<div id='c-options'>
				<form method="get" action="admin/cust_choice">
					<input type="radio" name="cChoice" value="1"><spring:message code="label.customer"/> <spring:message code="label.details"/><br>
					<input type="radio" name="cChoice" value="2"><spring:message code="label.customer"/> <spring:message code="label.order"/><br>
					<input type="radio" name="cChoice" value="3"><spring:message code="label.allOrders"/><br>
<!-- 					<input type="radio" name="cChoice" value="4">Delete Orders<br> -->
					<input type="submit" value="Submit">
			</form>
			</div>
		</div>
		<div id="language-select">
<a href="?lang=en">en</a> 
    | 
    <a href="?lang=hi">hi</a>
</div>
		</div>
</body>
</html>