<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<div>
<form:form action = "http://localhost:8080/springmvc.jdbc.website/register" method = "post" modelAttribute = "user">
First Name<input type = "text" placeholder = "Please Enter First Name" name = "Firstname"/><br><br>
Last Name<input type = "text" placeholder = "Please Enter Last Name" name = "Lastname"/><br><br>
Mother's Maiden Name<input type = "text" placeholder = "Please Enter Maiden Name" name = "Maidenname"/><br><br>
Email<input type = "text" placeholder = "Please Enter Email" name = "Email"><br><br>
UserName <input type = "text" placeholder="Please enter User Name" name="Username" /><br><br>
Password <input type = "password" placeholder="" name="Password" /><br><br>
Phone<input type ="number" placeholder = "" name = "Phone"/><br><br>
<button type="submit" class="btn">Register</button> 
</form:form>
</div>
</body>
</html>