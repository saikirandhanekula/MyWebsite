<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<div>
<form:form action = "http://localhost:8080/springmvc.jdbc.website/register" method = "post" modelAttribute = "user">
First Name<input type = "text" title = "Please Enter First Name" name = "Firstname"/><br><br>
Last Name<input type = "text" title = "Please Enter Last Name" name = "Lastname"/><br><br>
Mother's Maiden Name<input type = "text" title = "Please Enter Maiden Name" name = "Maidenname"/><br><br>
Email<input type = "text" title = "Please Enter Email" name = "Email"><br><br>
UserName <input type = "text" title="Please enter User Name" name="Username" /><br><br>
Password <input type = "password" title="Please enter Password" name="Password" /><br><br>
Phone<input type ="number" title = "Please Enter Phone Number" name = "Phone"/><br><br>
<button type="submit" class="btn">Register</button> 
</form:form>
</div>
</body>
</html>