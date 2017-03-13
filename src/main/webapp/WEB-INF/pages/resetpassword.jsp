<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
<form:form action="http://localhost:8080/springmvc.jdbc.website/resetpassword" method="post"><br>
<table> 
<tr>
<td>New Password</td>
<td align = "center"><input type = "password" placeholder = "New Password" name = "NewPassword"/></td>
</tr>

<tr>
<td>Confirm New Password</td>
<td align = "center"><input type = "password" placeholder = "Confirm Password" name = "ConfirmPassword"/></td>
</tr>
<tr>
<td align = "center"><button type = "submit" class = "btn" >Change Password</button></td>
</tr>
</table>
</form:form>
</body>
</html>