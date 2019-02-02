<%@include file="header.jsp"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<title>List of Items</title>
<link type="text/css" 
rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<ul>
  <li><a href='logout'>Log Out</a></li>
  <li><a href='help'>Help</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#about">About</a></li>
</ul>

	

<div id="container" >	
		<div class="content">
		<h2>Item list</h2>
	<input type="button" value="Add Item" onclick="window.location.href='showFormForAdd'; return false;"
	class="add-button"/>
	<form action="processAddToCart" method="POST">
	<table id="items">
		<tr>
			<th></th>
			<th>Name</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Action</th>
		
		</tr>
		<c:forEach var="empItems" items="${items}">
			<c:url var="updateLink" value="showFormForUpdate">
			<c:param name="itemId" value="${empItems.id}"/>
			</c:url>
			
			<c:url var="deleteLink" value="delete">
			<c:param name="itemId" value="${empItems.id}"/>
			</c:url>
			<tr>
					<td><input type="checkbox" name="ckbx" value="${empItems.id}">
					<td>${empItems.name}</td>
					<td>${empItems.brand}</td>
					<td>${empItems.price}</td>
					<td><input type="text" name="qty${empItems.id}">
					<td> <a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="submit" name="action" value="Add To Cart" >
			<input type="submit" name="action" value="Check Out">
	</div>
	</form>
</div>
</body>
<%@include file="footer.jsp"%> 
</html>