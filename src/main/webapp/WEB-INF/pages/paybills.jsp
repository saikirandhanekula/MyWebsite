<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Bills</title>
</head>
<body>
<form:form action="http://localhost:8080/springmvc.jdbc.website/paybills" method="post"><br>
Amount <input type = "number" placeholder = "Please Enter Amount" name = "Amount"/><br><br>
<button type = "submit" class = "btn">Pay Bill</button>
</form:form>
</body>
</html>