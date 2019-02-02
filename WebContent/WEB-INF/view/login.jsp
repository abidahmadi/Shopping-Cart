<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login</title>
<style>
body
{
	margin:0;
	padding:0;
	background: pink;
	background-size: cover;
	font-family: sans-serif;
	}
.title
{
	Text-align: center;
	Padding: 50px 0 20px;
}
.title h1
{
	Margin:0;
	Padding:0;
	Color:#1abc9c;
	Text-transform: uppercase;
	Font-size: 36px;
}
.container
{
	Width: 40%;
	Height: 400px;
	Background: #fff;
	Margin: 0 auto;
	Border: 2px solid #fff;
	Box-shadow: 0 15px 40px rgba(0,0,0,.5)
	}
.formBox
{ 
width:100%;
padding:80px 40px;
box-sizing: border-box;
height: 400px;
background:#1abc9c;
}
.formBox P
{
	margin: 0;
	padding: 0;
	font-weight: bold;
	color: #fff;
}
.formBox input
{ margin-bottom: 20px;
width: 100%;
}
.formBox input[type="text"],
.formBox input[type="password"]{
border: none;
border-bottom: 2px solid #a6af13;
outline: none;
height: 40px;
}
.formBox input[type="submit"],
.formBox input[type="reset"]{
border:none;
outline: none;
height: 40px;
color: #fff;
background: #262626;
cursor: pointer;
}
.formBox input[type="submit"]:hover,
.formBox input[type="reset"]:hover{
background: #a6af13;
}
.error{
background:red}
.msg{
background:red}
</style>
</head>
	<body>
		<div class="title"><h1>Log In Form</h1></div>
		<div class="container">
				<div class="formBox">
				<c:if test="${not empty msg }">
          <div class="msg">${msg}</div>
         </c:if>
				<form:form action="validateLogin" modelAttribute="user" method="POST">
				<form:errors path="username" cssClass="error" />
					<p>Username:</p> <form:input path="username" /><br>
					<form:errors path="password" cssClass="error"/>
		 			<p>Password:</p><form:input path ="password"/><br>
		 			<br>
	 				<input type="submit" name="action" value = "login">
					<input type="reset" value="Reset">
					<input type="hidden" name ="page" value="login">
				</form:form>
			</div>
		</div>
	</body>
</html>