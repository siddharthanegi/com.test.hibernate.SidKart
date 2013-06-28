<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Order</title>
<script  src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"> </script>

<script type="text/javascript">
	function makeAjaxCall(){
		
		$.ajax({
			type : "GET",
			url : "getCustomerOrder",
			data : "inputField="+$('#inputField').val(),
			success : function(response){
				
				var obj=JSON.parse(response);
				alert(obj.length);
				var table_body="<tr><th>Order ID</th><th>Products</th><th>Order Date </th></tr><tr>";
				
		    	//alert(obj.length);
		    
		    	for(var i=0;i<obj.length;i++){
		    		table_body+="<tr><td>"+obj[i].id+"</td><td>";
		    		
		    		for(var j=0;j<obj[i].product.length;j++){
		    			
		    			table_body+=obj[i].product[j].name+"<br>";
		    			
		    		}
		    			table_body+="</td><td>"+obj[i].orderDate+"</td></tr>";
		    		
		    	}
		    	$('#results').html(table_body);
			},
			error : function(){
				alert("Bummer!");
			}
			
		
		});
	
		
	}
</script>
</head>
<body>
<div id='container'>
<div class='customer'>
<h1>Customer Order</h1>
Customer ID: <input type="text" id='inputField'>
<input type="button" value="Submit" onclick="makeAjaxCall();">
<div id='order_details'>
<table id='results'  border='1'></table>
</div> 
</div>
</div>

</body>
</html>