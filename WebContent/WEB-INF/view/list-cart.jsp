<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>
	Cart Items
	</title>
	<link type="text/css" 
rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
<div class="content">
	<h2>Cart Items</h2>
	<form action="processAddToCart" method="POST">
	<table id="items">
		<tr>
			<th>Item</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
		<c:forEach var="empItems" items="${items}">
   <c:set var="total" value="${total + empItems.getTotal()}" />
			<tr>
					<td>${empItems.name}</td>
					<td style="text-align: center">${empItems.quantity}</td>
					<td style="text-align:right">${empItems.getTotal()}</td>
			</tr>
			</tr>
			
		</c:forEach>
		<tr style="color:red"><td >Total: </td><td style="text-align:right" colspan="3">${total}</td>
	</table>
	<input type="button" value="Back To Items" onclick="window.location.href='list'; return false;"
	class="add-button"/>
			<input type="button" value="Check Out" onclick="window.location.href='thank-you'; return false;"
	class="add-button"/>
	</form>
	
</div>

</body>

</html>