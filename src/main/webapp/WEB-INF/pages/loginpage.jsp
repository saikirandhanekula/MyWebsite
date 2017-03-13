<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<div>
Login
<form:form action="http://localhost:8080/springmvc.jdbc.website/login" method="post"><br>
UserName <input type = "text" placeholder="Please enter User Name" name="Username" /><br><br>
Password <input type = "password" placeholder="Please enter Password" name="Password" /><br><br>
<button type="submit" class="btn">Login</button> <br><br>
</form:form>
</div>
<a href = "http://localhost:8080/springmvc.jdbc.website/UsernameValidationPage" onclick="UsernameValidationPage.jsp" target="UsernameValidationPage.jsp">Forgot Password?</a> <br><br>
<a href = "http://localhost:8080/springmvc.jdbc.website/register" onclick="register.jsp" target="register.jsp">Register</a> <br><br>
</body>
</html>