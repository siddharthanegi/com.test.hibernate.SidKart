<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Browse</title>

<script type="text/javascript">

function makeAjaxCall(){
	
	$.ajax({
	
		type:"GET",
		url:"BrowseProduct",
		data:"category="+$('#category').val()+"&price="+$('#price').val(),
		success:function(response){
		//	alert("wohoo!");
			var obj=JSON.parse(response);
			var table_body="<tr><th><spring:message code="label.product"/>  ID</th><th><spring:message code="label.product"/></th><th><spring:message code="label.quantityAvailable"/></th><th><spring:message code="label.price"/></th></tr>";
			$.each(obj,function(){
				var table_row="";
					$.each(this,function(k,v){
					 if(k=="id" || k=="name" || k=="quantity" || k=="price")
						table_row+="<td>"+v+"</td>";
					});
					
					table_body+="<tr>"+table_row+"</tr>"; 
						
			});

			$("#resultTable").html(table_body);
		}
		
		
	});
	
	
	
}
</script>
</head>
<body>
	<div class='container'>
		<h1><spring:message code="label.applicationName"/></h1>
		<h2><spring:message code="label.product"/></h2>
		<div class='browse-by'>
			<spring:message code="label.category"/> : <select id='category'>
				<option value="all">All</option>
				<c:forEach items="${categories}" var="category">
					<option value="${category.category }">${category.category}</option>
				</c:forEach>
			</select> <br> <spring:message code="label.price"/> : <select id='price'>
				<option value="0">All</option>
				<option value="500">0 - 500</option>
				<option value="1000">500 - 1000</option>
				<option value="2000">1000 - 2000</option>
				<option value="3000">2000 - 3000</option>
				<option value="5000">3000 - 5000</option>
				<option value="50000">&gt; 5000</option>
			</select>
		</div>
		<input type="button" value='<spring:message code="label.browse"/>' id='browseBtn'
			onclick="makeAjaxCall();">
		<div class='results'>
			<table id='resultTable' class='data' border='1'>


			</table>
		</div>
	</div>

</body>
</html>