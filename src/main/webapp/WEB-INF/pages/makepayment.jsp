<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Payments</title>
</head>
<body>
<form:form action = "http://localhost:8080/springmvc.jdbc.website/makepayment" method="post">
Email <input type = "text" title="Please enter User Name" name="email" /><br><br>
Amount <input type = "number" title = "Please Enter Amount" name="amount" /><br>
<button type="submit" class="btn">Make Payment</button>
</form:form>
</body>
</html>