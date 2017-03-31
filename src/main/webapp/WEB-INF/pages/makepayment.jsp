<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Payments</title>
</head>
<body>
<form:form action = "http://localhost:8080/springmvc.jdbc.website/makepayment" method="post">
Email <input type = "text" placeholder="Please enter User Name" name="email" /><br><br>
Amount <input type = "number" placeholder = "Please Enter Amount" name="amount" /><br>
<button type="submit" class="btn">Make Payment</button>
</form:form>
</body>
</html>