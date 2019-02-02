<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Save Item</title>
<style>
.content{
width: 300px;
    margin: auto;  
}
#items tr:hover {background-color: #ddd;}

</style>
</head>
<body>

<div class="content">
<h3>Add/Save Item</h3>
<form:form action="saveItem" modelAttribute="item" method="POST">
<form:hidden path="id"/>
<table id="items">
	<tbody>
		<tr>
			<td><label> Name:</label></td>
			<td><form:input path="name"/></td>
			</tr>
			<tr>
			<td><label> Brand :</label></td>
			<td><form:input path="brand"/></td>
			</tr>
			<tr>
			<td><label> Price :</label></td>
			<td><form:input path="price"/></td>
			</tr>
			<tr>
			<td><input type="submit" value="Save"/></td>
			</tr>
	</tbody>
</table>

</form:form>
	<div style="clear; bot;">
		<a href='list'>Back to List</a>
	</div>
	</div>
</body>
</html>